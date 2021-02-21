package posMachineProject.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import gui.util.CreateComponentUtil;

public class TableManageFrame extends FrameTemplate implements Runnable{
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	
	JPanel mainPanel;
	JPanel timePanel;
	
	
	JPanel numberListPanel;
	JPanel numberListPanel_2;
	JPanel numberListPanel_3;
	JPanel numberListPanel_4;
	
	JLabel title;		
	JLabel time;
	JLabel page;
	
	List<JButton> tableButtonList;


	JButton tableAddBtn;
	JButton tableDelBtn;
	JButton tableMoveBtn;
	JButton PrePageMove;
	JButton NextPageMove;
	JButton selectedBtn;

	public TableManageFrame() {
		init();
	}
	
	@Override
	public void initComponent() {
		tableButtonList = new ArrayList<JButton>();

		mainPanel = new JPanel();
		//Util?��  default�? ?��?��?��?�� ?��?��?��
		ccUtil.setMainPanel(mainPanel);
		
		timePanel=(JPanel)  ccUtil.createJcomponent("p", width*23/100,height*5/100, 50, 50);
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		time.setFont(new Font("맑�?고딕",Font.BOLD, 15));		
		
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		time.setFont(new Font("맑�?고딕",Font.BOLD, 15));
		
		
		title=(JLabel) ccUtil.createJcomponent("l", 200, 50,435, 25);
		page=(JLabel) ccUtil.createJcomponent("l", 70, 40, 479, 490);
		page.setFont(new Font("맑�?고딕",Font.BOLD, 18));

		
		tableAddBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 560, 50);
		tableAddBtn.setText("?��?���? 추�?");
		
		tableDelBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 680, 50);
		tableDelBtn.setText("?��?���? ?��?��");
		PrePageMove= (JButton) ccUtil.createJcomponent("bw",50, 30, 20, 260);
		NextPageMove= (JButton) ccUtil.createJcomponent("be",50, 30, 915, 260);

		
		tableMoveBtn=(JButton) ccUtil.createJcomponent("b",100, 30, 800, 50);
		tableMoveBtn.setText("?��?���? ?��?��");
		
		numberListPanel=(JPanel) ccUtil.createJcomponent("p", 810, 370, 85, 100);
		numberListPanel_2=(JPanel) ccUtil.createJcomponent("p", 800, 345, 5, 5);
		numberListPanel_3=(JPanel) ccUtil.createJcomponent("p", 800, 345, 5, 5);
		numberListPanel_4=(JPanel) ccUtil.createJcomponent("p", 800, 345, 5, 5);

		

		
	}
	@Override
	public void addGui() {
		this.add(mainPanel);

		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(223, 228, 234));
		mainPanel.add(timePanel);
		timePanel.add(time);
		timePanel.setBackground(new Color(116, 125, 140));
		
		
		// page ?��?��버튼
		mainPanel.add(PrePageMove);
		mainPanel.add(NextPageMove);

		mainPanel.add(tableAddBtn);
		mainPanel.add(tableDelBtn);
		mainPanel.add(tableMoveBtn);
		mainPanel.add(numberListPanel);
		mainPanel.add(page);
			
		mainPanel.add(title);
		title.setForeground(Color.white);
		title.setFont(new Font("맑�?고딕",Font.BOLD, 20));


		numberListPanel.setLayout(null);
		numberListPanel.setBackground(new Color(223, 228, 234));
		numberListPanel.add(numberListPanel_2);
		numberListPanel.add(numberListPanel_3);
		numberListPanel.add(numberListPanel_4);

		numberListPanel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 9, 15));
		numberListPanel_2.setBackground(new Color(223, 228, 234));
		numberListPanel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 9, 15));
		numberListPanel_3.setBackground(new Color(223, 228, 234));
		numberListPanel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 9, 15));
		numberListPanel_4.setBackground(new Color(223, 228, 234));

		

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
				String day1 = (year +"?�� " + month + "?�� " + date + "?�� " + ampm + " " + hour + ":0" + min + ":0" + sec );
				time.setText(day1);
			} else if((min>10) && (sec<10)) {
				String day2 = (year +"?�� " + month + "?�� " + date + "?�� " + ampm + " " + hour + ":" + min + ":0" + sec );
				time.setText(day2);
			} else if((min<10) && (sec>10)) {
				String day3 = (year +"?�� " + month + "?�� " + date + "?�� " + ampm + " " + hour + ":0" + min + ":" + sec );
				time.setText(day3);
			} else {
				String day4 = (year +"?�� " + month + "?�� " + date + "?�� " + ampm + " " + hour + ":" + min + ":" + sec );
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
		Color bc = new Color(27, 156, 252); 
		// �?경된 ?��?��
		Color cc = new Color(241, 196, 15);
		
				
		//?��?���? 추�?버튼
		tableAddBtn.addMouseListener(new MouseAdapter() {
		      
			  public void mouseClicked(MouseEvent e) {
				  	int i = tableButtonList.size();
					JButton tmpButton = new JButton((i+1)+"�? TABLE");
					tableButtonList.add(tmpButton);
					
					tmpButton.setPreferredSize(new Dimension(150, 100));
					tmpButton.setVerticalAlignment(SwingConstants.TOP);
					tmpButton.setBackground(bc);
					tmpButton.setFont(new Font("?��??",Font.BOLD, 16));	
					tmpButton.setForeground(Color.white);

					if(tableButtonList.size() <= 15) {
						numberListPanel_2.add(tmpButton);
						page.setText("1/3");
					}
					if(tableButtonList.size() > 15 && tableButtonList.size() <31){
						numberListPanel_2.setVisible(false);
						numberListPanel_3.setVisible(true);
						numberListPanel_3.add(tmpButton);
						page.setText("2/3");
					} 
					if(tableButtonList.size() > 30 && tableButtonList.size() <46) {
						numberListPanel_2.setVisible(false);
						numberListPanel_3.setVisible(false);
						numberListPanel_4.setVisible(true);
						numberListPanel_4.add(tmpButton);
						page.setText("3/3");

					}
					if(tableButtonList.size() == 46) {
						JOptionPane.showMessageDialog(null, "?��?��블�? 45개까�? 만들?�� ?��?��?��?��.", "�? ?��",JOptionPane.WARNING_MESSAGE);
						tableButtonList.remove(45);
					}
					
			// ?���??�� 버튼?��?�� �?�? �? ?��?���? ?��?��
			tmpButton.addMouseListener(new MouseAdapter() {
				  public void mouseClicked(MouseEvent e) {
					  if(tmpButton.getBackground() == bc) {
							tmpButton.setBackground(cc);
							String[] st = {"?��", "?��?��?��", "?��?��"};
							int num = JOptionPane.showOptionDialog(null, "?��?��블을 ?��?��?��?��겠습?���??.", "?��?���? ?��?��", JOptionPane.DEFAULT_OPTION, 1, null, st, st[0]);
								
								if(num == 0) {JOptionPane.showMessageDialog(null, "�?경할 ?��?��블을 ?��?��?�� 주세?��.");
									tmpButton.setBackground(bc);}		
								else if(num==1) {tmpButton.setBackground(bc);}
								else if(num==2) {
									JOptionPane.showMessageDialog(null, "?��?��블이 ?��?��?��?��?��?��?��.");
									tmpButton.setBackground(bc);}
								
							 }		
						 else if(tmpButton.getBackground() == cc) {
							 	tmpButton.setBackground(bc);
									 }
					  	  
					  }
				  
			});
		
			}
			  
		});
		
		// ?��?���? ?��?��버튼
		tableDelBtn.addMouseListener(new MouseAdapter() { 
			  public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null, "?��말로 ?��?��블을 ?��?��?��?��겠습?���??", "�? ?��",JOptionPane.WARNING_MESSAGE);
				int i = tableButtonList.size();
				tableButtonList.get(i-1).setVisible(false);
				tableButtonList.remove(i-1);		
					if(tableButtonList.size()==15) {
						numberListPanel_3.setVisible(false);
						numberListPanel_2.setVisible(true);
						page.setText("1/3");
					}
					else if(tableButtonList.size() == 30) {
						numberListPanel_4.setVisible(false);
						numberListPanel_3.setVisible(true);
						page.setText("2/3");
					}
		
			  }
		});
	 
		
		// ?��?���? ?��?��버튼
		tableMoveBtn.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
				  JOptionPane.showMessageDialog(null, "?��?��?�� ?��?��블을 ?��?��?�� 주세?��.");
			  				 	
			  }
			  
		});
		// ?��?�� ?��?���?
		PrePageMove.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
					if(tableButtonList.size() <15) {
						numberListPanel_2.setVisible(true);
						JOptionPane.showMessageDialog(null, "?��?�� ?��?���?�? 존재?���? ?��?��?��?��.");
					}
					else if(tableButtonList.size() >15 && tableButtonList.size() < 31) {
						numberListPanel_3.setVisible(false);
						numberListPanel_2.setVisible(true);
						page.setText("1/3");

					}
					else if(tableButtonList.size() > 30 && tableButtonList.size() < 46) {
						if(numberListPanel_3.isVisible() == false && numberListPanel_4.isVisible() == true) {
							numberListPanel_4.setVisible(false);
							numberListPanel_3.setVisible(true);
							page.setText("2/3");

						} else if(numberListPanel_3.isVisible() == true && numberListPanel_4.isVisible() == false){
							numberListPanel_2.setVisible(true);
							numberListPanel_3.setVisible(false);
							page.setText("1/3");

						} 
										
					}
			  }
		});
		
		// ?��?�� ?��?���?
		NextPageMove.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
				    if(tableButtonList.size() <15) {
						numberListPanel_2.setVisible(true);

					}
					else if(tableButtonList.size() >15 && tableButtonList.size() < 31) {
						numberListPanel_2.setVisible(false);
						numberListPanel_3.setVisible(true);
						page.setText("2/3");

					}
					else if(tableButtonList.size() > 30) {
						if(numberListPanel_3.isVisible() == false && numberListPanel_4.isVisible() == true) {
							page.setText("2/3");
							JOptionPane.showMessageDialog(null, "?��?�� ?��?���?�? 존재?���? ?��?��?��?��.");
						}  else if(numberListPanel_3.isVisible() == true && numberListPanel_4.isVisible() == false){
							numberListPanel_3.setVisible(false);
							numberListPanel_4.setVisible(true);
							page.setText("3/3");
						}  else if(numberListPanel_2.isVisible() == true && numberListPanel_3.isVisible() == false){
							numberListPanel_2.setVisible(false);
							numberListPanel_3.setVisible(true);
							page.setText("2/3");
						}
					}
		
			  }
		});
		
	}

}
	