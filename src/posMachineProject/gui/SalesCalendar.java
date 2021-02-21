package posMachineProject.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import posMachineProejct.manager.SalesCalendarManager;

public class SalesCalendar {
	
	int createMonth=0;
	int[] yearMonthDay= {0,0,0};
	SalesCalendarManager calendarmanager=new SalesCalendarManager();
	
	public void CreateSaleCalender_Months(SalesStatusFrame sales_status) { // �ش� �⵵�� 1~12�� �ǳ� ����
		
		sales_status.jlistList.clear();
		sales_status.saleCalendarPanel.removeAll();
		sales_status.saleCalendarPanel.setLayout(new GridLayout(2,6,5,5));
		
		yearMonthDay[0]=(int) sales_status.yearList.getSelectedItem();
		sales_status.contentNowLabel.setText(yearMonthDay[0]+"��");
		
		
		if(sales_status.yearList.getSelectedItem()==null) return;

		sales_status.jlistList = new ArrayList<JList>();
		DecimalFormat addcomma=new DecimalFormat("###,###");
		
		int[] TotalArray=calendarmanager.getMonthTotalSales((int)sales_status.yearList.getSelectedItem());
		for(createMonth=0;createMonth<12;createMonth++) {
			
			
			DefaultListModel<String> lmodel=new DefaultListModel<String>();
			lmodel.addElement((createMonth+1)+"��");
			lmodel.addElement("��");
			lmodel.addElement("��");
			lmodel.addElement("��");
			lmodel.addElement("���� : "+addcomma.format(TotalArray[createMonth]));
			
			JList<String> monthJlist=new JList<String>(lmodel);
			
			DefaultListCellRenderer renderer = (DefaultListCellRenderer) monthJlist.getCellRenderer();
			renderer.setHorizontalAlignment(SwingConstants.CENTER); 
			renderer.setVerticalAlignment(SwingConstants.CENTER);
			monthJlist.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0));
			monthJlist.setFont(new Font("���� ���",Font.BOLD, 20));
		
			sales_status.jlistList.add(monthJlist);			
			monthJlist.setBackground(new Color(0xC6D9F1));
			
			String name=String.valueOf(createMonth+1);
			monthJlist.setName(name);
			
