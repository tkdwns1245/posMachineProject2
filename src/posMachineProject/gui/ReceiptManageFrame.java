package posMachineProject.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.ReceiptJoinedVO;
import gui.util.CreateComponentUtil;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import posMachineProejct.manager.ReceiptManager;

public class ReceiptManageFrame extends FrameTemplate implements Runnable {
	ReceiptManager rm = new ReceiptManager();
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	DecimalFormat df = new DecimalFormat("###,###");

	
	JPanel mainPanel;
	JPanel timePanel;
	
	JPanel paymentPanel;
	JPanel paymentTitlePanel;
	JPanel paymentDetail;
	JPanel paymentContent;
	JPanel tableContent;
 //	JPanel tableField1;
 //	JPanel tableValue1;	 
 //	JPanel payPrice;
 //	JPanel payTime;
	
 //	JPanel tableField2;
 //	JPanel tableValue2;
 //	JPanel total;
	JPanel history;
	JPanel times;
	JPanel price;
	
	
	JPanel detailPanel;
	JPanel detailTitlePanel;
	JPanel detail;
	JPanel detailContent;
	
	JPanel totalPanel;
	JPanel dateSelect;  // ?Ç†Ïß? ?Ñ†?ÉùÏ∞? Íµ¨ÌòÑ ?ïÑ?öî

	
	JLabel time;
	JLabel dateLabel;
	JLabel fieldName1;
	JLabel fieldName2;
	JLabel deatailLabel;
//	JLabel payPriceLabel;
//	JLabel payTimeLabel;
	
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
	
	public ReceiptManageFrame() {
		init();
	}
	
 
	@Override
	public void initComponent() {
		mainPanel = new JPanel();
		//Util?óê  defaultÎ°? ?Ñ∏?åÖ?ï¥?ïº ?ïò?äî?ï®
		ccUtil.setMainPanel(mainPanel);
		//?ãúÍ≥ÑÍ∏∞?ä• ?å®?Ñê, ?†à?ù¥Î∏?
		timePanel=(JPanel)  ccUtil.createJcomponent("p", width*23/100,height*5/100, 50, 50);
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		time.setFont(new Font("ÎßëÏ?Í≥†Îîï",Font.BOLD, 15));	

		// Í≤∞Ï†ú?†ïÎ≥?  ?å®?Ñê
		paymentPanel= (JPanel) ccUtil.createJcomponent("p",width*30/100,height*60/100, width*15/100,height*20/100);
		paymentTitlePanel = (JPanel) ccUtil.createJcomponent("p",width*30/100,height*45/1000, 0,0);
		paymentDetail=(JPanel) ccUtil.createJcomponent("p",width*30/100,height*955/1000, 0, height*45/1000);
		paymentContent=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*245, width/1000*50, height/600*65);
	//	tableField1=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*25, 0, 0);
	//	tableValue1=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*575, 0, height/600*25);
		
