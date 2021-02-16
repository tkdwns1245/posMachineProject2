package lmh.gui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities; 
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import data.MenuVO;
import data.ReceiptJoinedVO;
import data.ReceiptVO;
import gui.util.CreateComponentUtil;
import lmh.manager.ReceiptManager;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class ReceiptManage extends FrameTemplate {
	ReceiptManager rm = new ReceiptManager();
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	DecimalFormat df = new DecimalFormat("###,###");
	
	int year,month,day;

	
	JPanel mainPanel;
	JPanel timePanel;
	
	JPanel paymentPanel;
	JPanel paymentTitlePanel;
	JPanel paymentDetail;
	JPanel paymentContent;
	JPanel tableContent;

	JPanel history;
	JPanel times;
	JPanel price;
	
	
	JPanel detailPanel;
	JPanel detailTitlePanel;
	JPanel detail;
	JPanel detailContent;
	
	JPanel totalPanel;
	JPanel dateSelect;  // 날짜 선택창 구현 필요

	
	JLabel time;
	JLabel dateLabel;
	JLabel fieldName1;
	JLabel fieldName2;
	JLabel deatailLabel;

	
	JLabel totalLabel;
	JLabel historyLabel;
	JLabel priceLabel;
	JLabel timesLabel;
	
	JTable dateTable;
	JTable detailTable;
	
	JScrollPane dateScrollpane;
	JScrollPane detailScrollpane;
		
	JButton receiptPrintButton;
	JButton returnButton;
	int size;
	int size2;
	int totalSum;
	
	UtilDateModel model;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	
	DefaultTableModel datetablemodel; 
	String[] header,header2;
	Object[][] contents,contents2;
	
	public ReceiptManage() {
		init();
	}
	
 
	@Override
	public void initComponent() {
		mainPanel = new JPanel();
		//Util에  default로 세팅해야 하는함
		ccUtil.setMainPanel(mainPanel);
		//시계기능 패널, 레이블
		timePanel=(JPanel)  ccUtil.createJcomponent("p", width*23/100,height*5/100, 50, 50);
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		time.setFont(new Font("맑은고딕",Font.BOLD, 15));	

		// 결제정보  패널
		paymentPanel= (JPanel) ccUtil.createJcomponent("p",width*30/100,height*60/100, width*15/100,height*20/100);
		paymentTitlePanel = (JPanel) ccUtil.createJcomponent("p",width*30/100,height*45/1000, 0,0);
		paymentDetail=(JPanel) ccUtil.createJcomponent("p",width*30/100,height*955/1000, 0, height*45/1000);
		paymentContent=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*245, width/1000*50, height/600*65);

		// 상세내역 패널
		detailTitlePanel = (JPanel) ccUtil.createJcomponent("p", width*30/100,height*45/1000, 0,0);
		detailPanel= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*60/100, width*55/100,height*20/100);
		detail= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*955/1000, 0, height*45/1000);
		detailContent=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*190, width/1000*50, height/600*40);
		totalPanel=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*25, width/1000*50,height/600*230);

		history=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, 0, 0);
		times=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, width/1000*205/3, 0);
		price=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, width/1000*205/3*2, 0);

		// 결제정보, 상세내역 레이블
		dateLabel=(JLabel) ccUtil.createJcomponent("l", width*30/100,height*45/1000, width*0/100, height*0/100);
		dateLabel.setText("날짜선택");
		dateLabel.setFont(new Font("맑은고딕",Font.BOLD, 15));	
		
		deatailLabel=(JLabel) ccUtil.createJcomponent("l",width*30/100,height*45/1000, width*0/100, height*0/100);
		deatailLabel.setText("상세내역");
		deatailLabel.setFont(new Font("맑은고딕",Font.BOLD, 15));	

		totalLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205, height/600*25, 0, 0);
		

		
		// Table 생성(결제금액, 결제시간)
		header = new String[] {"결제금액","결제시간"};
		contents=rm.CreateReceiptJtableContents(year, month, day);

    	datetablemodel = new DefaultTableModel(contents,header){
		// 더블클릭해서 수정불가
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		
		
		dateTable = new JTable(datetablemodel);
		dateScrollpane = new JScrollPane(dateTable);
		dateScrollpane.setPreferredSize(new Dimension(width/1000*195,height/600*235));
		
		
		// Table 생성(내역, 구매횟수, 가격)
		header2 = new String[] {"내 역","구매횟수","가 격"};
		contents2=rm.CreateReceiptDetailJtableContents(0);
		DefaultTableModel model2 = new DefaultTableModel(contents2,header2){
		// 더블클릭해서 수정불가
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		
		
		detailTable = new JTable(model2);
		detailScrollpane = new JScrollPane(detailTable);
		detailScrollpane.setPreferredSize(new Dimension(width/1000*195,height/600*180));
		
		//버튼 
		receiptPrintButton=(JButton) ccUtil.createJcomponent("b", width/10, height/600*30, width/1000*60, height/600*280);
		receiptPrintButton.setText("영수증 출력");
		returnButton=(JButton) ccUtil.createJcomponent("b", width/15, height/600*30, width/1000*185, height/600*280);
		returnButton.setText("반 품");

		//날짜선택 
		dateSelect=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*40, width/1000*50, height/600*20);
		
	}

	@Override
	public void addGui() {
		this.add(mainPanel);
		
		// 날짜선택창
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setPreferredSize(new Dimension(200,25));
		datePicker.setFont(new Font("맑은고딕",Font.BOLD, 15));	
		dateSelect.add(datePicker);
		dateSelect.setBackground(new Color(30, 144, 255));
		
		
		// 달력에서 선택된 값 받기 : model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay();
		
		// 물품항목 패널
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(155,155,155));
		mainPanel.setBackground(new Color(223, 228, 234));

		mainPanel.add(timePanel);
		timePanel.add(time);
		timePanel.setBackground(new Color(116, 125, 140));

		
		mainPanel.add(paymentPanel);
		paymentPanel.setLayout(null);
		paymentPanel.setBackground(new Color(150, 100, 100));
		paymentPanel.add(paymentTitlePanel);
		paymentPanel.add(paymentDetail);
		
		paymentTitlePanel.add(dateLabel);
		
		paymentPanel.add(paymentDetail);
		paymentDetail.setLayout(null);
		paymentDetail.setBackground(new Color(55, 144, 255));

		paymentDetail.add(dateSelect);
		paymentDetail.add(paymentContent);
		paymentContent.add(dateScrollpane);

		// 카테고리 패널		
		
		mainPanel.add(detailPanel);
		detailPanel.setLayout(null);
		detailPanel.setBackground(new Color(100, 100, 100));
		detailPanel.add(detailTitlePanel);
		detailPanel.add(detail);
		
		
		detailTitlePanel.add(deatailLabel);
		
		detailPanel.add(detail);
		detail.setLayout(null);
		detail.setBackground(new Color(30, 144, 255));

		detail.add(receiptPrintButton);
		detail.add(returnButton);
		detail.add(detailContent);
		detail.add(totalPanel);
		totalPanel.add(totalLabel);  // 금액 총합계
		totalLabel.setText("합계" + " " + (df.format(totalSum)) +"원");

		totalPanel.setBackground(new Color(236, 204, 104));

		detailContent.add(detailScrollpane);


	}
	@Override
	public void initEvent() {
		//영수증 출력
		receiptPrintButton.addMouseListener(new MouseAdapter() { 
			  public void mouseClicked(MouseEvent e) {
				  String[] st = {"네", "아니오"};
					int num = JOptionPane.showOptionDialog(null, "영수증을 출력  하시겠습니까?.", "영수증 출력", JOptionPane.DEFAULT_OPTION, 1, null, st, st[0]);
						
						if(num == 0) {JOptionPane.showMessageDialog(null, "영수증이 출력됩니다.");
							
						}	
				  }
		});
		
		//반품버튼 
		returnButton.addMouseListener(new MouseAdapter() { 
			  public void mouseClicked(MouseEvent e) {
				  String[] st = {"네", "아니오"};
					int num = JOptionPane.showOptionDialog(null, "반품처리 하시겠습니까?.", "반품 처리", JOptionPane.DEFAULT_OPTION, 1, null, st, st[0]);
						
						if(num == 0) {
							rm.returnThisSale((int)contents[dateTable.getSelectedRow()][2]);
							contents[dateTable.getSelectedRow()][3]="return";
							detailTable.setModel(new DefaultTableModel(null,header2));	
							totalLabel.setText("");
							
							JOptionPane.showMessageDialog(null, "반품처리 되었습니다.");
						}	
				  }
		});
		
		model.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				String before=""+year+month;
				int beforeday=day;
	
				year=model.getYear();
				month=model.getMonth()+1;
				day=model.getDay();

				int afterday=day;
				String after=""+year+month;

				
				if( (beforeday!=afterday) || (beforeday==afterday && !before.equals(after)) ) {
			
					contents=rm.CreateReceiptJtableContents(year, month, day);					
					dateTable.setModel(new DefaultTableModel(contents,header));
					
					dateTable.getColumnModel().getColumn(0).setPreferredWidth(100);
					dateTable.getColumnModel().getColumn(1).setPreferredWidth(150);
					
					
				}
			}
		});
		
		dateTable.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				contents2=rm.CreateReceiptDetailJtableContents((int)contents[dateTable.getSelectedRow()][2]);
				detailTable.setModel(new DefaultTableModel(contents2,header2));	
				
				int total=0;
				for(int i=0;i<contents2.length;i++) {
					total+=(int)contents2[i][2]*(int)contents2[i][1];
				}
				if(contents[dateTable.getSelectedRow()][3].equals("normal")) {
					totalLabel.setText("합계 "+String.valueOf(total)+" 원");
					totalPanel.setBackground(new Color(236, 204, 104));
				}
				if(contents[dateTable.getSelectedRow()][3].equals("return")) {
					totalLabel.setText("반품 "+String.valueOf(total)+" 원");
					totalPanel.setBackground(new Color(200, 80, 80));
				}
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
	
		
}