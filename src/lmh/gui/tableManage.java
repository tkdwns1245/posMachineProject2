package lmh.gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import gui.util.CreateComponentUtil;

public class tableManage extends FrameTemplete{
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	
	JPanel mainPanel;
	JPanel timePanel;
	
	
	JPanel numberListPanel;
	JPanel numberListPanel_2;
	
	
	JLabel title;		
	JLabel time;
	
	JButton tableAddBtn;
	JButton tableDelBtn;
	JButton tableMoveBtn;
	

	public tableManage() {
		init();
	}
	
	@Override
	public void initComponent() {
		mainPanel = new JPanel();
		//Util에  default로 세팅해야 하는함
		ccUtil.setMainPanel(mainPanel);
		
		timePanel=(JPanel)  ccUtil.createJcomponent("p", width*23/100,height*4/100, width*5/100,height*50/1000);
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		
		title=(JLabel) ccUtil.createJcomponent("l", 200, 50,435, 25);
			
		tableAddBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 560, 50);
		tableAddBtn.setText("테이블 추가");
		
		tableDelBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 680, 50);
		tableDelBtn.setText("테이블 삭제");
		
		tableMoveBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 800, 50);
		tableMoveBtn.setText("테이블 이동");
		
		numberListPanel=(JPanel) ccUtil.createJcomponent("p", 810, 355, 85, 125);
		numberListPanel_2=(JPanel) ccUtil.createJcomponent("p", 800, 345, 5, 5);
		


				
	}
	@Override
	public void addGui() {
		this.add(mainPanel);

		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(155,155,155));
		mainPanel.add(timePanel);
		timePanel.add(time);
			
	

		mainPanel.add(tableAddBtn);
		mainPanel.add(tableDelBtn);
		mainPanel.add(tableMoveBtn);
		mainPanel.add(numberListPanel);
		
		mainPanel.add(title);
		title.setForeground(Color.white);
		title.setFont(new Font("맑은고딕",Font.BOLD, 20));

			
		
		numberListPanel.setLayout(null);
		numberListPanel.setBackground(new Color(0xFFFFFF));
		numberListPanel.add(numberListPanel_2);
		numberListPanel_2.setLayout(new GridLayout(3, 5, 10, 10));
		numberListPanel_2.setBackground(new Color(0xFFFFFF));
	
		//numberListPanel.set

		ArrayList<JList> jlistList = new ArrayList<JList>();
		for(int i=0;i<12;i++) {
			jlistList.add(new JList<String>(new String[]{"테이블"+(i+1)}));
			jlistList.get(i).setBackground(new Color(85, 239, 196));
		
			numberListPanel_2.add(jlistList.get(i));
		}
		
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
	@Override
	public void initEvent() {
		// TODO Auto-generated method stub
		
	}
}	