package posMachineProject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.TableVO;
import gui.util.CreateComponentUtil;
import posMachineProejct.manager.TableManager;
import posMachineProejct.manager.TablePagingManager;

public class MainFrame  extends FrameTemplate implements Runnable{
	TableManager tm = new TableManager();
	TablePagingManager tpm = new TablePagingManager(tm);
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	Font plainFont = new Font("",Font.PLAIN,10);
	
	JPanel mainPanel;
	BorderLayout mainLayout = new BorderLayout();
	FlowLayout bottomSecondLayout = new FlowLayout();
	FlowLayout middleLayout = new FlowLayout();
	
	
	JPanel topPanel;
	JPanel[] middlePanelarr;
	JPanel bottomPanel;
	JPanel bottomFirstPanel;
	JPanel bottomSecondPanel;
	
	JPanel leftPanel;
	JPanel rightPanel;
	
	JPanel timePanel;
	JLabel dayLabel;
	JLabel timeLabel;
	JLabel pagingLabel;
	
	JButton leftPagingButton;
	JButton rightPagingButton;
	
	List<JButton> tableButtonList;
	List<String> tableStatusList;
	
	JButton salesStatusButton;
	JButton goodsManageButton;
	JButton receiptManageButton;
	JButton tableManageButton;
	JLabel time;
	Color bc = new Color(27, 156, 252);
	Color cc = new Color(241, 196, 15);
	Color dc = Color.GREEN;
	public MainFrame() {
		super.init();
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	@Override
	public void initComponent() {
		tableStatusList = new ArrayList<String>();
		tableStatusList = tm.selectTableStatusList();
		tableButtonList = new ArrayList<JButton>();
		//mainPanel �ʱ�ȭ
		mainPanel= new JPanel();
		mainPanel.setLayout(mainLayout);
		mainPanel.setBackground(new Color(223, 228, 234));
		
		//Util��  default�� �����ؾ� �ϴ���
		ccUtil.setMainPanel(mainPanel);
		
		//topPanel �ʱ�ȭ
//		topPanel = (JPanel)ccUtil.createJcomponent("p",width,120, 0, 0);
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,65,10));
		topPanel.setBackground(new Color(223, 228, 234));
		//time�г� �ʱ�ȭ
		timePanel = new JPanel();
		timePanel.setBackground(new Color(116, 125, 140));
		timePanel.setPreferredSize(new Dimension(250,30));
		
		time= new JLabel();
		time.setForeground(Color.white);
		time.setPreferredSize(new Dimension(230,25));
		time.setFont(new Font("�������",Font.BOLD, 15));
		
		//middlePanel �ʱ�ȭ
		middlePanelarr = new JPanel[tpm.getTotalPageCount()+1];
		for(int j=1; j <= tpm.getTotalPageCount(); j++)
		{
			middlePanelarr[j] = new JPanel();
			middleLayout.setAlignment(FlowLayout.LEFT);
			middleLayout.setHgap(9);
			middleLayout.setVgap(15);
			middlePanelarr[j].setLayout(middleLayout);
			middlePanelarr[j].setPreferredSize(new Dimension(800,345));
			middlePanelarr[j].setBorder(BorderFactory.createEmptyBorder(40,30,0,0));
		}
		List<TableVO> tableList = tm.selectTableList();
		for(int i =0; i < tpm.getTotalTableCount(); i++)
		{
			JButton tmpButton = new JButton(tableList.get(i).getTableNumber()+"�� TABLE");
			
			tmpButton.setFont(new Font("�������",Font.BOLD, 16));	
			tmpButton.setForeground(Color.white);
			tmpButton.setPreferredSize(new Dimension(150, 100));
			if(tableStatusList.get(i).equals("Y")) {
				tmpButton.setBackground(dc);
			} else {
				tmpButton.setBackground(bc);
			}
			tmpButton.setVerticalAlignment(SwingConstants.TOP);
			tableButtonList.add(tmpButton);
		}
		
