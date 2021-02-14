package lmh.gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.conf.DatabaseUrlContainer;

import ServiceImpl.MenuServiceImpl;
import daoImpl.MenuDaoImpl;
import data.CategoryVO;
import data.MenuVO;
import database.VOFactory;
import gui.util.CreateComponentUtil;
import lmh.manager.MenuManager;


public class GoodsManage extends FrameTemplate {
	MenuManager mm = new MenuManager();
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	
	
	JPanel mainPanel;
	JPanel timePanel;
	
	JPanel itemPanel;
	JPanel itemTitlePanel;
	JPanel itemDetail;
	JPanel itemContent;
	JPanel tableContent;
	JPanel tableField;
	JPanel tableValue;
	JPanel name;
	JPanel price;
	JPanel order;
	
	JPanel categoryPanel;
	JPanel categoryTitlePanel;
	JPanel categoryDetail;
	JPanel categoryContent;
	
	JLabel time;
	JLabel itemLabel;
	JLabel fieldName;
	JLabel categoryLabel;
	JLabel nameLabel;
	JLabel priceLabel;
	JLabel orderLabel;
	JLabel itemName;
	JLabel itemPrice;
	JLabel itemCategory;
	
	JTable itemTable;
	JTable categoryTable;
	JScrollPane CategoryScrollpane;
	JScrollPane salesScrollpane;
	
	JButton itemAddButton;
	JButton categoryAddButton;
	
	JButton itemDelButton;
	JButton categoryDelButton;
	JButton saveButton;
	
	JTextField itemTextField1;
	JTextField itemTextField2;
	JTextField itemTextField3;
	JTextField categoryTextField;
	int menuSize;
	int categorySize;
	
