package posMachineProject.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import data.CategoryVO;
import data.MenuVO;
import gui.util.CreateComponentUtil;
import posMachineProejct.manager.MenuManager;


public class GoodsManageFrame extends FrameTemplate implements Runnable{
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
	
	public GoodsManageFrame() {
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
		
		//Î¨ºÌíà?ï≠Î™?  ?å®?Ñê
		itemPanel= (JPanel) ccUtil.createJcomponent("p", width*30/100,height*60/100, width*15/100,height*20/100);
		itemTitlePanel =(JPanel)  ccUtil.createJcomponent("p", width*30/100,height*45/1000, 0,0);
		itemDetail=(JPanel) ccUtil.createJcomponent("p", width*30/100,height*955/1000, 0, height*45/1000);
		itemContent=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*200, width/1000*50, height/600*60);
		tableValue=(JPanel) ccUtil.createJcomponent("p", width/1000*205, height/600*575, 0, 0);



		// Ïπ¥ÌÖåÍ≥†Î¶¨ ?å®?Ñê
		categoryTitlePanel =(JPanel) ccUtil.createJcomponent("p",width*30/100,height*45/1000, 0,0);
		categoryPanel=(JPanel) ccUtil.createJcomponent("p",width*30/100,height*60/100, width*55/100,height*20/100);
		categoryDetail=(JPanel) ccUtil.createJcomponent("p",width*30/100,height*955/1000, 0, height*45/1000);
		categoryContent=(JPanel) ccUtil.createJcomponent("p",width/1000*205, height/600*200, width/1000*50, height/600*60);


		//Î¨ºÌíà?ï≠Î™?, Ïπ¥ÌÖåÍ≥†Î¶¨ ?†à?ù¥?îå 
		itemLabel=(JLabel) ccUtil.createJcomponent("l", width*30/100,height*45/1000, 0, 0);
		itemLabel.setText("?åêÎß§Ìï≠Î™?()");
		itemLabel.setFont(new Font("ÎßëÏ?Í≥†Îîï",Font.BOLD, 15));
		
		itemName =(JLabel) ccUtil.createJcomponent("l", width/1000*40, height/600*40, width/1000*15, height/600*10);
		itemName.setText("?ù¥ Î¶?:");
		itemName.setFont(new Font("ÎßëÏ?Í≥†Îîï",Font.BOLD, 12));
		itemPrice=(JLabel) ccUtil.createJcomponent("l", width/1000*40, height/600*40, width/1000*105, height/600*10);
		itemPrice.setText("Í∞? Í≤?:");
		itemCategory=(JLabel) ccUtil.createJcomponent("l", width/1000*40, height/600*40, width/1000*195, height/600*10);
		itemCategory.setText("Ï¢? Î•?:");

		
		categoryLabel=(JLabel) ccUtil.createJcomponent("l",width*30/100,height*45/1000, width*0/100, height*0/100);
		categoryLabel.setText("Ïπ¥ÌÖåÍ≥†Î¶¨");
		categoryLabel.setFont(new Font("ÎßëÏ?Í≥†Îîï",Font.BOLD, 15));
		
