package posMachineProject.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import data.CategoryVO;
import data.MenuVO;
import data.OrderDetailVO;
import gui.util.CreateComponentUtil;
import posMachineProejct.manager.MenuManager;
import posMachineProject.daoImpl.MenuDaoImpl;


public class GoodsManageFrame extends FrameTemplate {
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
	JLabel itemSequence;
	
	JTable itemTable;
	JTable categoryTable;
	JScrollPane CategoryScrollpane;
	JScrollPane salesScrollpane;
	
	JButton itemAddButton;
	JButton categoryAddButton;
	
	JButton itemDelButton;
	JButton categoryDelButton;
	JButton saveButton;
	JButton goBackButton;
	
	JTextField itemTextField1;
	JTextField itemTextField2;
	JTextField itemTextField3;
	JTextField categoryTextField;
	List<MenuVO> updateItemDetailList = new ArrayList<MenuVO>();
	List<MenuVO> deleteItemDetailList = new ArrayList<MenuVO>();
	List<MenuVO> insertItemDetailList = new ArrayList<MenuVO>();
	int menuSize;
	int menuSize2;

	int categorySize;
	int selectedItemTableRow;
	int selectedCategoryTableRow;
	
	public GoodsManageFrame() {
		super.init();
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
		itemSequence=(JLabel) ccUtil.createJcomponent("l", width/1000*40, height/600*40, width/1000*195, height/600*10);
		itemSequence.setText("순 서:");

		
		categoryLabel=(JLabel) ccUtil.createJcomponent("l",width*30/100,height*45/1000, width*0/100, height*0/100);
		categoryLabel.setText("카테고리");
		categoryLabel.setFont(new Font("맑은고딕",Font.BOLD, 15));
		
		//버튼 
		goBackButton=(JButton) ccUtil.createJcomponent("b",width/10, height/600*30, width/10*8, height/60*5);
		goBackButton.setText("뒤로가기");
		itemAddButton=(JButton) ccUtil.createJcomponent("b",width/12, height/600*30, width/1000*60, height/600*280);
		itemAddButton.setText("추 가");
		categoryAddButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*190, height/600*15);
		categoryAddButton.setText("추 가");
		itemDelButton=(JButton) ccUtil.createJcomponent("b",width/12, height/600*30, width/1000*165, height/600*280);
		itemDelButton.setText("삭 제");
		categoryDelButton=(JButton) ccUtil.createJcomponent("b",width/12, height/600*30, width/1000*165, height/600*280);
		categoryDelButton.setText("삭 제");
				
		//텍스트 필드
	 	itemTextField1=(JTextField) ccUtil.createJcomponent("tf",width/1000*45, height/600*20, width/1000*50, height/600*20);
	 	itemTextField2=(JTextField) ccUtil.createJcomponent("tf",width/1000*45, height/600*20, width/1000*140, height/600*20);
	 	itemTextField3=(JTextField) ccUtil.createJcomponent("tf",width/1000*45, height/600*20, width/1000*230, height/600*20);
		categoryTextField=(JTextField) ccUtil.createJcomponent("tf", width/1000*120, height/600*20, width/1000*50, height/600*20);
				
	
		
