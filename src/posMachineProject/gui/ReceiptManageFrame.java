package posMachineProject.gui;

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
import posMachineProejct.manager.ReceiptManager;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class ReceiptManageFrame extends FrameTemplate implements Runnable{
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
	JPanel dateSelect;  // ��¥ ����â ���� �ʿ�

	
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
	JButton goBackBtn;
	
	int size;
	int size2;
	int totalSum;
	
	UtilDateModel model;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	
	DefaultTableModel datetablemodel; 
	String[] header,header2;
	Object[][] contents,contents2;
	
	public ReceiptManageFrame() {
		init();
		Thread t1 = new Thread(this);
		t1.start();
	}
	
 
	@Override
	public void initComponent() {
		mainPanel = new JPanel();
		//Util��  default�� �����ؾ� �ϴ���
		ccUtil.setMainPanel(mainPanel);
		//�ð��� �г�, ���̺�
		timePanel=(JPanel)  ccUtil.createJcomponent("p", width*23/100,height*5/100, 50, 50);
		time=(JLabel) ccUtil.createJcomponent("l", width*3/10, height/6, width*4/10, height/60*5);
		time.setForeground(Color.white);
		time.setFont(new Font("�������",Font.BOLD, 15));	

		// ��������  �г�
		paymentPanel= (JPanel) ccUtil.createJcomponent("p",width*30/100,height*60/100, width*15/100,height*20/100);
		paymentTitlePanel = (JPanel) ccUtil.createJcomponent("p",width*30/100,height*45/1000, 0,0);
		paymentDetail=(JPanel) ccUtil.createJcomponent("p",width*30/100,height*955/1000, 0, height*45/1000);
		paymentContent=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*245, width/1000*50, height/600*65);

		// �󼼳��� �г�
		detailTitlePanel = (JPanel) ccUtil.createJcomponent("p", width*30/100,height*45/1000, 0,0);
		detailPanel= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*60/100, width*55/100,height*20/100);
		detail= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*955/1000, 0, height*45/1000);
		detailContent=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*190, width/1000*50, height/600*40);
		totalPanel=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*25, width/1000*50,height/600*230);

		history=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, 0, 0);
		times=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, width/1000*205/3, 0);
		price=(JPanel) ccUtil.createJcomponent("p", width/1000*205/3, height/600*575, width/1000*205/3*2, 0);

		// ��������, �󼼳��� ���̺�
		dateLabel=(JLabel) ccUtil.createJcomponent("l", width*30/100,height*45/1000, width*0/100, height*0/100);
		dateLabel.setText("��¥����");
		dateLabel.setFont(new Font("�������",Font.BOLD, 15));	
		
		deatailLabel=(JLabel) ccUtil.createJcomponent("l",width*30/100,height*45/1000, width*0/100, height*0/100);
		deatailLabel.setText("�󼼳���");
		deatailLabel.setFont(new Font("�������",Font.BOLD, 15));	

		totalLabel=(JLabel) ccUtil.createJcomponent("l",width/1000*205, height/600*25, 0, 0);
		

		
		// Table ����(�����ݾ�, �����ð�)
		header = new String[] {"�����ݾ�","�����ð�"};
		contents=rm.CreateReceiptJtableContents(year, month, day);

    	datetablemodel = new DefaultTableModel(contents,header){
		// ����Ŭ���ؼ� �����Ұ�
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		
		
		dateTable = new JTable(datetablemodel);
		dateScrollpane = new JScrollPane(dateTable);
		dateScrollpane.setPreferredSize(new Dimension(width/1000*195,height/600*235));
		
		
		// Table ����(����, ����Ƚ��, ����)
		header2 = new String[] {"�� ��","����Ƚ��","�� ��"};
		contents2=rm.CreateReceiptDetailJtableContents(0);
		DefaultTableModel model2 = new DefaultTableModel(contents2,header2){
		// ����Ŭ���ؼ� �����Ұ�
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		
		
		detailTable = new JTable(model2);
		detailScrollpane = new JScrollPane(detailTable);
		detailScrollpane.setPreferredSize(new Dimension(width/1000*195,height/600*180));
		
		//��ư 
		receiptPrintButton=(JButton) ccUtil.createJcomponent("b", width/10, height/600*30, width/1000*60, height/600*280);
		receiptPrintButton.setText("������ ���");
		returnButton=(JButton) ccUtil.createJcomponent("b", width/15, height/600*30, width/1000*185, height/600*280);
		returnButton.setText("�� ǰ");
		goBackBtn=(JButton)ccUtil.createJcomponent("b",80, 50, 805,35);
		goBackBtn.setText("�ڷΰ���");
		goBackBtn.setFont(new Font("���� ���",Font.BOLD, 10));

		//��¥���� 
		dateSelect=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*40, width/1000*50, height/600*20);
		
	}

	@Override
	public void addGui() {
		this.add(mainPanel);
		
		// ��¥����â
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setPreferredSize(new Dimension(200,25));
		datePicker.setFont(new Font("�������",Font.BOLD, 15));	
		dateSelect.add(datePicker);
		dateSelect.setBackground(new Color(30, 144, 255));
		
		
		// �޷¿��� ���õ� �� �ޱ� : model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay();
		
		// ��ǰ�׸� �г�
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(155,155,155));
		mainPanel.setBackground(new Color(223, 228, 234));
		
		mainPanel.add(goBackBtn);

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

		// ī�װ� �г�		
		
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
		totalPanel.add(totalLabel);  // �ݾ� ���հ�
		totalLabel.setText("�հ�" + " " + (df.format(totalSum)) +"��");

		totalPanel.setBackground(new Color(236, 204, 104));

		detailContent.add(detailScrollpane);


	}
	@Override
	public void initEvent() {
		//������ ���
		receiptPrintButton.addMouseListener(new MouseAdapter() { 
			  public void mouseClicked(MouseEvent e) {
				  String[] st = {"��", "�ƴϿ�"};
					int num = JOptionPane.showOptionDialog(null, "�������� ���  �Ͻðڽ��ϱ�?.", "������ ���", JOptionPane.DEFAULT_OPTION, 1, null, st, st[0]);
						
						if(num == 0) {JOptionPane.showMessageDialog(null, "�������� ��µ˴ϴ�.");
							
						}	
				  }
		});
		
		//��ǰ��ư 
		returnButton.addMouseListener(new MouseAdapter() { 
			  public void mouseClicked(MouseEvent e) {
				  String[] st = {"��", "�ƴϿ�"};
					int num = JOptionPane.showOptionDialog(null, "��ǰó�� �Ͻðڽ��ϱ�?.", "��ǰ ó��", JOptionPane.DEFAULT_OPTION, 1, null, st, st[0]);
						
						if(num == 0) {
							rm.returnThisSale((int)contents[dateTable.getSelectedRow()][2]);
							contents=rm.CreateReceiptJtableContents(year, month, day);					
							dateTable.setModel(new DefaultTableModel(contents,header));
							detailTable.setModel(new DefaultTableModel(null,header2));	
							
							dateTable.getColumnModel().getColumn(0).setPreferredWidth(100);
							dateTable.getColumnModel().getColumn(1).setPreferredWidth(150);
							
							totalLabel.setText("");
							
							JOptionPane.showMessageDialog(null, "��ǰó�� �Ǿ����ϴ�.");
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
					totalLabel.setText("�հ� "+String.valueOf(total)+" ��");
					totalPanel.setBackground(new Color(236, 204, 104));
				}
				if(contents[dateTable.getSelectedRow()][3].equals("return")) {
					totalLabel.setText("��ǰ "+String.valueOf(total)+" ��");
					totalPanel.setBackground(new Color(200, 80, 80));
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
				String day1 = (year +"�� " + month + "�� " + date + "�� " + ampm + " " + hour + ":0" + min + ":0" + sec );
				time.setText(day1);
			} else if((min>10) && (sec<10)) {
				String day2 = (year +"�� " + month + "�� " + date + "�� " + ampm + " " + hour + ":" + min + ":0" + sec );
				time.setText(day2);
			} else if((min<10) && (sec>10)) {
				String day3 = (year +"�� " + month + "�� " + date + "�� " + ampm + " " + hour + ":0" + min + ":" + sec );
				time.setText(day3);
			} else {
				String day4 = (year +"�� " + month + "�� " + date + "�� " + ampm + " " + hour + ":" + min + ":" + sec );
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