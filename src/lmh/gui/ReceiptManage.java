package LMH.gui;

import java.awt.Color;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import gui.util.CreateComponentUtil;

public class ReceiptManage extends FrameTemplete {
	CreateComponentUtil ccUtil = new CreateComponentUtil();

	
	JPanel mainPanel;
	JPanel timePanel;
	
	JPanel paymentPanel;
	JPanel paymentTitlePanel;
	JPanel paymentDetail;
	JPanel paymentContent;
	JPanel tableContent;
	JPanel tableField1;
	JPanel tableValue1;
	JPanel payPrice;
	JPanel payTime;
	
	JPanel tableField2;
	JPanel tableValue2;
	JPanel total;
	JPanel history;
	JPanel times;
	JPanel price;
	
	
	JPanel detailPanel;
	JPanel detailTitlePanel;
	JPanel detail;
	JPanel detailContent;
	
	JLabel time;
	JLabel dateLabel;
	JLabel fieldName1;
	JLabel fieldName2;
		JLabel deatailLabel;
	JLabel payPriceLabel;
	JLabel payTimeLabel;
	
	JLabel totalLabel;
	JLabel historyLabel;
	JLabel priceLabel;
	JLabel timesLabel;
	
	
		
	JButton receiptPrintButton;
	JButton returnButton;
	
	JButton itemTextField;  // 날짜 선택창 구현 필요
	
	public ReceiptManage() {
		init();
	}
	
 
	@Override
	public void initComponent() {
		mainPanel = new JPanel();
		//Util에  default로 세팅해야 하는함
		ccUtil.setMainPanel(mainPanel);
		//시계기능 패널, 레이블
		timePanel= (JPanel) ccUtil.createJcomponent("p", width*23/100,height*4/100, width*5/100, height*50/1000);
		time=(JLabel) ccUtil.createJcomponent("l",width*3/10, height/6, width*4/10, height/60*5);
		
		// 결제정보  패널
		paymentPanel= (JPanel) ccUtil.createJcomponent("p",width*30/100,height*60/100, width*15/100,height*20/100);
		paymentTitlePanel = (JPanel) ccUtil.createJcomponent("p",width*30/100,height*45/1000, 0,0);
		paymentDetail=(JPanel) ccUtil.createJcomponent("p",width*30/100,height*955/1000, 0, height*45/1000);
		paymentContent=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*200, width/1000*50, height/600*60);
		tableField1=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*25, 0, 0);
		tableValue1=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*575, 0, height/600*25);
		
		payPrice=(JPanel) ccUtil.createJcomponent("p", width/1000*205/2, height/600*575, 0, 0);
		payTime=(JPanel) ccUtil.createJcomponent("p", width/1000*205/2, height/600*575, width/1000*205/2, 0);
		
		
		// 상세내역 패널
		detailTitlePanel = (JPanel) ccUtil.createJcomponent("p", width*30/100,height*45/1000, 0,0);
		detailPanel= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*60/100, width*55/100,height*20/100);
		detail= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*955/1000, 0, height*45/1000);
		detailContent=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*220, width/1000*50, height/600*40);
		tableField2=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*25, 0, 0);
		tableValue2=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*170, 0, height/600*25);
		total=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*25, 0, height/600*195);

		history=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, 0, 0);
		times=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, width/1000*205/3, 0);
		price=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, width/1000*205/3*2, 0);

		// 결제정보, 상세내역 레이블
		dateLabel=(JLabel) ccUtil.createJcomponent("l", width*30/100,height*45/1000, width*0/100, height*0/100);
		dateLabel.setText("날짜선택");
		
		fieldName1=(JLabel) ccUtil.createJcomponent("l", width/1000*00, height/600*200, width/1000*50, height/600*60);
		fieldName1.setText("   결제금액                  결제시간   ");
		payPriceLabel=(JLabel) ccUtil.createJcomponent("l", width/1000*205/2, height/600*575, width*0/100, height*0/100);
		payPriceLabel.setText("20,000d원");
		payTimeLabel=(JLabel) ccUtil.createJcomponent("l", width/1000*205/2, height/600*575, width*0/100, height*0/100);
		payTimeLabel.setText("17:55");
		deatailLabel=(JLabel) ccUtil.createJcomponent("l",width*30/100,height*45/1000, width*0/100, height*0/100);
		deatailLabel.setText("상세내역");
		
		fieldName2=(JLabel) ccUtil.createJcomponent("l",width/1000*00, height/600*200, width/1000*50, height/600*60);
		fieldName2.setText(" 내 역           구매횟수          가 격  ");
		totalLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205, height/600*25, width*0/100, height*0/100);
		totalLabel.setText(" 결제금액 : 20,000원(card)  ");
		historyLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205/3, height/600*575, width*0/100, height*0/100);
		historyLabel.setText("항 목");
		timesLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205/3, height/600*575, width*0/100, height*0/100);
		timesLabel.setText("1");
		priceLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205/3, height/600*575, width*0/100, height*0/100);
		priceLabel.setText("20,000원");
		
		
		//버튼 
		receiptPrintButton=(JButton) ccUtil.createJcomponent("b", width/10, height/600*30, width/1000*60, height/600*280);
		receiptPrintButton.setText("영수증 출력");
		returnButton=(JButton) ccUtil.createJcomponent("b", width/15, height/600*30, width/1000*185, height/600*280);
		returnButton.setText("반 품");
		//텍스트 필드
		itemTextField=(JButton) ccUtil.createJcomponent("b", width/1000*120, height/600*20, width/1000*50, height/600*20);
		itemTextField.setText("콤보박스 달력 만들기");
	}

	@Override
	public void addGui() {
		this.add(mainPanel);
		
		// 물품항목 패널
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(155,155,155));
		mainPanel.add(timePanel);
		timePanel.add(time);
		
		mainPanel.add(paymentPanel);
		paymentPanel.setLayout(null);
		paymentPanel.setBackground(new Color(100, 100, 100));
		paymentPanel.add(paymentTitlePanel);
		paymentPanel.add(paymentDetail);
		
		paymentTitlePanel.add(dateLabel);
		
		paymentPanel.add(paymentDetail);
		paymentDetail.setLayout(null);
		paymentDetail.setBackground(new Color(30, 144, 255));

		paymentDetail.add(itemTextField);
		paymentDetail.add(paymentContent);
		paymentContent.setLayout(null);

		paymentContent.add(tableField1);
		tableField1.setBackground(new Color(186, 220, 88));
		tableField1.add(fieldName1);
		
		paymentContent.add(tableValue1);
		tableValue1.setLayout(null);
		tableValue1.add(payPrice);
		payPrice.setBackground(new Color(223, 228, 234));
		payPrice.add(payPriceLabel);
		tableValue1.add(payTime);
		payTime.add(payTimeLabel);
				
    
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
		detailContent.setLayout(null);
		
		detailContent.add(tableField2);
		tableField2.setBackground(new Color(186, 220, 88));
		tableField2.add(fieldName2);
			
		detailContent.add(tableValue2);
		tableValue2.setLayout(null);
	
		tableValue2.add(history);
		history.add(historyLabel);
		tableValue2.add(times);
		times.add(timesLabel);
		times.setBackground(new Color(223, 228, 234));

		tableValue2.add(price);
		price.add(priceLabel);
	
		detailContent.add(total);
		total.add(totalLabel);
		total.setBackground(new Color(236, 204, 104));

	}
	@Override
	public void initEvent() {
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