	//itemTable 생성
		String header[] = {"이 름","가 격","순 서"};
		menuSize = mm.selectMenuList().size();   
		ArrayList<MenuVO> menuList= (ArrayList)mm.selectMenuList();
		String[][] contents = new String[menuSize][3];  // 리스트 사이즈를 먼저 선언
		for(int i=0; i < menuList.size(); i++) {
			contents[i][0] = null;   // i번째 열의 MenuName
			contents[i][1] = null;  // i번째 열의 MenuPrice
			contents[i][2] = null; // i번째 열의 MenuCategory
		}
		DefaultTableModel model = new DefaultTableModel(contents,header) {
		// 더블클릭해서 수정불가
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		itemTable = new JTable(model);
		itemTable.setAutoCreateRowSorter(true);
		TableRowSorter tablesorter = new TableRowSorter(itemTable.getModel());
		itemTable.setRowSorter(tablesorter);
		salesScrollpane = new JScrollPane(itemTable);
		salesScrollpane.setPreferredSize(new Dimension(width/1000*200,height/600*195));
		
	
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
		mainPanel.add(goBackButton);


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
		itemDetail.add(itemSequence);
		itemDetail.add(itemTextField1);
		itemDetail.add(itemTextField2);
		itemDetail.add(itemTextField3);
		itemDetail.add(itemAddButton);
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
		
		//테이블 선택시 테이블 열
		itemTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedItemTableRow = itemTable.getSelectedRow();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		categoryTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedCategoryTableRow = categoryTable.getSelectedRow();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		


		//항목테이블(row) 추가 기능
		itemAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int categoryNum = categoryTable.getSelectedRow()+1;
				mm.insertItemDetail(categoryNum, itemTextField1.getText(), Integer.parseInt(itemTextField2.getText()), Integer.parseInt(itemTextField3.getText()));
				String inputStr[]= new String[3];
				
				inputStr[0] = itemTextField1.getText();
				inputStr[1] = itemTextField2.getText();
				inputStr[2] = itemTextField3.getText();
				
				DefaultTableModel model = (DefaultTableModel)itemTable.getModel();
				model.addRow(inputStr);
				
				System.out.println(itemTextField1.getText() + "추가");
				
				itemTextField1.setText("");
				itemTextField2.setText("");
				itemTextField3.setText("");
				
			}
		});
		
		//항목테이블(row) 삭제 기능
		itemDelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(itemTable.getSelectedRow() == -1) 
				{
				return;
				}else {
					DefaultTableModel model = (DefaultTableModel)itemTable.getModel();
					int selectedRow = itemTable.getSelectedRow();
					String menuName = itemTable.getValueAt(selectedRow,0).toString();
					System.out.println(menuName);
					mm.deleteItemDetail(menuName + "삭제");
					model.removeRow(itemTable.getSelectedRow());
					

				}
			}
		});
	
		
		//카테고리 테이블(row) 추가 기능
		categoryAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputStr[]= new String[1];
				inputStr[0] = categoryTextField.getText();
							
				DefaultTableModel model = (DefaultTableModel)categoryTable.getModel();
				model.addRow(inputStr);
				
				int row = categoryTable.getRowCount();
				mm.insertCategoryDetail(row,categoryTextField.getText());
				System.out.println(categoryTextField.getText() + "추가");
						
				categoryTextField.setText("");
				
			}	
		});
		
		//카테고리테이블(row) 삭제 기능
		categoryDelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(categoryTable.getSelectedRow() == -1) 
				{
				return;
				}else {
					DefaultTableModel model = (DefaultTableModel)categoryTable.getModel();
					int selectedRow = categoryTable.getSelectedRow();
					String categoryName = categoryTable.getValueAt(selectedRow,0).toString();
					System.out.println(categoryName + "삭제");
					mm.deleteCategoryDetail(categoryName);
					
					
					
					model.removeRow(categoryTable.getSelectedRow());
					
				}
				
				
				}
			});
		
		//카테고리 테이블 클릭시 판매항목 레이블 및 테이블 데이터 변경
		categoryTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
								
				JTable source = (JTable)evt.getSource();
				int row = source.rowAtPoint( evt.getPoint() );
	            int column = source.columnAtPoint( evt.getPoint() );
	            String s=source.getModel().getValueAt(row, column)+"";

	            itemLabel.setText("판매항목"+"("+ s +")");
	    		
	            DefaultTableModel model = (DefaultTableModel)itemTable.getModel();
	    		model.setNumRows(0);
	    		
	            String header[] = {"이 름","가 격","순 서"};
	            menuSize2 = mm.selectMenuListByCategoryName(s).size();   
	            ArrayList<MenuVO> menuList = (ArrayList)mm.selectMenuListByCategoryName(s);
	            
	        	String[][] contents = new String[menuSize2][3];  // 리스트 사이즈를 먼저 선언
	    		for(int i=0; i < menuList.size(); i++) {
	    			contents[i][0] = menuList.get(i).getMenuName();   // i번째 열의 MenuName
	    			contents[i][1] = "" + menuList.get(i).getMenuPrice();  // i번째 열의 MenuPrice
	    			contents[i][2] = "" + menuList.get(i).getSequence(); // i번째 열의 MenuCategory
	    		}
	    		model.setDataVector(contents, header);
	   
	   
	    		
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	   goBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	/*		
				//주문내역 저장
				mm.saveItemDetailList(insertList, deleteList);
				deletelList.removeAll(deleteItemDetailList);
				insertlList.removeAll(insertItemDetailList);
				
	*/
				dispose();
            	pageManager.goMainPage();	
			
			}
			
		});
	   		


	}
	
	@Override
	public void run() {
		Calendar t = Calendar.getInstance();
		int year = t.get(Calendar.YEAR);
		int month = t.get(Calendar.MONTH)+1;
		int date = t.get(Calendar.DATE);
		int amPm = t.get(Calendar.AM_PM);
		int hour = t.get(Calendar.HOUR);
		int min = t.get(Calendar.MINUTE);
		int sec = (t.get(Calendar.SECOND) < 10) ? 0 + t.get(Calendar.SECOND) : t.get(Calendar.SECOND);
		String ampm=amPm==Calendar.AM? "AM":"PM";
		
		while(true) {
					
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

