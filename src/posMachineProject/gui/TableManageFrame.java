package posMachineProject.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
	

	JButton tableAddBtn;
	JButton tableDelBtn;
	JButton tableMoveBtn;
	JButton PrePageMove;
	JButton NextPageMove;
	JButton selectedBtn;
	Color bc = new Color(27, 156, 252);
	Color cc = new Color(241, 196, 15);
	public TableManageFrame() {
		init();
	}
	
	@Override
	public void initComponent() {
		tableButtonList = new ArrayList<JButton>();
		tablePanelList = new ArrayList<JPanel>();
		
		mainPanel = new JPanel();
		ccUtil.setMainPanel(mainPanel);
		
		timePanel=(JPanel)  ccUtil.createJcomponent("p", width*23/100,height*5/100, 50, 50);
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		time.setFont(new Font("�������",Font.BOLD, 15));		
		
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		time.setFont(new Font("�������",Font.BOLD, 15));
		
		
		title=(JLabel) ccUtil.createJcomponent("l", 200, 50,435, 25);
		page=(JLabel) ccUtil.createJcomponent("l", 70, 40, 479, 490);
		page.setFont(new Font("�������",Font.BOLD, 18));

		
		tableAddBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 560, 50);
		tableAddBtn.setText("���̺� �߰�");
		
		tableDelBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 680, 50);
		tableDelBtn.setText("���̺� ����");
		PrePageMove= (JButton) ccUtil.createJcomponent("bw",50, 30, 20, 260);
		NextPageMove= (JButton) ccUtil.createJcomponent("be",50, 30, 915, 260);
		
		tableMoveBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 800, 50);
		tableMoveBtn.setText("���̺� �̵�");
		numberListPanel=(JPanel) ccUtil.createJcomponent("p", 810, 370, 85, 100);
		numberListPanel.setLayout(null);
		numberListPanel.setBackground(new Color(223, 228, 234));
		
		List<TableVO> tableList = tm.selectTableList();
		for(int i =0; i < tpm.getTotalTableCount(); i++)
		{
			
			JButton tmpButton = new JButton(tableList.get(i).getTableNumber()+"�� TABLE");
			tmpButton.setPreferredSize(new Dimension(150, 100));
			tmpButton.setVerticalAlignment(SwingConstants.TOP);
			tmpButton.setBackground(bc);
			tmpButton.setFont(new Font("�������",Font.BOLD, 16));	
			tmpButton.setForeground(Color.white);
			tableButtonList.add(tmpButton);
		}
		/*
		 * ;
		 * numberListPanel_2=(JPanel) 
		 * numberListPanel_3=(JPanel) ccUtil.createJcomponent("p", 800, 345, 5, 5);
		 * numberListPanel_4=(JPanel) ccUtil.createJcomponent("p", 800, 345, 5, 5);
		 */

		

		
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
		mainPanel.add(page);
			
		mainPanel.add(title);
		title.setForeground(Color.white);
		title.setFont(new Font("�������",Font.BOLD, 20));


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
				String day1 = (year +"�� " + month + "�� " + date + "�� " + ampm + " " + hour + ":0" + min + ":0" + sec );
				time.setText(day1);
			} else if((min>10) && (sec<10)) {
				String day2 = (year +"�� " + month + "�� " + date + "�� " + ampm + " " + hour + ":" + min + ":0" + sec );
				time.setText(day2);
			} else if((min<10) && (sec>10)) {
				String day3 = (year +"�� " + month + "�� " + date + "�� " + ampm + " " + hour + ":0" + min + ":" + sec );
				time.setText(day3);
			} else {
				String day4 = (year +"�� " + month + "�� " + date + "�� " + ampm + " " + hour + ":" + min + ":" + sec );
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
		
		tableAddBtn.addMouseListener(new MouseAdapter() {
		      
			public void mouseClicked(MouseEvent e) {
				
				//when this page is not last page
				if(tpm.getCurruntPage() != tpm.getTotalPageCount())
				{
					JPanel tmpJPanel = tablePanelList.get(tpm.getTotalPageCount()-1);

					tm.insertTable(tpm.getTotalTableCount()+1);
					tpm.setTotalTableCount(tpm.getTotalTableCount()+1);
					JButton tmpButton = new JButton(tpm.getTotalTableCount()+"�� TABLE");
					tmpButton.setPreferredSize(new Dimension(150, 100));
					tmpButton.setVerticalAlignment(SwingConstants.TOP);
					tmpButton.setBackground(bc);
					tmpButton.setFont(new Font("�������",Font.BOLD, 16));	
					tmpButton.setForeground(Color.white);
					tableButtonList.add(tmpButton);
					tmpJPanel.add(tmpButton);
					//repaint current panel
					numberListPanel.remove(tablePanelList.get(tpm.getCurruntPage()-1));
					numberListPanel.add(tablePanelList.get(tpm.getLastPage()-1));
					System.out.println(tpm.getLastPage()-1);
					page.setText(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
				
					repaint();
					numberListPanel.setVisible(false);
					numberListPanel.setVisible(true);
				}else {
					//add table in database and init tmpButton
					tm.insertTable(tpm.getTotalTableCount()+1);
					tpm.setTotalTableCount(tpm.getTotalTableCount()+1);
					tpm.setTotalPageCount();
					JPanel tmpJPanel;
					try {
						tmpJPanel = tablePanelList.get(tpm.getTotalPageCount()-1);
					}catch(IndexOutOfBoundsException ioobe)
					{
						tmpJPanel = null;
					}
					System.out.println(tmpJPanel);
					//if is the last pagePanel then show last pagePanel
					if(tmpJPanel != null) {
						JButton tmpButton = new JButton(tpm.getTotalTableCount()+"�� TABLE");
						tmpButton.setPreferredSize(new Dimension(150, 100));
						tmpButton.setVerticalAlignment(SwingConstants.TOP);
						tmpButton.setBackground(bc);
						tmpButton.setFont(new Font("�������",Font.BOLD, 16));	
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
						tmpButton.setFont(new Font("�������",Font.BOLD, 16));	
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
					tpm.setTotalTableCount(tpm.getTotalTableCount()-1);
					tpm.setTotalPageCount();
					JPanel tmpJPanel;
					try {
						tmpJPanel = tablePanelList.get(tpm.getTotalPageCount()-1);
					}catch(IndexOutOfBoundsException ioobe)
					{
						tmpJPanel = null;
					}
					System.out.println(tmpJPanel);
					//if is the last pagePanel then show last pagePanel
					if(tmpJPanel != null) {
						tmpJPanel.remove(tableButtonList.remove(tableButtonList.size()-1));
					//else init last pagePanel
					} else {
						JOptionPane.showMessageDialog(null, "���̻� ������ ���̺��� �����ϴ�.");
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
				  JOptionPane.showMessageDialog(null, "�̵��� ���̺��� ������ �ּ���.");
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
	