		//Î≤ÑÌäº 
		saveButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*120, height/600*280);
		saveButton.setText("?? ?û•");
		itemAddButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*40, height/600*280);
		itemAddButton.setText("Ï∂? Í∞?");
		categoryAddButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*190, height/600*15);
		categoryAddButton.setText("Ï∂? Í∞?");
		itemDelButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*200, height/600*280);
		itemDelButton.setText("?Ç≠ ?†ú");
		categoryDelButton=(JButton) ccUtil.createJcomponent("b",width/15, height/600*30, width/1000*185, height/600*280);
		categoryDelButton.setText("?Ç≠ ?†ú");
				
		//?Öç?ä§?ä∏ ?ïÑ?ìú
	 	itemTextField1=(JTextField) ccUtil.createJcomponent("tf",width/1000*45, height/600*20, width/1000*50, height/600*20);
	 	itemTextField2=(JTextField) ccUtil.createJcomponent("tf",width/1000*45, height/600*20, width/1000*140, height/600*20);
	 	itemTextField3=(JTextField) ccUtil.createJcomponent("tf",width/1000*45, height/600*20, width/1000*230, height/600*20);
	 	
		categoryTextField=(JTextField) ccUtil.createJcomponent("tf", width/1000*120, height/600*20, width/1000*50, height/600*20);
				
	
		
	//itemTable ?Éù?Ñ±
		String header[] = {"?ù¥ Î¶?","Í∞? Í≤?","Ï¢? Î•?"};
		menuSize = mm.selectMenuList().size();   
		ArrayList<MenuVO> menuList= (ArrayList)mm.selectMenuList();
		String[][] contents = new String[menuSize][3];  // Î¶¨Ïä§?ä∏ ?Ç¨?ù¥Ï¶àÎ?? Î®ºÏ? ?Ñ†?ñ∏
		for(int i=0; i < menuList.size(); i++) {
			contents[i][0] = menuList.get(i).getMenuName();   // iÎ≤àÏß∏ ?ó¥?ùò MenuName
			contents[i][1] = "" + menuList.get(i).getMenuPrice();  // iÎ≤àÏß∏ ?ó¥?ùò MenuPrice
			contents[i][2] = menuList.get(i).getMenuCategory(); // iÎ≤àÏß∏ ?ó¥?ùò MenuCategory
		}
		DefaultTableModel model = new DefaultTableModel(contents,header) {
		// ?çîÎ∏îÌÅ¥Î¶??ï¥?Ñú ?àò?†ïÎ∂àÍ?
			public boolean isCellEditable(int i, int c){ 
				return false; 
				}
		};
		itemTable = new JTable(model);
		salesScrollpane = new JScrollPane(itemTable);
		salesScrollpane.setPreferredSize(new Dimension(width/1000*200,height/600*195));
		
		//?Öå?ù¥Î∏?(?ó¥) ?Ç≠?†ú Í∏∞Îä•
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
		
		//CategoryTable ?Éù?Ñ±

		String header2[] = {"Ïπ? ?Öå Í≥? Î¶?"};
		categorySize = mm.selectCategoryList().size();   
		ArrayList<CategoryVO> categoryList = (ArrayList)mm.selectCategoryList();
		String[][] contents2 = new String[categorySize][1];
		for(int j=0; j < categoryList.size(); j++) {
			contents2[j][0] = categoryList.get(j).getCategoryName();

		}
		DefaultTableModel model2 = new DefaultTableModel(contents2,header2){
		// ?çîÎ∏îÌÅ¥Î¶??ï¥?Ñú ?àò?†ïÎ∂àÍ?
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
		
		// Î¨ºÌíà?ï≠Î™? ?å®?Ñê
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


		
		// Ïπ¥ÌÖåÍ≥†Î¶¨ ?å®?Ñê		
		
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

//		?òÑ?û¨ ?Öç?ä§?ä∏ ?ïÑ?ìú?óê ?ûà?äî Í∞íÏùÑ Í∞ÅÍ∞Å?ùò Î≥??àò?óê ???ûÖ 
		String num = tfNum.getText(); // Î≤àÌò∏
		String name = tfName.getText(); // ?ù¥Î¶?
		String address = tfAddress.getText(); // Ï£ºÏÜå

//		Í∞ÅÍ∞Å?ùò Î≥??àò?óê ???û•?êú Í∞íÏùÑ ?ç∞?ù¥?Ñ∞Î≤†Ïù¥?ä§?óê Insert?ïò?äî Î©îÏÜå?ìú

		insert(num, name, address);

//		?ã†Í∑? ???û•?êú ?ç∞?ù¥?Ñ∞Î•? ?ç∞?ù¥?Ñ∞Î≤†Ïù¥?ä§?óê?Ñú ?ã§?ãú ?ùΩ?ñ¥???Ñú result Î≤°ÌÑ∞?óê ???û• 

		Vector result = selectAll();

//		Î≥?Í≤ΩÎêú ?ç∞?ù¥?Ñ∞(Î≤°ÌÑ∞)Î°? Î™®Îç∏ Í∞±Ïã† -> ?Öå?ù¥Î∏? ?ëú?ãú Í∞±Ïã†?ê® 

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