			monthJlist.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					sales_status.contentNowLabel.setText(yearMonthDay[0]+"��"+name+"��");
					sales_status.monthList.setSelectedIndex(Integer.valueOf(name));
					CreateSaleCalender_Days(sales_status.thisinstance,(int)sales_status.monthList.getSelectedItem());
					CreateMonthDetail(sales_status.thisinstance);
				}
				
			});
			
			
			sales_status.saleCalendarPanel.add(monthJlist);			
			sales_status.saleCalendarPanel.setVisible(false);
			
		}
		createMonth=0;
		System.out.println("��ȸ �Ϸ�");
	}
	
	
	
	
	
	
	
	int createDay=0;
	public void CreateSaleCalender_Days(SalesStatusFrame sales_status,int month) { // �ش� ���� 1~31�� �޷� ����
		
		sales_status.jlistList.clear();
		sales_status.saleCalendarPanel.removeAll();
		sales_status.saleCalendarPanel.setLayout(new GridLayout(0,7,5,5));
		yearMonthDay[0]=(int)sales_status.yearList.getSelectedItem();
		yearMonthDay[1]=month;
		
		if(sales_status.monthList.getSelectedItem()!=null) sales_status.contentNowLabel.setText(yearMonthDay[0]+"��"+yearMonthDay[1]+"��");
		
		if(sales_status.yearList.getSelectedItem()==null) return;
		
		Calendar carlendar=Calendar.getInstance();
		carlendar.set(yearMonthDay[0], yearMonthDay[1]-1,1);
		
		int startday=carlendar.get(Calendar.DAY_OF_WEEK);
		int lastday=carlendar.getActualMaximum(Calendar.DATE);
		
		String day = null;
		for(int i=0; i<7;i++) {
			switch(i) {
			
				case 0:day="��"; break;
				case 1:day="��"; break;
				case 2:day="ȭ"; break;
				case 3:day="��"; break;
				case 4:day="��"; break;
				case 5:day="��"; break;
				case 6:day="��"; break;
								
			}
			JLabel tempLabel=new JLabel(day);
			tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
			tempLabel.setForeground(Color.white);
			tempLabel.setFont(new Font("���� ���",Font.BOLD, 20));
			
			
			
			JPanel tempPanel=new JPanel(new GridLayout());
			tempPanel.setBackground(new Color(0x4F81BD));
			tempPanel.add(tempLabel);
			sales_status.saleCalendarPanel.add(tempPanel);
			

		}

	
		for(int i=0; i<startday-1;i++) {

			sales_status.saleCalendarPanel.add(new JPanel());

		}
		
		
		sales_status.jlistList = new ArrayList<JList>();
		DecimalFormat addcomma=new DecimalFormat("###,###");
		int[] TotalArray=calendarmanager.getDayTotalSales((int)sales_status.yearList.getSelectedItem(),month,lastday);

		
		for(int createDay=0;createDay<lastday;createDay++) {
			
			
			
			DefaultListModel<String> lmodel=new DefaultListModel<String>();
			lmodel.addElement((createDay+1)+"��");
			lmodel.addElement("��");
			lmodel.addElement("���� : "+addcomma.format(TotalArray[createDay]));
			
			
			JList<String> dayJlist=new JList<String>(lmodel);
			
			DefaultListCellRenderer renderer = (DefaultListCellRenderer) dayJlist.getCellRenderer();
			renderer.setHorizontalAlignment(SwingConstants.CENTER); 
			renderer.setVerticalAlignment(SwingConstants.CENTER);
			dayJlist.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			dayJlist.setFont(new Font("���� ���",Font.BOLD, 12));
			
			dayJlist.setName(String.valueOf(createDay+1));
		
			sales_status.jlistList.add(dayJlist);			
			sales_status.jlistList.get(createDay).setBackground(new Color(0xC6D9F1));

		
			dayJlist.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					CreateDayDetail(sales_status,Integer.valueOf(dayJlist.getName()));
				}
				
			});
			
			
			sales_status.saleCalendarPanel.add(dayJlist);			
			sales_status.saleCalendarPanel.setVisible(false);
			
		}
		createDay=0;
		System.out.println("��ȸ �Ϸ�");
	}
	

	public void CreateDayDetail(SalesStatusFrame sales_status, int day) { //�޷¿��� Day �ǳ��� Ŭ�� ���� �� Day�� �� ������ ����
		
		sales_status.jlistList.clear();
		sales_status.saleCalendarPanel.removeAll();
		sales_status.saleCalendarPanel.setLayout(new GridLayout(1,1,10,10));
		
		yearMonthDay[2]=day;
		
		JTable day_Sales_Table=new JTable();
		
		Object[] header = {"������ ��ȣ","�޴� ī�װ�","�޴�","�ݾ�","����","�޴��� �� �ݾ�","�� �ݾ�"};
	    Object[][] data = calendarmanager.getDayDetails(yearMonthDay[0], yearMonthDay[1], yearMonthDay[2]);
	    
	    DefaultTableModel dtm = new DefaultTableModel(data, header);
	    day_Sales_Table.setModel(dtm);
	    
	    
	    
	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) day_Sales_Table.getDefaultRenderer(getClass());
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		day_Sales_Table.setDefaultRenderer(day_Sales_Table.getColumnClass(0), renderer);
	   
		
	    JScrollPane sp=new JScrollPane(day_Sales_Table);
	    sp.setBorder(new LineBorder(Color.black, 2));
	    
	    sales_status.saleCalendarPanel.add(sp);	
	    sales_status.saleCalendarPanel.setVisible(false);
			
		
		
		System.out.println("��ȸ �Ϸ�");
	}
	
	int test=-1;
	public void CreateYearDetail(SalesStatusFrame sales_status) { //�ش� �⵵�� �� ������ ����
		
	
		sales_status.detailPanel.removeAll();
		sales_status.detailPanel.setLayout(new GridLayout(2,1,10,10));
		
		JTable year_Sales_Table=new JTable();
		
		Object[] header = {"������ ��ȣ","�޴� ī�װ�","�޴�","�ݾ�","����","�޴��� �� �ݾ�","�� �ݾ�"};
	    Object[][] data = calendarmanager.getYearDetails(yearMonthDay[0]);
	 
	    DefaultTableModel dtm = new DefaultTableModel(data, header);
	    year_Sales_Table.setModel(dtm);
	    
	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) year_Sales_Table.getDefaultRenderer(getClass());
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		year_Sales_Table.setDefaultRenderer(year_Sales_Table.getColumnClass(0), renderer);
	   
		
	    JScrollPane sp=new JScrollPane(year_Sales_Table);
	    sp.setBorder(new LineBorder(Color.black, 2));
	    
	    int salecount=0,sum=0;
	    for(int i=0; i<data.length; i++) {
	    		if(data[i][0]!=null) {
	    			salecount+=1;
	    		}
	    	
	    		
	    		if(data[i][6]!=null) {
	    			String str=(String)data[i][6];
	    			str=str.replaceAll(",", "");
	    	    	
		    		sum+=Integer.valueOf(str);
	    		}
	    		
	    }
	  
	
	    DecimalFormat addcomma=new DecimalFormat("###,###");

	    sales_status.summary_Count_TextField.setText("�ǸŰǼ� : "+salecount);
	    sales_status.summary_sumPrice_TextField.setText("�� �ݾ� : "+addcomma.format(sum)+"��");
	
	    
	    sales_status.detailPanel.add(sp);	
	    sales_status.detailPanel.add(sales_status.summaryPanel);	
	 

	}
	
