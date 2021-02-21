package posMachineProject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.TableVO;
import gui.util.CreateComponentUtil;
import posMachineProejct.manager.TableManager;
import posMachineProejct.manager.TablePagingManager;

public class MainFrame  extends FrameTemplate{
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
	JLabel idLabel;
	JLabel pagingLabel;
	
	JButton logoutButton;
	JButton leftPagingButton;
	JButton rightPagingButton;
	
	List<JButton> tableButtonList;
	JButton salesStatusButton;
	JButton goodsManageButton;
	JButton receiptManageButton;
	JButton tableManageButton;
	
	
	public MainFrame() {
		super.init();
	}
	
	@Override
	public void initComponent() {
		tableButtonList = new ArrayList<JButton>();
		//mainPanel 초기화
		mainPanel= new JPanel();
		mainPanel.setLayout(mainLayout);
		mainPanel.setBackground(new Color(155,155,155));
		
		//Util에  default로 세팅해야 하는함
		ccUtil.setMainPanel(mainPanel);
		
		//topPanel 초기화
//		topPanel = (JPanel)ccUtil.createJcomponent("p",width,120, 0, 0);
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,65,10));
		idLabel = new JLabel("아이디");
		idLabel.setBorder(BorderFactory.createEmptyBorder(0, 475,0, 0));
		logoutButton = new JButton("로그아웃");
		
		//time패널 초기화
		timePanel = new JPanel();
		
		//label초기화
		dayLabel = new JLabel("2021/01/01");
		timeLabel = new JLabel("PM 04:09");
		
		//middlePanel 초기화
		middlePanelarr = new JPanel[tpm.getTotalPageCount()+1];
		for(int j=1; j <= tpm.getTotalPageCount(); j++)
		{
			middlePanelarr[j] = new JPanel();
			middleLayout.setAlignment(FlowLayout.CENTER);
			middleLayout.setHgap(50);
			middleLayout.setVgap(50);
			middlePanelarr[j].setBackground(new Color(255, 0, 0, 0));
			middlePanelarr[j].setLayout(middleLayout);
		}
		List<TableVO> tableList = tm.selectTableList();
		for(int i =0; i < tpm.getTotalTableCount(); i++)
		{
			JButton tmpButton = new JButton("table " + tableList.get(i).getTableNumber());
			tmpButton.setPreferredSize(new Dimension(100, 50));
			tableButtonList.add(tmpButton);
		}
		
		//bottomPanel 초기화
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		bottomFirstPanel = new JPanel();
		bottomSecondPanel = new JPanel();
		bottomSecondLayout.setAlignment(FlowLayout.CENTER);
		bottomSecondLayout.setHgap(50);
		pagingLabel = new JLabel(tpm.getCurruntPage() + " / " + tpm.getTotalPageCount());
	
		bottomSecondPanel.setLayout(bottomSecondLayout);
		bottomPanel.setBackground(new Color(255, 0, 0, 0));
		
		//leftPanel초기화
		leftPanel = new JPanel();
		leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,220));
		leftPanel.setBackground(new Color(255, 0, 0, 0));
		//rightPanel초기화
		rightPanel = new JPanel();
		rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,220));
		rightPanel.setBackground(new Color(255, 0, 0, 0));
		
		//button 초기화
		leftPagingButton = new JButton("<<<");
		leftPagingButton.setVerticalAlignment(SwingConstants.CENTER);
		rightPagingButton = new JButton(">>>");
		
		salesStatusButton = new JButton("매출현황");
		goodsManageButton = new JButton("물품관리");
		receiptManageButton = new JButton("영수증관리");
		tableManageButton = new JButton("테이블관리");
		
	}
	
	@Override
	public void addGui() {
		this.add(mainPanel);
		
		timePanel.add(dayLabel);
		timePanel.add(timeLabel);
		topPanel.add(timePanel);
		topPanel.add(idLabel);
		topPanel.add(logoutButton);
		
		leftPanel.add(leftPagingButton);
		rightPanel.add(rightPagingButton);
		for(int i = 1; i <= tpm.getTotalPageCount(); i++)
		{
			//마지막 패널이 아닐 경우
			if(i != tpm.getTotalPageCount())
			{
				//페이지당 버튼 개수로 패널 세팅
				for(int j=0; j < tpm.getPagePerTable(); j++)
				{
					middlePanelarr[i].add(tableButtonList.get(j+((i-1)*20)));
				}
			//마지막 패널일 경우
			}else {
				//남는버튼으로 패널 세팅
				for(int j=0; j < tpm.getTotalTableCount() % tpm.getPagePerTable(); j++)
				{
					middlePanelarr[i].add(tableButtonList.get(j+((i-1)*20)));
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
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanelarr[tpm.getCurruntPage()], BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
	}
	
	@Override
	public void initEvent() {
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
			int tableNum = Integer.parseInt(tableButtonList.get(i).getText().split(" ")[1]);
			tableButtonList.get(i).addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	dispose();
	            	pageManager.goTablePage(tableNum);
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
				pageManager.goGoodsManagePage();
				
			}
		});
		receiptManageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pageManager.goReceiptManagePage();
				
			}
		});
		tableManageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pageManager.goTableManagePage();
				
			}
		});
	}
}