	//	payPrice=(JPanel) ccUtil.createJcomponent("p", width/1000*205/2, height/600*575, 0, 0);
	//	payTime=(JPanel) ccUtil.createJcomponent("p", width/1000*205/2, height/600*575, width/1000*205/2, 0);
		
		
		// ?ÉÅ?Ñ∏?Ç¥?ó≠ ?å®?Ñê
		detailTitlePanel = (JPanel) ccUtil.createJcomponent("p", width*30/100,height*45/1000, 0,0);
		detailPanel= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*60/100, width*55/100,height*20/100);
		detail= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*955/1000, 0, height*45/1000);
		detailContent=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*190, width/1000*50, height/600*40);
		totalPanel=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*25, width/1000*50,height/600*230);

	//	tableField2=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*25, 0, 0);
	//	tableValue2=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*170, 0, height/600*25);
	//	total=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*25, 0, height/600*195);

		history=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, 0, 0);
		times=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, width/1000*205/3, 0);
		price=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, width/1000*205/3*2, 0);

		// Í≤∞Ï†ú?†ïÎ≥?, ?ÉÅ?Ñ∏?Ç¥?ó≠ ?†à?ù¥Î∏?
		dateLabel=(JLabel) ccUtil.createJcomponent("l", width*30/100,height*45/1000, width*0/100, height*0/100);
		dateLabel.setText("?Ç†ÏßúÏÑ†?Éù");
		dateLabel.setFont(new Font("ÎßëÏ?Í≥†Îîï",Font.BOLD, 15));	
		
	//	fieldName1=(JLabel) ccUtil.createJcomponent("l", width/1000*00, height/600*200, width/1000*50, height/600*60);
	//	fieldName1.setText("   Í≤∞Ï†úÍ∏àÏï°                  Í≤∞Ï†ú?ãúÍ∞?   ");
	//	payPriceLabel=(JLabel) ccUtil.createJcomponent("l", width/1000*205/2, height/600*575, width*0/100, height*0/100);
	//	payPriceLabel.setText("20,000d?õê");
	//	payTimeLabel=(JLabel) ccUtil.createJcomponent("l", width/1000*205/2, height/600*575, width*0/100, height*0/100);
	//	payTimeLabel.setText("17:55");
		deatailLabel=(JLabel) ccUtil.createJcomponent("l",width*30/100,height*45/1000, width*0/100, height*0/100);
		deatailLabel.setText("?ÉÅ?Ñ∏?Ç¥?ó≠");
		deatailLabel.setFont(new Font("ÎßëÏ?Í≥†Îîï",Font.BOLD, 15));	
		
		
	//	fieldName2=(JLabel) ccUtil.createJcomponent("l",width/1000*00, height/600*200, width/1000*50, height/600*60);
	//	fieldName2.setText(" ?Ç¥ ?ó≠           Íµ¨Îß§?öü?àò          Í∞? Í≤?  ");
		totalLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205, height/600*25, 0, 0);
		
	//	historyLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205/3, height/600*575, width*0/100, height*0/100);
	//	historyLabel.setText("?ï≠ Î™?");
	//	timesLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205/3, height/600*575, width*0/100, height*0/100);
	//	timesLabel.setText("1");
	//	priceLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205/3, height/600*575, width*0/100, height*0/100);
	//	priceLabel.setText("20,000?õê");
		
		// Table ?Éù?Ñ±(Í≤∞Ï†úÍ∏àÏï°, Í≤∞Ï†ú?ãúÍ∞?)
		String header[] = {"Í≤∞Ï†úÍ∏àÏï°","Í≤∞Ï†ú?ãúÍ∞?"};
		size = rm.selecttReceipt().size();
		ArrayList<ReceiptJoinedVO> List= (ArrayList)rm.selecttReceipt();
		String[][] contents = new String[size][2];  // Î¶¨Ïä§?ä∏ ?Ç¨?ù¥Ï¶àÎ?? Î®ºÏ? ?Ñ†?ñ∏
		for(int i=0; i < List.size(); i++) {
			contents[i][0] =  "" + List.get(i).getSumPrice();
			contents[i][1] = "" + List.get(i).getRegTime();
		}
		
    	DefaultTableModel model = new DefaultTableModel(contents,header){
		// ?çîÎ∏îÌÅ¥Î¶??ï¥?Ñú ?àò?†ïÎ∂àÍ?
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		dateScrollpane = new JScrollPane(dateTable);
		dateScrollpane.setPreferredSize(new Dimension(width/1000*195,height/600*235));
		
		
		// Table ?Éù?Ñ±(?Ç¥?ó≠, Íµ¨Îß§?öü?àò, Í∞?Í≤?)
		String header2[] = {"?Ç¥ ?ó≠","Íµ¨Îß§?öü?àò","Í∞? Í≤?"};
		size2 = rm.selecttReceipt_Details().size();
		ArrayList<ReceiptJoinedVO> List2 = (ArrayList)rm.selecttReceipt();
		String[][] contents2 = new String[size2][3];  // Î¶¨Ïä§?ä∏ ?Ç¨?ù¥Ï¶àÎ?? Î®ºÏ? ?Ñ†?ñ∏
		for(int i=0; i < List2.size(); i++) {
			contents2[i][0] = List2.get(i).getMenu_Name();
			contents2[i][1] = "" + List2.get(i).getNumberOf();
			contents2[i][2] = "" + List2.get(i).getMenu_Price();
			
			totalSum += List2.get(i).getMenu_Price(); 
		}
		
		DefaultTableModel model2 = new DefaultTableModel(contents2,header2){
		// ?çîÎ∏îÌÅ¥Î¶??ï¥?Ñú ?àò?†ïÎ∂àÍ?
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		detailTable = new JTable(model2);
		detailScrollpane = new JScrollPane(detailTable);
		detailScrollpane.setPreferredSize(new Dimension(width/1000*195,height/600*180));
		
		//Î≤ÑÌäº 
		receiptPrintButton=(JButton) ccUtil.createJcomponent("b", width/10, height/600*30, width/1000*60, height/600*280);
		receiptPrintButton.setText("?òÅ?àòÏ¶? Ï∂úÎ†•");
		returnButton=(JButton) ccUtil.createJcomponent("b", width/15, height/600*30, width/1000*185, height/600*280);
		returnButton.setText("Î∞? ?íà");

		//?Ç†ÏßúÏÑ†?Éù 
		dateSelect=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*40, width/1000*50, height/600*20);
		
	}

	@Override
	public void addGui() {
		this.add(mainPanel);
		
		// ?Ç†ÏßúÏÑ†?ÉùÏ∞?
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setPreferredSize(new Dimension(width/1000*200,height/600*25));
		datePicker.setFont(new Font("ÎßëÏ?Í≥†Îîï",Font.BOLD, 15));	
		dateSelect.add(datePicker);
		dateSelect.setBackground(new Color(30, 144, 255));

		// ?ã¨?†•?óê?Ñú ?Ñ†?Éù?êú Í∞? Î∞õÍ∏∞ : model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay();
		
		// Î¨ºÌíà?ï≠Î™? ?å®?Ñê
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(155,155,155));
		mainPanel.setBackground(new Color(223, 228, 234));

		mainPanel.add(timePanel);
		timePanel.add(time);
		timePanel.setBackground(new Color(116, 125, 140));

		
		mainPanel.add(paymentPanel);
		paymentPanel.setLayout(null);
		paymentPanel.setBackground(new Color(100, 100, 100));
		paymentPanel.add(paymentTitlePanel);
		paymentPanel.add(paymentDetail);
		
		paymentTitlePanel.add(dateLabel);
		
		paymentPanel.add(paymentDetail);
		paymentDetail.setLayout(null);
		paymentDetail.setBackground(new Color(30, 144, 255));

		paymentDetail.add(dateSelect);
		paymentDetail.add(paymentContent);
		paymentContent.add(dateScrollpane);

	//	paymentContent.add(tableField1);
	//	tableField1.setBackground(new Color(186, 220, 88));
	//	tableField1.add(fieldName1);
		
	//	paymentContent.add(tableValue1);
	//	tableValue1.setLayout(null);
	//	tableValue1.add(payPrice);
	//	payPrice.setBackground(new Color(223, 228, 234));
	//	payPrice.add(payPriceLabel);
	//	tableValue1.add(payTime);
	//	payTime.add(payTimeLabel);
				


		// Ïπ¥ÌÖåÍ≥†Î¶¨ ?å®?Ñê		
		
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
		totalPanel.add(totalLabel);  // Í∏àÏï° Ï¥ùÌï©Í≥?
		totalLabel.setText("?ï©Í≥?" + " " + (df.format(totalSum)) +"?õê");

		totalPanel.setBackground(new Color(236, 204, 104));

		detailContent.add(detailScrollpane);
		
	//	detailContent.add(tableField2);
	//	tableField2.setBackground(new Color(186, 220, 88));
	//	tableField2.add(fieldName2);
			
	//	detailContent.add(tableValue2);
	//	tableValue2.setLayout(null);
	
	//	tableValue2.add(history);
	//	history.add(historyLabel);
	//	tableValue2.add(times);
	//	times.add(timesLabel);
	//	times.setBackground(new Color(223, 228, 234));

	//	tableValue2.add(price);
	//	price.add(priceLabel);
	

	}
	@Override
	public void initEvent() {
		//?òÅ?àòÏ¶? Ï∂úÎ†•
		receiptPrintButton.addMouseListener(new MouseAdapter() { 
			  public void mouseClicked(MouseEvent e) {
				  String[] st = {"?Ñ§", "?ïÑ?ãà?ò§"};
					int num = JOptionPane.showOptionDialog(null, "?òÅ?àòÏ¶ùÏùÑ Ï∂úÎ†•  ?ïò?ãúÍ≤†Ïäµ?ãàÍπ??.", "?òÅ?àòÏ¶? Ï∂úÎ†•", JOptionPane.DEFAULT_OPTION, 1, null, st, st[0]);
						
						if(num == 0) {JOptionPane.showMessageDialog(null, "?òÅ?àòÏ¶ùÏù¥ Ï∂úÎ†•?ê©?ãà?ã§.");
							
						}	
				  }
		});
		
		//Î∞òÌíàÎ≤ÑÌäº 
		returnButton.addMouseListener(new MouseAdapter() { 
			  public void mouseClicked(MouseEvent e) {
				  String[] st = {"?Ñ§", "?ïÑ?ãà?ò§"};
					int num = JOptionPane.showOptionDialog(null, "Î∞òÌíàÏ≤òÎ¶¨ ?ïò?ãúÍ≤†Ïäµ?ãàÍπ??.", "Î∞òÌíà Ï≤òÎ¶¨", JOptionPane.DEFAULT_OPTION, 1, null, st, st[0]);
						
						if(num == 0) {JOptionPane.showMessageDialog(null, "Î∞òÌíàÏ≤òÎ¶¨ ?êò?óà?äµ?ãà?ã§.");
							
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
				String day1 = (year +"?ÖÑ " + month + "?õî " + date + "?ùº " + ampm + " " + hour + ":0" + min + ":0" + sec );
				time.setText(day1);
			} else if((min>10) && (sec<10)) {
				String day2 = (year +"?ÖÑ " + month + "?õî " + date + "?ùº " + ampm + " " + hour + ":" + min + ":0" + sec );
				time.setText(day2);
			} else if((min<10) && (sec>10)) {
				String day3 = (year +"?ÖÑ " + month + "?õî " + date + "?ùº " + ampm + " " + hour + ":0" + min + ":" + sec );
				time.setText(day3);
			} else {
				String day4 = (year +"?ÖÑ " + month + "?õî " + date + "?ùº " + ampm + " " + hour + ":" + min + ":" + sec );
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