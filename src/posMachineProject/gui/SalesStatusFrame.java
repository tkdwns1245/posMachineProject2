package posMachineProject.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import gui.util.CreateComponentUtil;
import posMachineProejct.manager.SalesCalendarManager;


public class SalesStatusFrame extends FrameTemplate{
	//DBconnection_SalesDetail connection=new DBconnection_SalesDetail();
	
	
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	SalesCalendar createslaescalendar=new SalesCalendar();
	SalesCalendarManager salesmanager=new SalesCalendarManager();
	SalesStatusFrame thisinstance=this;
	
	public JPanel mainPanel;

	
	public JLabel titleLabel;
	
	public JLabel yearLabel;
	public JPanel yearListPanel;
	public JComboBox<Integer> yearList;
	
	public JLabel monthLabel;
	public JPanel monthListPanel;	
	public JComboBox<Integer> monthList;
	
	public JButton checkBtn;
	
	public JButton goBackBtn;
	
	public JTabbedPane tab;
	public JPanel contentPanel;
	public JLabel contentNowLabel;
	public JPanel saleCalendarPanel;
	public JPanel detailPanel;
	public JTable sale_table;
	public ArrayList<JList> jlistList;
	public ArrayList<Integer> arr= new ArrayList<Integer>();
	
	public JPanel summaryPanel;
	public JPanel summary_sumPrice_Panel;
	public JTextField summary_sumPrice_TextField;
	public JPanel summary_Count_Panel;
	public JTextField summary_Count_TextField;
	
	
	
	public SalesStatusFrame() {
		init();
	}
	
	
	@Override
	public void initComponent() {
		mainPanel = new JPanel();
		//Util에  default로 세팅해야 하는함
		ccUtil.setMainPanel(mainPanel);

		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(223, 228, 234));
		
