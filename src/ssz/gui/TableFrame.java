package ssz.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.util.CreateComponentUtil;

public class TableFrame extends FrameTemplate3{
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	Font plainFont = new Font("",Font.PLAIN,10);
	BorderLayout mainLayout = new BorderLayout();
	BorderLayout middleLeftBorderLayout = new BorderLayout();
	BorderLayout middleRightBorderLayout = new BorderLayout();
	FlowLayout middleLayout = new FlowLayout();
	FlowLayout mrTopFlowLayout = new FlowLayout(FlowLayout.LEFT,10,10);
	FlowLayout mrMiddleFlowLayout = new FlowLayout(FlowLayout.LEFT);
	
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
	
	JScrollPane salesScrollpane;
	JScrollPane goodsScrollpane;
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
		middlePanel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
		middlePanel.setLayout(middleLayout);
		
		//mLeftPanel �ʱ�ȭ
		mLeftPanel = new JPanel();
		mLeftPanel.setPreferredSize(new Dimension(350,400));
		mLeftPanel.setBackground(Color.GRAY);
		mLeftPanel.setLayout(middleLeftBorderLayout);
		mlTopPanel = new JPanel();
		mlMiddlePanel = new JPanel();
		mlBottomPanel = new JPanel();
		mlTopPanel.setBackground(Color.BLUE);
		mlMiddlePanel.setBackground(Color.WHITE);
		mlBottomPanel.setBackground(Color.RED);
		mlTitleLabel = new JLabel("���Ÿ��");
		
		String header[] = {"�̸�","����","����","�ݾ�"};
		String contents[][] = 
		{
			{"�׸�1","3000","1","3000"},
			{"�׸�2","4000","3","12000"},
			{"�׸�3","5000","2","10000"},
			{"�׸�4","3000","4","12000"}
		};
		DefaultTableModel model = new DefaultTableModel(contents,header);
		salesTable = new JTable(model);
		salesScrollpane = new JScrollPane(salesTable);
		salesScrollpane.setPreferredSize(new Dimension(350,370));
		cancelButton = new JButton("����");
		payButton = new JButton("���");
		
		//mRightPanel �ʱ�ȭ
		mRightPanel = new JPanel();
		mRightPanel.setPreferredSize(new Dimension(350,400));
		mRightPanel.setLayout(middleRightBorderLayout);
		mRightPanel.setBackground(Color.GRAY);
		mrTopPanel = new JPanel();
		mrMiddlePanel = new JPanel();
		
		mrTopPanel.setPreferredSize(new Dimension(350,100));
		mrTopPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		mrTopPanel.setBackground(Color.BLUE);
		mrTopPanel.setLayout(mrTopFlowLayout);
		mrMiddlePanel.setBackground(Color.WHITE);
		mrMiddlePanel.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
		mrMiddlePanel.setLayout(mrMiddleFlowLayout);

		categoryButtonList = new ArrayList<JButton>();
		
		for(int i =0; i < 6; i++)
		{
			JButton tmpButton = new JButton("category" + (i+1));
			tmpButton.setPreferredSize(new Dimension(70, 30));
			categoryButtonList.add(tmpButton);
		}
		
		String header2[] = {"�̸�","����"};
		String contents2[][] = 
		{
			{"�׸�1","3000"},
			{"�׸�2","4000"},
			{"�׸�3","5000"},
			{"�׸�4","3000"}
		};
		DefaultTableModel model2 = new DefaultTableModel(contents2,header2);
		salesTable = new JTable(model2);
		goodsScrollpane = new JScrollPane(salesTable);
		goodsScrollpane.setPreferredSize(new Dimension(280,280));
		addButton = new JButton("�߰�");
		//bottomPanel �ʱ�ȭ
		bottomPanel = new JPanel();
		
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
		
		mlTopPanel.add(mlTitleLabel);
		mlMiddlePanel.add(salesScrollpane);
		mlBottomPanel.add(cancelButton);
		mlBottomPanel.add(payButton);
		
		mLeftPanel.add(mlTopPanel, BorderLayout.NORTH);
		mLeftPanel.add(mlMiddlePanel, BorderLayout.CENTER);
		mLeftPanel.add(mlBottomPanel, BorderLayout.SOUTH);
		
		for(int i = 0; i < categoryButtonList.size(); i ++)
		{
			mrTopPanel.add(categoryButtonList.get(i));
		}
		mrMiddlePanel.add(addButton);
		mrMiddlePanel.add(goodsScrollpane);
		
		mRightPanel.add(mrTopPanel,BorderLayout.NORTH);
		mRightPanel.add(mrMiddlePanel,BorderLayout.CENTER);
		
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
