package ssz.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.util.CreateComponentUtil;

public class MainFrame  extends FrameTemplate3{
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	Font plainFont = new Font("",Font.PLAIN,10);
	
	JPanel mainPanel;
	BorderLayout mainLayout = new BorderLayout();
	FlowLayout bottomSecondLayout = new FlowLayout();
	FlowLayout middleLayout = new FlowLayout();
	
	
	JPanel topPanel;
	JPanel middlePanel;
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
		//mainPanel �ʱ�ȭ
		mainPanel= new JPanel();
		mainPanel.setLayout(mainLayout);
		mainPanel.setBackground(new Color(155,155,155));
		
		//Util��  default�� �����ؾ� �ϴ���
		ccUtil.setMainPanel(mainPanel);
		
		//topPanel �ʱ�ȭ
//		topPanel = (JPanel)ccUtil.createJcomponent("p",width,120, 0, 0);
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,65,10));
		idLabel = new JLabel("���̵�");
		idLabel.setBorder(BorderFactory.createEmptyBorder(0, 475,0, 0));
		logoutButton = new JButton("�α׾ƿ�");
		
		//time�г� �ʱ�ȭ
		timePanel = new JPanel();
		
		//label�ʱ�ȭ
		dayLabel = new JLabel("2021/01/01");
		timeLabel = new JLabel("PM 04:09");
		
		//middlePanel �ʱ�ȭ
		middlePanel = new JPanel();
		middleLayout.setAlignment(FlowLayout.CENTER);
		middleLayout.setHgap(50);
		middleLayout.setVgap(50);
		middlePanel.setBackground(new Color(255, 0, 0, 0));
		middlePanel.setLayout(middleLayout);
		
		for(int i =0; i < 25; i++)
		{
			JButton tmpButton = new JButton("table" + (i+1));
			tmpButton.setPreferredSize(new Dimension(100, 50));
			tableButtonList.add(tmpButton);
		}
		
		//bottomPanel �ʱ�ȭ
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		bottomFirstPanel = new JPanel();
		bottomSecondPanel = new JPanel();
		bottomSecondLayout.setAlignment(FlowLayout.CENTER);
		bottomSecondLayout.setHgap(50);
		pagingLabel = new JLabel("1/3");
		
		bottomSecondPanel.setLayout(bottomSecondLayout);
		bottomPanel.setBackground(new Color(255, 0, 0, 0));
		
		//leftPanel�ʱ�ȭ
		leftPanel = new JPanel();
		leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,220));
		leftPanel.setBackground(new Color(255, 0, 0, 0));
		//rightPanel�ʱ�ȭ
		rightPanel = new JPanel();
		rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,220));
		rightPanel.setBackground(new Color(255, 0, 0, 0));
		
		//button �ʱ�ȭ
		leftPagingButton = new JButton("<<<");
		leftPagingButton.setVerticalAlignment(SwingConstants.CENTER);
		rightPagingButton = new JButton(">>>");
		
		salesStatusButton = new JButton("������Ȳ");
		goodsManageButton = new JButton("��ǰ����");
		receiptManageButton = new JButton("����������");
		tableManageButton = new JButton("���̺����");
		
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
		
		for(int i = 0; i < tableButtonList.size(); i ++)
		{
			middlePanel.add(tableButtonList.get(i));
		}
		
		bottomFirstPanel.add(pagingLabel);
		bottomSecondPanel.add(salesStatusButton);
		bottomSecondPanel.add(goodsManageButton);
		bottomSecondPanel.add(receiptManageButton);
		bottomSecondPanel.add(tableManageButton);
		bottomPanel.add(bottomFirstPanel);
		bottomPanel.add(bottomSecondPanel);
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
	}
	
	@Override
	public void initEvent() {
		//Helper�̺�Ʈ�� �߰�
		JComponent[] jcomponentArray= {timePanel,leftPagingButton}; //������Ʈ �̵� �巡�� ����� �߰��� ������Ʈ��
		
		ccUtil.setComponentHelperEvent(jcomponentArray);		
		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(mainPanel.getMousePosition());
			}
			
		});
		
	}
}