	public GoodsManage() {
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
		
		//물품항목  패널
		itemPanel= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*60/100, width*15/100,height*20/100);
		itemTitlePanel =(JPanel)  ccUtil.createJcomponent("p", width*30/100,height*45/1000, 0,0);
		itemDetail=(JPanel) ccUtil.createJcomponent("p", width*30/100,height*955/1000, 0, height*45/1000);
		itemContent=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*200, width/1000*50, height/600*60);
		tableValue=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*575, 0, 0);



		// 카테고리 패널
		categoryTitlePanel =(JPanel) ccUtil.createJcomponent("p",width*30/100,height*45/1000, 0,0);
		categoryPanel=(JPanel) ccUtil.createJcomponent("p",width*30/100,height*60/100, width*55/100,height*20/100);
		categoryDetail=(JPanel) ccUtil.createJcomponent("p",width*30/100,height*955/1000, 0, height*45/1000);
		categoryContent=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*200, width/1000*50, height/600*60);


		//물품항목, 카테고리 레이플 
		itemLabel=(JLabel) ccUtil.createJcomponent("l", width*30/100,height*45/1000, 0, 0);
		itemLabel.setText("판매항목()");
		itemLabel.setFont(new Font("맑은고딕",Font.BOLD, 15));
		
		itemName =(JLabel) ccUtil.createJcomponent("l", width/1000*40, height/600*40, width/1000*15, height/600*10);
		itemName.setText("이 름:");
		itemName.setFont(new Font("맑은고딕",Font.BOLD, 12));
		itemPrice=(JLabel) ccUtil.createJcomponent("l", width/1000*40, height/600*40, width/1000*105, height/600*10);
		itemPrice.setText("가 격:");
		itemCategory=(JLabel) ccUtil.createJcomponent("l", width/1000*40, height/600*40, width/1000*195, height/600*10);
		itemCategory.setText("종 류:");

		
		categoryLabel=(JLabel) ccUtil.createJcomponent("l",width*30/100,height*45/1000, width*0/100, height*0/100);
		categoryLabel.setText("카테고리");
		categoryLabel.setFont(new Font("맑은고딕",Font.BOLD, 15));
		
		//버튼 
		saveButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*120, height/600*280);
		saveButton.setText("저 장");
		itemAddButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*40, height/600*280);
		itemAddButton.setText("추 가");
		categoryAddButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*190, height/600*15);
		categoryAddButton.setText("추 가");
		itemDelButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*200, height/600*280);
		itemDelButton.setText("삭 제");
		categoryDelButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*185, height/600*280);
		categoryDelButton.setText("삭 제");
				
		//텍스트 필드
	 	itemTextField1=(JTextField) ccUtil.createJcomponent("tf",width/1000*45, height/600*20, width/1000*50, height/600*20);
	 	itemTextField2=(JTextField) ccUtil.createJcomponent("tf",width/1000*45, height/600*20, width/1000*140, height/600*20);
	 	itemTextField3=(JTextField) ccUtil.createJcomponent("tf",width/1000*45, height/600*20, width/1000*230, height/600*20);
	 	
		categoryTextField=(JTextField) ccUtil.createJcomponent("tf", width/1000*120, height/600*20, width/1000*50, height/600*20);
				
	
		
	//itemTable 생성
		String header[] = {"이 름","가 격","종 류"};
		menuSize = mm.selectMenuList().size();   
		ArrayList<MenuVO> menuList= (ArrayList)mm.selectMenuList();
		String[][] contents = new String[menuSize][3];  // 리스트 사이즈를 먼저 선언
		for(int i=0; i < menuList.size(); i++) {
			contents[i][0] = menuList.get(i).getMenuName();   // i번째 열의 MenuName
			contents[i][1] = "" + menuList.get(i).getMenuPrice();  // i번째 열의 MenuPrice
			contents[i][2] = menuList.get(i).getMenuCategory(); // i번째 열의 MenuCategory
		}
		DefaultTableModel model = new DefaultTableModel(contents,header) {
		// 더블클릭해서 수정불가
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		itemTable = new JTable(model);
		salesScrollpane = new JScrollPane(itemTable);
		salesScrollpane.setPreferredSize(new Dimension(width/1000*200,height/600*195));
		
		//테이블(열) 삭제 기능
		itemDelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(itemTable.getSelectedRow() == -1) 
				{
				return;
				} else 
				{
				model.removeRow(itemTable.getSelectedRow());
				}
			}
		});
		
		//CategoryTable 생성

		String header2[] = {"카 테 고 리"};
		categorySize = mm.selectCategoryList().size();   
		ArrayList<CategoryVO> categoryList = (ArrayList)mm.selectCategoryList();
		String[][] contents2 = new String[categorySize][1];
		for(int j=0; j < categoryList.size(); j++) {
			contents2[j][0] = categoryList.get(j).getCategoryName();

		}
		DefaultTableModel model2 = new DefaultTableModel(contents2,header2){
		// 더블클릭해서 수정불가
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		
		categoryTable = new JTable(model2);
		CategoryScrollpane = new JScrollPane(categoryTable);
		CategoryScrollpane.setPreferredSize(new Dimension(width/1000*200,height/600*195));
		
		
	}
	


	@Override
	public void addGui() {
		this.add(mainPanel);
		
		// 물품항목 패널
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(223, 228, 234));

		mainPanel.add(timePanel);
		timePanel.add(time);
		timePanel.setBackground(new Color(116, 125, 140));

		mainPanel.add(itemPanel);
		itemPanel.setLayout(null);
		itemPanel.setBackground(new Color(100, 100, 100));
		itemPanel.add(itemTitlePanel);
		itemPanel.add(itemDetail);
		
		itemTitlePanel.add(itemLabel);
		
		itemPanel.add(itemDetail);
		itemDetail.setLayout(null);
		itemDetail.setBackground(new Color(30, 144, 255));

		itemDetail.add(itemName);
		itemDetail.add(itemPrice);
		itemDetail.add(itemCategory);
		itemDetail.add(itemTextField1);
		itemDetail.add(itemTextField2);
		itemDetail.add(itemTextField3);
		itemDetail.add(itemAddButton);
		itemDetail.add(saveButton);
		itemDetail.add(itemDelButton);
		itemDetail.add(itemContent);
		itemContent.add(salesScrollpane);


		
		// 카테고리 패널		
		
		mainPanel.add(categoryPanel);
		categoryPanel.setLayout(null);
		categoryPanel.setBackground(new Color(100, 100, 100));
		categoryPanel.add(categoryTitlePanel);
		categoryPanel.add(categoryDetail);
		
		
		categoryTitlePanel.add(categoryLabel);

		
		categoryPanel.add(categoryDetail);
		categoryDetail.setLayout(null);
		categoryDetail.setBackground(new Color(30, 144, 255));

		categoryDetail.add(categoryTextField);
		categoryDetail.add(categoryAddButton);
		categoryDetail.add(categoryDelButton);
		categoryDetail.add(categoryContent);
		categoryContent.add(CategoryScrollpane);
		
		 		  

       }
			
	@Override
	public void initEvent() {

			
/*			
	@Override
	public void actionPerformed(ActionEvent e) {

//		현재 텍스트 필드에 있는 값을 각각의 변수에 대입 
		String num = tfNum.getText(); // 번호
		String name = tfName.getText(); // 이름
		String address = tfAddress.getText(); // 주소

//		각각의 변수에 저장된 값을 데이터베이스에 Insert하는 메소드

		insert(num, name, address);

//		신규 저장된 데이터를 데이터베이스에서 다시 읽어와서 result 벡터에 저장 

		Vector result = selectAll();

//		변경된 데이터(벡터)로 모델 갱신 -> 테이블 표시 갱신됨 

		model.setDataVector(result, title);
	}
});
*/
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