		//bottomPanel �ʱ�ȭ
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		bottomPanel.setBackground(new Color(223, 228, 234));
		bottomFirstPanel = new JPanel();
		bottomFirstPanel.setBackground(new Color(223, 228, 234));
		bottomSecondPanel = new JPanel();
		bottomSecondPanel.setBackground(new Color(223, 228, 234));
		bottomSecondLayout.setAlignment(FlowLayout.CENTER);
		bottomSecondLayout.setHgap(50);
		pagingLabel = new JLabel(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
	
		bottomSecondPanel.setLayout(bottomSecondLayout);
		bottomPanel.setBackground(new Color(255, 0, 0, 0));
		
		//leftPanel�ʱ�ȭ
		leftPanel = new JPanel();
		leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,220));
		leftPanel.setBackground(new Color(223, 228, 234));
		//rightPanel�ʱ�ȭ
		rightPanel = new JPanel();
		rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,220));
		rightPanel.setBackground(new Color(223, 228, 234));
		

		
		//button �ʱ�ȭ
		Dimension btnDimension = new Dimension(50, 30);
		leftPagingButton = new JButton("<");
		leftPagingButton.setPreferredSize(btnDimension);
		rightPagingButton = new JButton(">");
		rightPagingButton.setPreferredSize(btnDimension);
		
		salesStatusButton = new JButton("������Ȳ");
		goodsManageButton = new JButton("��ǰ����");
		receiptManageButton = new JButton("����������");
		tableManageButton = new JButton("���̺����");
		
	}
	
	@Override
	public void addGui() {
		this.add(mainPanel);
		
		timePanel.add(time);
		topPanel.add(timePanel);
		
		leftPanel.add(leftPagingButton);
		rightPanel.add(rightPagingButton);
		for(int i = 1; i <= tpm.getTotalPageCount(); i++)
		{
			//������ �г��� �ƴ� ���
			if(i != tpm.getTotalPageCount())
			{
				//�������� ��ư ������ �г� ����
				for(int j=0; j < tpm.getTablePerPage(); j++)
				{
					middlePanelarr[i].add(tableButtonList.get(j+((i-1)*15)));
				}
			//������ �г��� ���
			}else {
				//���¹�ư���� �г� ����
				for(int j=0; j < tpm.getTotalTableCount() % tpm.getTablePerPage(); j++)
				{
					middlePanelarr[i].add(tableButtonList.get(j+((i-1)*15)));
				}
			}
		}
		
		bottomFirstPanel.add(pagingLabel);
		bottomSecondPanel.add(salesStatusButton);
		bottomSecondPanel.add(goodsManageButton);
		bottomSecondPanel.add(receiptManageButton);
		bottomSecondPanel.add(tableManageButton);
		bottomPanel.add(bottomFirstPanel);
		bottomPanel.add(bottomSecondPanel);
		
		
		mainPanel.add(middlePanelarr[tpm.getCurruntPage()], BorderLayout.CENTER);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		
		

	}
	
	@Override
	public void initEvent() {
		this.addComponentListener(new ComponentListener() {
			public void componentShown(ComponentEvent e) {
				tableStatusList = tm.selectTableStatusList();
				for(int i =0; i < tableButtonList.size(); i++)
				{
					if(tableStatusList.get(i).equals("Y")) {
						tableButtonList.get(i).setBackground(dc);
					} else {
						tableButtonList.get(i).setBackground(bc);
					}
				}
			}
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		leftPagingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainPanel.remove(middlePanelarr[tpm.getCurruntPage()]);
            	mainPanel.add(middlePanelarr[tpm.getPrevPage()]);
            	pagingLabel.setText(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
            	repaint();
            }
        });
		rightPagingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mainPanel.remove(middlePanelarr[tpm.getCurruntPage()]);
            	mainPanel.add(middlePanelarr[tpm.getNextPage()]);
            	pagingLabel.setText(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
            	repaint();
            }
        });
		for(int i = 0; i < tableButtonList.size(); i++)
		{
			int tableNum = i+1;
			tableButtonList.get(i).addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if(!tableStatusList.get(tableNum-1).equals("Y"))
					{
						JOptionPane.showMessageDialog(null, "'���̺����'���� ���̺��� ���� ���ּ���.");
					}else {
		            	dispose();
		            	pageManager.goTablePage(tableNum);
					}
	            }
	        });
		}
		salesStatusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				pageManager.goSalesStatusPage();
			}
		});
		goodsManageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				pageManager.goGoodsManagePage();
				
			}
		});
		receiptManageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				pageManager.goReceiptManagePage();
			}
		});
		tableManageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				pageManager.goTableManagePage();
				
			}
		});
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
}
