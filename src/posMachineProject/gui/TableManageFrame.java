package posMachineProject.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.TableVO;
import gui.util.CreateComponentUtil;
import posMachineProejct.manager.TableManager;
import posMachineProejct.manager.TablePagingManager;

public class TableManageFrame extends FrameTemplate implements Runnable{
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	TableManager tm = new TableManager();
	TablePagingManager tpm = new TablePagingManager(tm);
	
	JPanel mainPanel;
	JPanel timePanel;
	
	JPanel numberListPanel;
	ArrayList<JPanel> tablePanelList;
	
	JLabel title;		
	JLabel time;
	JLabel page;
	
	List<JButton> tableButtonList;
	List<String> tableStatusList;
	
	JButton gobackButton;
	JButton tableAddBtn;
	JButton tableDelBtn;
	JButton tableMoveBtn;
	JButton PrePageMove;
	JButton NextPageMove;
	JButton selectedBtn;
	/**
	 * pageStatus == 0 : setting status,
	 * pageStatus == 1 : select table status
	 * pageStatus == 2 : changing table status
	**/
	int pageStatus;
	int fromTableNum;
	int toTableNum;
	JButton fromTable;
	JButton toTable;
	
	Color bc = new Color(27, 156, 252);
	Color cc = new Color(241, 196, 15);
	Color dc = Color.GREEN;
	public TableManageFrame() {
		init();
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	@Override
	public void initComponent() {
		pageStatus = 0;
		tableButtonList = new ArrayList<JButton>();
		tablePanelList = new ArrayList<JPanel>();
		tableStatusList = new ArrayList<String>();
		
		tableStatusList = tm.selectTableStatusList();
		mainPanel = new JPanel();
		ccUtil.setMainPanel(mainPanel);
		
		timePanel=(JPanel)  ccUtil.createJcomponent("p", width*23/100,height*5/100, 50, 50);
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		time.setFont(new Font("맑은고딕",Font.BOLD, 15));		
		
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		time.setFont(new Font("맑은고딕",Font.BOLD, 15));
		
		
		title=(JLabel) ccUtil.createJcomponent("l", 200, 50,435, 25);
		page=(JLabel) ccUtil.createJcomponent("l", 70, 40, 479, 490);
		page.setFont(new Font("맑은고딕",Font.BOLD, 18));
		
		tableAddBtn=(JButton) ccUtil.createJcomponent("b",100, 40, 400, 50);
		tableAddBtn.setText("<html><div style='text-align:center'>테이블추가</div></html>");
		
		tableDelBtn=(JButton) ccUtil.createJcomponent("b",100, 40, 520, 50);
		tableDelBtn.setText("<html><div style='text-align:center'>테이블삭제</div></html>");
		PrePageMove= (JButton) ccUtil.createJcomponent("bw",50, 30, 20, 260);
		NextPageMove= (JButton) ccUtil.createJcomponent("be",50, 30, 915, 260);
		
		tableMoveBtn=(JButton) ccUtil.createJcomponent("b",100, 40, 640, 50);
		tableMoveBtn.setText("<html><div style='text-align:center'>테이블이동</div></html>");
		
		gobackButton = (JButton) ccUtil.createJcomponent("b",100, 40, 800, 50);
		gobackButton.setText("<html><div style='text-align:center'>뒤로가기</div></html>");
		numberListPanel=(JPanel) ccUtil.createJcomponent("p", 810, 370, 85, 100);
		numberListPanel.setLayout(null);
		numberListPanel.setBackground(new Color(223, 228, 234));
		
		List<TableVO> tableList = tm.selectTableList();
		for(int i =0; i < tpm.getTotalTableCount(); i++)
		{
			
			JButton tmpButton = new JButton(tableList.get(i).getTableNumber()+"번 TABLE");
			tmpButton.setPreferredSize(new Dimension(150, 100));
			tmpButton.setVerticalAlignment(SwingConstants.TOP);
			if(tableStatusList.get(i).equals("Y")) {
				tmpButton.setBackground(dc);
			} else {
				tmpButton.setBackground(bc);
			}
			tmpButton.setFont(new Font("맑은고딕",Font.BOLD, 16));	
			tmpButton.setForeground(Color.white);
			tableButtonList.add(tmpButton);
		}
		

		
	}
	@Override
	public void addGui() {
		this.add(mainPanel);

		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(223, 228, 234));
		mainPanel.add(timePanel);
		timePanel.add(time);
		timePanel.setBackground(new Color(116, 125, 140));
		
		
		mainPanel.add(PrePageMove);
		mainPanel.add(numberListPanel);
		mainPanel.add(NextPageMove);

		mainPanel.add(tableAddBtn);
		mainPanel.add(tableDelBtn);
		mainPanel.add(tableMoveBtn);
		mainPanel.add(gobackButton);
		mainPanel.add(page);
			
		mainPanel.add(title);
		title.setForeground(Color.white);
		title.setFont(new Font("맑은고딕",Font.BOLD, 20));


		for(int i = 0 ; i < tpm.getTotalPageCount(); i++)
		{
			JPanel tmpJPanel = (JPanel) ccUtil.createJcomponent("p", 800, 345, 5, 5);
			tmpJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 9, 15));
			//������ �г��� �ƴ� ���
			if(i != tpm.getTotalPageCount()-1)
			{
				//�������� ��ư ������ �г� ����
				for(int j=0; j < tpm.getTablePerPage(); j++)
				{
					tmpJPanel.add(tableButtonList.get(j+(i*15)));
					
				}
			//������ �г��� ���
			}else {
				//��ü ���̺�� / �������� ���̺�� �� ������ �������� ���� ��� 
				if(tpm.getTotalTableCount() % tpm.getTablePerPage() != 0)
				{
					//���¹�ư���� �г� ����
					for(int j=0; j < tpm.getTotalTableCount() % tpm.getTablePerPage(); j++)
					{
						tmpJPanel.add(tableButtonList.get(j+(i*15)));
					}
				//��ü ���̺�� / �������� ���̺�� �� ������ ���������
				} else {
					for(int j=0; j < tpm.getTablePerPage(); j++)
					{
						tmpJPanel.add(tableButtonList.get(j+(i*15)));
					}
				}
			}
			tablePanelList.add(tmpJPanel);
			if(i==0)
			{
				numberListPanel.add(tmpJPanel);
				page.setText(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
			}
		}
		
	}
	@Override
	public void run() {
		while(true) {
			Calendar t = Calendar.getInstance();
			int year = t.get(Calendar.YEAR);
			int month = t.get(Calendar.MONTH)+1;
			int date = t.get(Calendar.DATE);
			int amPm = t.get(Calendar.AM_PM);
			int hour = t.get(Calendar.HOUR);
			int min = t.get(Calendar.MINUTE);
			int sec = (t.get(Calendar.SECOND) < 10) ? 0 + t.get(Calendar.SECOND) : t.get(Calendar.SECOND);
			String ampm=amPm==Calendar.AM? "AM":"PM";
				
							
			if((min<10) && (sec<10)) {
				String day1 = (year +"년 " + month + "월 " + date + "일 " + ampm + " " + hour + ":0" + min + ":0" + sec );
				time.setText(day1);
			} else if((min>10) && (sec<10)) {
				String day2 = (year +"년 " + month + "월 " + date + "일 " + ampm + " " + hour + ":" + min + ":0" + sec );
				time.setText(day2);
			} else if((min<10) && (sec>10)) {
				String day3 = (year +"년 " + month + "월 " + date + "일 " + ampm + " " + hour + ":0" + min + ":" + sec );
				time.setText(day3);
			} else {
				String day4 = (year +"년 " + month + "월 " + date + "일 " + ampm + " " + hour + ":" + min + ":" + sec );
				time.setText(day4);
			}
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
				
		}
	
	
	@Override
	public void initEvent() {
		gobackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
            	pageManager.goMainPage();	
			}
		});
		for(int i =0; i <tableButtonList.size(); i++)
		{
			int tableNum = i+1;
			tableButtonList.get(i).addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(pageStatus == 0) {
						if(tableStatusList.get(tableNum-1).equals("Y"))
						{
							JButton settingTable = (JButton)e.getSource();
							JOptionPane.showMessageDialog(null, "테이블 세팅이 헤제되었습니다.");
							tm.unSettingTable(tableNum);
							settingTable.setBackground(bc);
							tableStatusList.add(tableNum-1,"N");
						}else {
							JButton settingTable = (JButton)e.getSource();
							JOptionPane.showMessageDialog(null, "테이블이 세팅되었습니다.");
							tm.settingTable(tableNum);
							settingTable.setBackground(dc);
							tableStatusList.add(tableNum-1,"Y");
						}
					}else if(pageStatus == 1) {
						if(tableStatusList.get(tableNum-1).equals("N")) {
							JOptionPane.showMessageDialog(null, "세팅 되어 있는 테이블만 이동이 가능합니다.");
						} else {
							fromTable = (JButton)e.getSource();
							JOptionPane.showMessageDialog(null, "이동될 테이블을 선택해주세요.");
							fromTableNum = tableNum;
							fromTable.setBackground(cc);
							pageStatus = 2;
						}
					}else {
						if(tableStatusList.get(tableNum-1).equals("Y")) {
							JOptionPane.showMessageDialog(null, "세팅 되어 있는 테이블에는 이동 할 수 없습니다.");
						} else {
							toTable = (JButton)e.getSource();
							toTable.setBackground(cc);
							JOptionPane.showMessageDialog(null, "테이블이 이동되었습니다.");
							toTableNum = tableNum;
							fromTable.setBackground(bc);
							toTable.setBackground(dc);
							
							tm.moveTable(fromTableNum, toTableNum);
							tableStatusList.add(fromTableNum-1,"N");
							tableStatusList.add(toTableNum-1,"Y");
							
							pageStatus = 0;
						}
					}
				}
			});
		}
		
		tableAddBtn.addMouseListener(new MouseAdapter() {
		      
			public void mouseClicked(MouseEvent e) {
				
				//when this page is not last page
				if(tpm.getCurruntPage() != tpm.getTotalPageCount())
				{
					JPanel tmpJPanel = tablePanelList.get(tpm.getTotalPageCount()-1);

					tm.insertTable(tpm.getTotalTableCount()+1);
					tableStatusList.add("N");
					tpm.setTotalTableCount(tpm.getTotalTableCount()+1);
					JButton tmpButton = new JButton(tpm.getTotalTableCount()+"번 TABLE");
					tmpButton.setPreferredSize(new Dimension(150, 100));
					tmpButton.setVerticalAlignment(SwingConstants.TOP);
					tmpButton.setBackground(bc);
					tmpButton.setFont(new Font("맑은고딕",Font.BOLD, 16));	
					tmpButton.setForeground(Color.white);
					tableButtonList.add(tmpButton);
					tmpJPanel.add(tmpButton);
					//repaint current panel
					numberListPanel.remove(tablePanelList.get(tpm.getCurruntPage()-1));
					numberListPanel.add(tablePanelList.get(tpm.getLastPage()-1));
					page.setText(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
				
					repaint();
					numberListPanel.setVisible(false);
					numberListPanel.setVisible(true);
				}else {
					//add table in database and init tmpButton
					tm.insertTable(tpm.getTotalTableCount()+1);
					tableStatusList.add("N");
					tpm.setTotalTableCount(tpm.getTotalTableCount()+1);
					tpm.setTotalPageCount();
					JPanel tmpJPanel;
					try {
						tmpJPanel = tablePanelList.get(tpm.getTotalPageCount()-1);
					}catch(IndexOutOfBoundsException ioobe)
					{
						tmpJPanel = null;
					}
					//if is the last pagePanel then show last pagePanel
					if(tmpJPanel != null) {
						JButton tmpButton = new JButton(tpm.getTotalTableCount()+"번 TABLE");
						tmpButton.setPreferredSize(new Dimension(150, 100));
						tmpButton.setVerticalAlignment(SwingConstants.TOP);
						tmpButton.setBackground(bc);
						tmpButton.setFont(new Font("맑은고딕",Font.BOLD, 16));	
						tmpButton.setForeground(Color.white);
						tableButtonList.add(tmpButton);
						JPanel tmpPanel = tablePanelList.get(tpm.getLastPage()-1);
						tmpPanel.add(tmpButton);
					//else init last pagePanel
					} else {
						tmpJPanel = (JPanel) ccUtil.createJcomponent("p", 800, 345, 5, 5);
						tmpJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 9, 15));
						JButton tmpButton = new JButton(tpm.getTotalTableCount()+"�� TABLE");
						tmpButton.setPreferredSize(new Dimension(150, 100));
						tmpButton.setVerticalAlignment(SwingConstants.TOP);
						tmpButton.setBackground(bc);
						tmpButton.setFont(new Font("맑은고딕",Font.BOLD, 16));	
						tmpButton.setForeground(Color.white);
						tableButtonList.add(tmpButton);
						tmpJPanel.add(tmpButton);
						
						tablePanelList.add(tmpJPanel);
					}
					//repaint current panel
					System.out.println(tpm.getCurruntPage());
					numberListPanel.remove(tablePanelList.get(tpm.getCurruntPage()-1));
					numberListPanel.add(tmpJPanel);
					page.setText(tpm.getTotalPageCount() + " / " + tpm.getTotalPageCount());
					repaint();
					numberListPanel.setVisible(false);
					numberListPanel.setVisible(true);
				}
			}
			  
		});
		
		tableDelBtn.addMouseListener(new MouseAdapter() { 
			
			public void mouseClicked(MouseEvent e) {
				//when this page is not last page
				if(tpm.getCurruntPage() != tpm.getTotalPageCount())
				{
					JPanel tmpJPanel = tablePanelList.get(tpm.getTotalPageCount()-1);
					tm.deleteTable(tpm.getTotalTableCount());
					tableStatusList.remove(tpm.getTotalTableCount()-1);
					tpm.setTotalTableCount(tpm.getTotalTableCount()-1);
					tpm.setTotalPageCount();
					tableButtonList.remove(tableButtonList.size()-1);
					//repaint current panel
					numberListPanel.remove(tablePanelList.get(tpm.getCurruntPage()-1));
					numberListPanel.add(tablePanelList.get(tpm.getLastPage()-1));
					System.out.println(tpm.getLastPage());
					page.setText(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
					repaint();
					numberListPanel.setVisible(false);
					numberListPanel.setVisible(true);
				}else {
					//delete table in database
					tm.deleteTable(tpm.getTotalTableCount());
					tableStatusList.remove(tpm.getTotalTableCount()-1);
					tpm.setTotalTableCount(tpm.getTotalTableCount()-1);
					tpm.setTotalPageCount();
					JPanel tmpJPanel;
					try {
						tmpJPanel = tablePanelList.get(tpm.getTotalPageCount()-1);
					}catch(IndexOutOfBoundsException ioobe)
					{
						tmpJPanel = null;
					}
					//if is the last pagePanel then show last pagePanel
					if(tmpJPanel != null) {
						tmpJPanel.remove(tableButtonList.remove(tableButtonList.size()-1));
					//else init last pagePanel
					} else {
						JOptionPane.showMessageDialog(null, "더 이상 삭제할 테이블이 없습니다.");
					}
					//repaint current panel
					numberListPanel.remove(tablePanelList.get(tablePanelList.size()-1));
					numberListPanel.add(tmpJPanel);
					
					//if last page not equals repaint Panel 
					if(!tablePanelList.get(tablePanelList.size()-1).equals(tmpJPanel))
					{
						tpm.getPrevPage();
						tablePanelList.remove(tablePanelList.size()-1);
					}
					page.setText(tpm.getTotalPageCount() + " / " + tpm.getTotalPageCount());
					numberListPanel.repaint();
					numberListPanel.setVisible(false);
					numberListPanel.setVisible(true);
				}
			}
		});
	 
		
		tableMoveBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(pageStatus ==0)
				{
					JOptionPane.showMessageDialog(null, "이동할 테이블을 선택해주세요.");
					pageStatus = 1;
				}else {
					JOptionPane.showMessageDialog(null, "테이블 이동을 해제합니다.");
					pageStatus = 0;
				}
			}
		});
		PrePageMove.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				numberListPanel.remove(tablePanelList.get(tpm.getCurruntPage()-1));
				numberListPanel.add(tablePanelList.get(tpm.getPrevPage()-1));
				page.setText(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
				repaint();
			}
		});
		
		NextPageMove.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				numberListPanel.remove(tablePanelList.get(tpm.getCurruntPage()-1));
				numberListPanel.add(tablePanelList.get(tpm.getNextPage()-1));
				page.setText(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
				repaint();
			}
		});
	}

}
	