		titleLabel=(JLabel)ccUtil.createJcomponent("l",200, 50,10, 0);
		titleLabel.setText("매출 현황");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("맑은 고딕",Font.BOLD, 25));
		
		yearLabel=(JLabel)ccUtil.createJcomponent("l", 50, 50, 140, 0);
		yearLabel.setText("Year");
		yearLabel.setFont(new Font("맑은 고딕",Font.BOLD, 15));

		yearListPanel=(JPanel)ccUtil.createJcomponent("p", 100, 20, 180, 15);
		yearListPanel.setLayout(new GridLayout(1,1));
		
		yearList=new JComboBox<Integer>(new Integer[] {null,2020,2021,2022});
		
		monthLabel=(JLabel)ccUtil.createJcomponent("l",200, 50,305, 0);
		monthLabel.setText("Month");
		monthLabel.setFont(new Font("맑은 고딕",Font.BOLD, 15));
		
		
		monthListPanel=(JPanel)ccUtil.createJcomponent("p",100, 20, 360, 15);
		monthListPanel.setLayout(new GridLayout(1,1));
		
		monthList=new JComboBox<Integer>(new Integer[] {null,1,2,3,4,5,6,7,8,9,10,11,12});
		
		checkBtn=(JButton)ccUtil.createJcomponent("b",80, 20, 505,15);
		checkBtn.setText("조회");
		checkBtn.setFont(new Font("맑은 고딕",Font.BOLD, 10));
		
		goBackBtn=(JButton)ccUtil.createJcomponent("b",80, 20, 605,15);
		goBackBtn.setText("뒤로가기");
		goBackBtn.setFont(new Font("맑은 고딕",Font.BOLD, 10));
				
		tab=new JTabbedPane();
		contentPanel=(JPanel)ccUtil.createJcomponent("p",955, 495, 15, 55);
		contentPanel.setLayout(new GridLayout());
		contentPanel.setBackground(new Color(223, 228, 234));
		
		contentNowLabel=(JLabel)ccUtil.createJcomponent("l",200, 50, 850, 15);
		contentNowLabel.setForeground(Color.white);
		contentNowLabel.setFont(new Font("맑은 고딕",Font.BOLD, 25));
				
		saleCalendarPanel=new JPanel();
	    saleCalendarPanel.setBackground(new Color(0xFFFFFF));
	    saleCalendarPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		detailPanel=new JPanel();
		detailPanel.setLayout(new GridLayout());
		detailPanel.setBackground(Color.white);
		
		sale_table=new JTable();
		
		summaryPanel=new JPanel();
		summaryPanel.setLayout(null);
		summaryPanel.setBackground(new Color(223, 228, 234));
		
		summary_Count_Panel=(JPanel)ccUtil.createJcomponent("p",300, 50, 80, 80);
		summary_Count_Panel.setLayout(new GridLayout());
		summary_Count_Panel.setBackground(new Color(0xFFFFFF));	
		
		summary_Count_TextField=new JTextField();
		summary_Count_TextField.setFont(new Font("맑은 고딕",Font.BOLD, 20));
		summary_Count_TextField.setHorizontalAlignment(SwingConstants.CENTER);
		
		summary_sumPrice_Panel=(JPanel)ccUtil.createJcomponent("p",300, 50, 580, 80);
		summary_sumPrice_Panel.setLayout(new GridLayout());
		summary_sumPrice_Panel.setBackground(new Color(0xFFFFFF));
		
		summary_sumPrice_TextField=new JTextField();
		summary_sumPrice_TextField.setFont(new Font("맑은 고딕",Font.BOLD, 20));
		summary_sumPrice_TextField.setHorizontalAlignment(SwingConstants.CENTER);
		
	    jlistList=new ArrayList<JList>();
		
	}
	
	
	@Override
	public void addGui() {
		this.add(mainPanel);
		
		mainPanel.add(yearListPanel);
		mainPanel.add(monthListPanel);
		mainPanel.add(yearLabel);
		mainPanel.add(monthLabel);
		mainPanel.add(checkBtn);
		mainPanel.add(goBackBtn);
		mainPanel.add(contentPanel);
		mainPanel.add(contentNowLabel);
		mainPanel.add(titleLabel);
		
		yearListPanel.add(yearList);
	
		monthListPanel.add(monthList);

		contentPanel.add(tab);
				
		tab.addTab("calendar", saleCalendarPanel);
		tab.addTab("datail", detailPanel);

		summaryPanel.add(summary_Count_Panel);

		summary_Count_Panel.add(summary_Count_TextField);
		
		summaryPanel.add(summary_sumPrice_Panel);

		summary_sumPrice_Panel.add(summary_sumPrice_TextField);
}
	
	@Override
	public void initEvent() {
		//Helper이벤트를 추가
		JComponent[] jcomponentArray= {titleLabel,yearLabel,yearListPanel,contentNowLabel}; //컴포넌트 이동 드래그 기능을 추가할 컴포넌트들
		
		ccUtil.setComponentHelperEvent(jcomponentArray);		
		mainPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(mainPanel.getMousePosition());
			}
			
		});
		
		
		checkBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) { //해당 월에 대한 달력 만들고 디테일 페이지 만듦
				// TODO Auto-generated method stub
				
				if(monthList.getSelectedItem()!=null) { //month콤보박스가 null이 아니면 해당 월의 day가 출력되는 달력 만들고 해당 월의 상세 페이지 생성
					createslaescalendar.CreateSaleCalender_Days(thisinstance, (int) monthList.getSelectedItem()); 
					createslaescalendar.CreateMonthDetail(thisinstance);
				}
				else { //month콤보박스가 null이면 년도의 month가 출력되는 달력 만들고 해당 년도의 상세 페이지 생성
					createslaescalendar.CreateSaleCalender_Months(thisinstance);
					createslaescalendar.CreateYearDetail(thisinstance);
				}
				
			}
			
		});
		
		goBackBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) { 
				// TODO Auto-generated method stub
				
				dispose();
		    	pageManager.goMainPage();
			}
				
		});
		
	}
	
	

	
}