public void CreateMonthDetail(SalesStatusFrame sales_status) { //�ش� ���� �� ������ ����
		
	
		sales_status.detailPanel.removeAll();
		sales_status.detailPanel.setLayout(new GridLayout(2,1,10,10));
		
		JTable month_Sales_Table=new JTable();
		
		Object[] header = {"������ ��ȣ","�޴� ī�װ�","�޴�","�ݾ�","����","�޴��� �� �ݾ�","�� �ݾ�"};
	    Object[][] data = calendarmanager.getMonthDetails(yearMonthDay[0],yearMonthDay[1]); 
	 
	    DefaultTableModel dtm = new DefaultTableModel(data, header);
	    month_Sales_Table.setModel(dtm);
	    
	    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) month_Sales_Table.getDefaultRenderer(getClass());
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		month_Sales_Table.setDefaultRenderer(month_Sales_Table.getColumnClass(0), renderer);
	   
		
	    JScrollPane sp=new JScrollPane(month_Sales_Table);
	    sp.setBorder(new LineBorder(Color.black, 2));
	    
	    int count=0,sum=0;
	    for(int i=0; i<data.length; i++) {
	    		if(data[i][0]!=null) {
	    			count+=1;
	    		}
	    		
	    		if(data[i][6]!=null) {
	    			String str=(String)data[i][6];
	    			str=str.replaceAll(",", "");
	    	    	
		    		sum+=Integer.valueOf(str);
	    		}
	    		
	    }
	    
	    DecimalFormat addcomma=new DecimalFormat("###,###");
	    
	    sales_status.summary_Count_TextField.setText("�ǸŰǼ� : "+count);
	    sales_status.summary_sumPrice_TextField.setText("�� �ݾ� : "+addcomma.format(sum));
	    
	    sales_status.detailPanel.add(sp);	
	    sales_status.detailPanel.add(sales_status.summaryPanel);	

	   

	}
	
	

}
