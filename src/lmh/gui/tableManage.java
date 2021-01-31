package lmh.gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;

import gui.util.CreateComponentUtil;
import lmh.manager.PageManager;

public class tableManage extends FrameTemplate{
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	
	JPanel mainPanel;
	JPanel timePanel;
	
	
	JPanel numberListPanel;
	JPanel numberListPanel_2;
	
	JLabel title;		
	JLabel time;
	
	List<JButton> tableButtonList;
	JButton tableAddBtn;
	JButton tableDelBtn;
	JButton tableMoveBtn;
	JButton PrePageMove;
	JButton NextPageMove;
	

	public tableManage() {
		init();
	}
	
	@Override
	public void initComponent() {
		tableButtonList = new ArrayList<JButton>();

		mainPanel = new JPanel();
		//Util에  default로 세팅해야 하는함
		ccUtil.setMainPanel(mainPanel);
		
		timePanel=(JPanel)  ccUtil.createJcomponent("p", width*23/100,height*5/100, width*5/100,height*50/1000);
		
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		
		
		title=(JLabel) ccUtil.createJcomponent("l", 200, 50,435, 25);
			
		tableAddBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 560, 50);
		tableAddBtn.setText("테이블 추가");
		
		tableDelBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 680, 50);
		tableDelBtn.setText("테이블 삭제");
		PrePageMove= (JButton) ccUtil.createJcomponent("bw",50, 30, 20, 260);
		NextPageMove= (JButton) ccUtil.createJcomponent("be",50, 30, 915, 260);

		
		tableMoveBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 800, 50);
		tableMoveBtn.setText("테이블 이동");
		
		numberListPanel=(JPanel) ccUtil.createJcomponent("p", 810, 355, 85, 125);
		numberListPanel_2=(JPanel) ccUtil.createJcomponent("p", 800, 345, 5, 5);
		
		
		for(int i =0; i < 12; i++)
		{
			JButton tmpButton = new JButton((i+1)+"번 TABLE");
			tmpButton.setPreferredSize(new Dimension(120, 80));
			tableButtonList.add(tmpButton);
			tmpButton.setVerticalAlignment(SwingConstants.TOP);
			tmpButton.setBackground(new Color(123, 237, 159));
			tmpButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
			tmpButton.setFont(new Font("돋움",Font.BOLD, 14));
		}
		


				
	}
	@Override
	public void addGui() {
		this.add(mainPanel);

		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(223, 228, 234));
		mainPanel.add(timePanel);
		timePanel.add(time);
		timePanel.setBackground(new Color(116, 125, 140));
			
		// page 이동버튼
		mainPanel.add(PrePageMove);
		mainPanel.add(NextPageMove);

		mainPanel.add(tableAddBtn);
		mainPanel.add(tableDelBtn);
		mainPanel.add(tableMoveBtn);
		mainPanel.add(numberListPanel);
		
		
		
		mainPanel.add(title);
		title.setForeground(Color.white);
		title.setFont(new Font("맑은고딕",Font.BOLD, 20));


		numberListPanel.setLayout(null);
		numberListPanel.setBackground(new Color(223, 228, 234));
		numberListPanel.add(numberListPanel_2);
		numberListPanel_2.setLayout(new GridLayout(3, 5, 10, 10));
		numberListPanel_2.setBackground(new Color(223, 228, 234));
		
		for(int i = 0; i < tableButtonList.size(); i ++)
		{
			numberListPanel_2.add(tableButtonList.get(i));
		}
		
		//numberListPanel.set
		
		
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
	//테이블 삭제 버튼
	public void initEvent() {
		
	
		//테이블 추가 버튼
		tableAddBtn.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
				  int num = JOptionPane.showConfirmDialog(null, "테이블을 추가하시겠습니까?");
					if(num==0) {
						// 추가할 경우 구현
					}
					else {
					} 
			
			  }
	});
			
		// 테이블 삭제버튼
		tableDelBtn.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
				  JOptionPane.showMessageDialog(null, "정말로 테이블을 삭제하시겠습니까?", "주 의",JOptionPane.WARNING_MESSAGE);
			  }
		});
	 
		
		// 테이블 이동버튼
		tableMoveBtn.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
				 JOptionPane.showMessageDialog(null, "이동시킬 테이블을 선택하세요.");

			  }
			  
		});
	
		((Component) tableButtonList).addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
				  ((Component) tableButtonList).setBackground(new Color(223, 228, 234));
			  }
			  
		});
	}

}
	