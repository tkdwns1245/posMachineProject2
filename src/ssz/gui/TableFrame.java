package ssz.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import gui.util.CreateComponentUtil;

public class TableFrame extends FrameTemplate3{
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	Font plainFont = new Font("",Font.PLAIN,10);
	BorderLayout mainLayout = new BorderLayout();
	FlowLayout middleLayout = new FlowLayout();
	
	JPanel mainPanel;
	
	JPanel topPanel;
	JPanel middlePanel;
	JPanel bottomPanel;
	
	JPanel mLeftPanel;
	JPanel mRightPanel;
	
	JPanel mlTopPanel;
	JPanel mlMiddlePanel;
	JPanel mlBottomPanel;
	
	JPanel mrTopPanel;
	JPanel mrMiddlePanel;
	
	JPanel timePanel;
	
	JLabel dayLabel;
	JLabel timeLabel;
	JLabel tableLabel;
	JLabel idLabel;
	JLabel mlTitleLabel;
	
	JTable salesTable;
	JTable goodsTable;
	
	JButton cancelButton;
	JButton payButton;
	JButton addButton;
	JButton logoutButton;
	List<JButton> categoryButtonList;
	
	public TableFrame() {
		super.init();
	}
	@Override
	public void initComponent() {
		//mainPanel �ʱ�ȭ
		mainPanel= new JPanel();
		mainPanel.setLayout(mainLayout);
		mainPanel.setBackground(new Color(155,155,155));
		
		//Util��  default�� �����ؾ� �ϴ���
		ccUtil.setMainPanel(mainPanel);
		
		//topPanel �ʱ�ȭ
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,65,10));
		topPanel.setBackground(Color.BLUE);
		logoutButton = new JButton("�α׾ƿ�");
		
		//time�г� �ʱ�ȭ
		timePanel = new JPanel();
		
		//label�ʱ�ȭ
		dayLabel = new JLabel("2021/01/01");
		timeLabel = new JLabel("PM 04:09");
		tableLabel = new JLabel("table 1");
		tableLabel.setBorder(BorderFactory.createEmptyBorder(0, 200,0, 200));
		idLabel = new JLabel("���̵�");
		
		//middlePanel�ʱ�ȭ
		middlePanel = new JPanel();
		middleLayout.setAlignment(FlowLayout.CENTER);
		middleLayout.setHgap(50);
		middlePanel.setBackground(Color.WHITE);
		middlePanel.setLayout(middleLayout);
		
		
		//mLeftPanel �ʱ�ȭ
		mLeftPanel = new JPanel();
		mLeftPanel.setPreferredSize(new Dimension(350,400));
		mLeftPanel.setBackground(Color.GRAY);
		//mRightPanel �ʱ�ȭ
		mRightPanel = new JPanel();
		mRightPanel.setPreferredSize(new Dimension(350,400));
		mRightPanel.setBackground(Color.GRAY);
		//bottomPanel �ʱ�ȭ
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.GREEN);
		
	}
	@Override
	public void addGui() {
		this.add(mainPanel);
		
		timePanel.add(dayLabel);
		timePanel.add(timeLabel);
		topPanel.add(timePanel);
		topPanel.add(tableLabel);
		topPanel.add(idLabel);
		topPanel.add(logoutButton);		
		
		middlePanel.add(mLeftPanel);
		middlePanel.add(mRightPanel);
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
	}
	@Override
	public void initEvent() {
		
	}
}
