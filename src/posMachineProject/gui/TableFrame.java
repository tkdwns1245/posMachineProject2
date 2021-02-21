package posMachineProject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.CategoryVO;
import data.MenuVO;
import data.OrderDetailVO;
import data.TableOrderDetailVO;
import gui.util.CreateComponentUtil;
import posMachineProejct.manager.MenuManager;
import posMachineProejct.manager.TableManager;

public class TableFrame extends FrameTemplate{
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	TableManager tm = new TableManager();
	MenuManager mm = new MenuManager();
	Font plainFont = new Font("",Font.PLAIN,10);
	BorderLayout mainLayout = new BorderLayout();
	BorderLayout middleLeftBorderLayout = new BorderLayout();
	BorderLayout middleRightBorderLayout = new BorderLayout();
	FlowLayout middleLayout = new FlowLayout();
	FlowLayout mrTopFlowLayout = new FlowLayout(FlowLayout.LEFT,10,10);
	FlowLayout mrMiddleFlowLayout = new FlowLayout(FlowLayout.LEFT);
	
	JPanel mainPanel;
	
	JPanel topPanel;
	JPanel middlePanel;
	JPanel bottomPanel;
	
	JPanel mLeftPanel;
	JPanel mRightPanel;
	
	JPanel mlTopPanel;
	JPanel mlMiddlePanel;
	JPanel mlBottomPanel;
	
	JPanel mrTopPanel;
	JPanel mrMiddlePanel;
	
	JPanel timePanel;
	
	JLabel dayLabel;
	JLabel timeLabel;
	JLabel tableLabel;
	JLabel idLabel;
	JLabel mlTitleLabel;
	
	JScrollPane salesScrollpane;
	JScrollPane goodsScrollpane;
	JTable salesTable;
	JTable goodsTable;
	
	JButton gobackButton;
	JButton cancelButton;
	JButton payButton;
	JButton addButton;
	JButton logoutButton;
	List<JButton> categoryButtonList;
	List<OrderDetailVO> updateOrderDetailList = new ArrayList<OrderDetailVO>();
	List<OrderDetailVO> deleteOrderDetailList = new ArrayList<OrderDetailVO>();
	List<OrderDetailVO> insertOrderDetailList = new ArrayList<OrderDetailVO>();
	int selectedTableNum;
	int selectedSalesTableRow;
	int selectedGoodsTableRow;
	int orderNum;
	public TableFrame() {
		super.init();
	}
	@Override
	public void initComponent() {
		//mainPanel 초기화
		mainPanel= new JPanel();
		mainPanel.setLayout(mainLayout);
		mainPanel.setBackground(new Color(155,155,155));
		
		//Util에  default로 세팅해야 하는함
		ccUtil.setMainPanel(mainPanel);
		
		//topPanel 초기화
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
		topPanel.setBackground(Color.BLUE);
		logoutButton = new JButton("로그아웃");
		gobackButton = new JButton("나가기");
		//time패널 초기화
		timePanel = new JPanel();
		
		//label초기화
		dayLabel = new JLabel("2021/01/01");
		timeLabel = new JLabel("PM 04:09");
		tableLabel = new JLabel("table ");
		tableLabel.setBorder(BorderFactory.createEmptyBorder(0, 200,0, 200));
		idLabel = new JLabel("아이디");
		
		//middlePanel초기화
		middlePanel = new JPanel();
		middleLayout.setAlignment(FlowLayout.CENTER);
		middleLayout.setHgap(50);
		middlePanel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
		middlePanel.setLayout(middleLayout);
		
		//mLeftPanel 초기화
		mLeftPanel = new JPanel();
		mLeftPanel.setPreferredSize(new Dimension(350,400));
		mLeftPanel.setBackground(Color.GRAY);
		mLeftPanel.setLayout(middleLeftBorderLayout);
		mlTopPanel = new JPanel();
		mlMiddlePanel = new JPanel();
		mlBottomPanel = new JPanel();
		mlTopPanel.setBackground(Color.BLUE);
		mlMiddlePanel.setBackground(Color.WHITE);
		mlBottomPanel.setBackground(Color.RED);
		mlTitleLabel = new JLabel("구매목록");
		
		String header[] = {"이름","가격","개수","금액"};
		String contents[][] = 
		{
			{"항목1","3000","1","3000"},
			{"항목2","4000","3","12000"},
			{"항목3","5000","2","10000"},
			{"항목4","3000","4","12000"}
		};
		DefaultTableModel model = new DefaultTableModel(contents,header) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		salesTable = new JTable(model);
		salesScrollpane = new JScrollPane(salesTable);
		salesScrollpane.setPreferredSize(new Dimension(350,370));
		cancelButton = new JButton("삭제");
		payButton = new JButton("계산");
		
		//mRightPanel 초기화
		mRightPanel = new JPanel();
		mRightPanel.setPreferredSize(new Dimension(350,400));
		mRightPanel.setLayout(middleRightBorderLayout);
		mRightPanel.setBackground(Color.GRAY);
		mrTopPanel = new JPanel();
		mrMiddlePanel = new JPanel();
		
		mrTopPanel.setPreferredSize(new Dimension(350,100));
		mrTopPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		mrTopPanel.setBackground(Color.BLUE);
		mrTopPanel.setLayout(mrTopFlowLayout);
		mrMiddlePanel.setBackground(Color.WHITE);
		mrMiddlePanel.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
		mrMiddlePanel.setLayout(mrMiddleFlowLayout);

		categoryButtonList = new ArrayList<JButton>();
		
		for(int i =0; i < 6; i++)
		{
			JButton tmpButton = new JButton("category" + (i+1));
			tmpButton.setPreferredSize(new Dimension(70, 30));
			categoryButtonList.add(tmpButton);
		}
		
		String header2[] = {"이름","가격"};
		String contents2[][] = 
		{
		};
		DefaultTableModel model2 = new DefaultTableModel(contents2,header2) {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		goodsTable = new JTable(model2);
		goodsScrollpane = new JScrollPane(goodsTable);
		goodsScrollpane.setPreferredSize(new Dimension(280,280));
		addButton = new JButton("추가");
		//bottomPanel 초기화
		bottomPanel = new JPanel();
		
	}
	@Override
	public void addGui() {
		this.add(mainPanel);
		
		timePanel.add(dayLabel);
		timePanel.add(timeLabel);
		topPanel.add(timePanel);
		topPanel.add(tableLabel);
		topPanel.add(idLabel);
		topPanel.add(logoutButton);		
		topPanel.add(gobackButton);
		mlTopPanel.add(mlTitleLabel);
		mlMiddlePanel.add(salesScrollpane);
		mlBottomPanel.add(cancelButton);
		mlBottomPanel.add(payButton);
		
		mLeftPanel.add(mlTopPanel, BorderLayout.NORTH);
		mLeftPanel.add(mlMiddlePanel, BorderLayout.CENTER);
		mLeftPanel.add(mlBottomPanel, BorderLayout.SOUTH);
		
		mrMiddlePanel.add(addButton);
		mrMiddlePanel.add(goodsScrollpane);
		
		mRightPanel.add(mrTopPanel,BorderLayout.NORTH);
		mRightPanel.add(mrMiddlePanel,BorderLayout.CENTER);
		
		middlePanel.add(mLeftPanel);
		middlePanel.add(mRightPanel);
		
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
	}
	@Override
	public void initEvent() {
		salesTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedSalesTableRow = salesTable.getSelectedRow();
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
		goodsTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedGoodsTableRow = goodsTable.getSelectedRow();
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
		addButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedSalesRowNum = 0;
				boolean isSelectedSalesRow = true;
				String selectedMenuName = ""+goodsTable.getModel().getValueAt(selectedGoodsTableRow,0);
				String selectedMenuPrice = ""+goodsTable.getModel().getValueAt(selectedGoodsTableRow,1);
				DefaultTableModel tmpSalesModel = (DefaultTableModel) salesTable.getModel();
				
				//check is selected Goods in salesTable
				for(int i = 0 ; i < tmpSalesModel.getRowCount(); i++)
				{
					String menuName = ""+tmpSalesModel.getValueAt(i,0);
					if(menuName.equals(selectedMenuName))
					{
						selectedSalesRowNum = i;
						isSelectedSalesRow = true;
						break;
					}else if(i == tmpSalesModel.getRowCount()-1)
					{
						isSelectedSalesRow = false;
					}
					
				}
				//when is selected goods in salesTable
				if(isSelectedSalesRow)
				{
					int selectedMenuIndexOf;
					int selectedMenuNumOf;
					//update updateOrderDetailList or insertOrderDetailList
					if(searchOrderDetailListIndex(insertOrderDetailList,selectedMenuName) != -1)
					{
						selectedMenuIndexOf = searchOrderDetailListIndex(insertOrderDetailList,selectedMenuName);
						selectedMenuNumOf = Integer.parseInt(""+salesTable.getModel().getValueAt(selectedSalesRowNum,2));
						OrderDetailVO tmpOrderDetail = insertOrderDetailList.get(selectedMenuIndexOf);
						tmpOrderDetail.setNumOf(selectedMenuNumOf + 1);
						tmpOrderDetail.setOrderNum(orderNum);
						
						insertOrderDetailList.set(selectedMenuIndexOf,tmpOrderDetail);
					}else
					{
						selectedMenuIndexOf = searchOrderDetailListIndex(updateOrderDetailList,selectedMenuName);
						selectedMenuNumOf = Integer.parseInt(""+salesTable.getModel().getValueAt(selectedSalesRowNum,2));
						OrderDetailVO tmpOrderDetail = updateOrderDetailList.get(selectedMenuIndexOf);
						tmpOrderDetail.setNumOf(selectedMenuNumOf + 1);
						tmpOrderDetail.setOrderNum(orderNum);
						//update updateOrderDetailList or insertOrderDetailList
						updateOrderDetailList.set(selectedMenuIndexOf,tmpOrderDetail);
					}
					//update saletable
					DefaultTableModel updateTableModel = (DefaultTableModel) salesTable.getModel();
					updateTableModel.setValueAt("" + (selectedMenuNumOf + 1), selectedSalesRowNum, 2);
					updateTableModel.fireTableDataChanged();
					salesTable.setModel(updateTableModel);
					
					
				//when is not goods in salesTable
				}else
				{
					int deleteMenuIndexOf = searchOrderDetailListIndex(deleteOrderDetailList,selectedMenuName);
					OrderDetailVO tmpOrderDetail = new OrderDetailVO();
					tmpOrderDetail.setMenuName(selectedMenuName);
					tmpOrderDetail.setNumOf(0);
					tmpOrderDetail.setOrderNum(orderNum);
					insertOrderDetailList.add(tmpOrderDetail);
					DefaultTableModel updateTableModel = (DefaultTableModel) salesTable.getModel();
					updateTableModel.addRow(new String[]{selectedMenuName,selectedMenuPrice,"1",selectedMenuPrice});
				
					
				}
				salesTable.repaint(); 
			}
			
		});
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedSalesRowNum = 0;
				boolean isSelectedSalesRow = true;
				String selectedMenuName = ""+salesTable.getModel().getValueAt(selectedSalesTableRow,0);
				int selectedMenuNumOf = Integer.parseInt(""+salesTable.getModel().getValueAt(selectedSalesTableRow,2));
				
				//check is selected Goods in salesTable
				for(int i = 0 ; i < salesTable.getModel().getRowCount(); i++)
				{
					String menuName = ""+salesTable.getModel().getValueAt(i,0);
					if(menuName.equals(selectedMenuName))
					{
						selectedSalesRowNum = i;
						isSelectedSalesRow = true;
						break;
					}else if(i == salesTable.getModel().getRowCount()-1)
					{
						isSelectedSalesRow = false;
					}
					
				}
				
				if(isSelectedSalesRow)
				{
					if(selectedMenuNumOf > 1)
					{
						int selectedMenuIndexOf;
						OrderDetailVO tmpOrderDetail;
						//update updateOrderDetailList or insertOrderDetailList
						if(searchOrderDetailListIndex(insertOrderDetailList,selectedMenuName) != -1)
						{
							selectedMenuIndexOf = searchOrderDetailListIndex(insertOrderDetailList,selectedMenuName);
							tmpOrderDetail = insertOrderDetailList.get(selectedMenuIndexOf);
							tmpOrderDetail.setNumOf(selectedMenuNumOf - 1);
							tmpOrderDetail.setOrderNum(orderNum);
							insertOrderDetailList.set(selectedMenuIndexOf,tmpOrderDetail);
						}else
						{
							selectedMenuIndexOf = searchOrderDetailListIndex(updateOrderDetailList,selectedMenuName);
							tmpOrderDetail = updateOrderDetailList.get(selectedMenuIndexOf);
							tmpOrderDetail.setNumOf(selectedMenuNumOf - 1);
							tmpOrderDetail.setOrderNum(orderNum);
							updateOrderDetailList.set(selectedMenuIndexOf, tmpOrderDetail);
						}
						DefaultTableModel updateTableModel = (DefaultTableModel) salesTable.getModel();
						
						//update salesTable
						updateTableModel.setValueAt("" + (selectedMenuNumOf - 1), selectedSalesRowNum, 2);
						salesTable.setModel(updateTableModel);
					}
					else
					{
						int selectedMenuIndexOf;
						
						//remove item in updateOrderDetailList
						if(searchOrderDetailListIndex(insertOrderDetailList,selectedMenuName) != -1)
						{
							selectedMenuIndexOf = searchOrderDetailListIndex(insertOrderDetailList,selectedMenuName);
							insertOrderDetailList.remove(selectedMenuIndexOf);
						}else
						{
							selectedMenuIndexOf = searchOrderDetailListIndex(updateOrderDetailList,selectedMenuName);
							updateOrderDetailList.remove(selectedMenuIndexOf);
						}
						DefaultTableModel updateTableModel = (DefaultTableModel) salesTable.getModel();
						
						//add item in deleteOrderDetailList
						OrderDetailVO tmpOrderDetail = new OrderDetailVO();
						tmpOrderDetail.setMenuName(selectedMenuName);
						tmpOrderDetail.setOrderNum(orderNum);
						tmpOrderDetail.setNumOf(0);
						deleteOrderDetailList.add(tmpOrderDetail);
						
						//remove item salesTable
						updateTableModel.removeRow(selectedSalesRowNum);
						salesTable.setModel(updateTableModel);
					}
				}
				salesTable.repaint(); 
			}
		});
		
		gobackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//주문내역 저장
				tm.saveOrderDetailList(updateOrderDetailList, deleteOrderDetailList,insertOrderDetailList);
				updateOrderDetailList.removeAll(updateOrderDetailList);
				deleteOrderDetailList.removeAll(deleteOrderDetailList);
				insertOrderDetailList.removeAll(insertOrderDetailList);
				dispose();
            	pageManager.goMainPage();	
			}
		});
		this.addComponentListener(new ComponentListener() {
			public void componentShown(ComponentEvent e) {
				tableLabel.setText("table " + pageManager.getTableNumber());
				List<TableOrderDetailVO> tableOrderDetailList = new ArrayList<TableOrderDetailVO>();
				//////////////salesTablePaint/////////////
				//select tableOrderDetailList
				tableOrderDetailList = tm.selectTableOrderDetail(pageManager.getTableNumber());
				int tableOrderSize = tableOrderDetailList.size();
				
				//set contents from tableOrderDetailList
				String[][] contents = new String[tableOrderSize][4];
				String header[] = {"이름","가격","개수","금액"};
				for(int i = 0; i < tableOrderSize; i ++)
				{
					String menuName = tableOrderDetailList.get(i).getMenuName();
					int menuPrice = tableOrderDetailList.get(i).getMenuPrice();
					int numOf = tableOrderDetailList.get(i).getNumOf();
					int sumOfPrice = menuPrice * numOf;
					orderNum = tableOrderDetailList.get(i).getOrderNum();
					
					//set updateOrderDetailMap
					OrderDetailVO tmpOrderDetail = new OrderDetailVO();
					tmpOrderDetail.setMenuName(menuName);
					tmpOrderDetail.setNumOf(numOf);
					tmpOrderDetail.setOrderNum(orderNum);
					updateOrderDetailList.add(tmpOrderDetail);
					contents[i][0] = menuName;
					contents[i][1] = "" + menuPrice;
					contents[i][2] = "" + numOf;
					contents[i][3] = "" + sumOfPrice; 
				}
				DefaultTableModel model = new DefaultTableModel(contents,header) {
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				};
				salesTable.setModel(model);
				
				////////////// setting categoryButtonList and repaint mrTopPanel /////////////
				categoryButtonList.removeAll(categoryButtonList);
				List<CategoryVO> categoryList = mm.selectCategoryList();
				
				//setting categoryButtonList
				for(int i =0; i < categoryList.size(); i++)
				{
					CategoryVO tmpCategoryVO = categoryList.get(i);
					JButton tmpButton = new JButton(tmpCategoryVO.getCategoryName());
					tmpButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							List<MenuVO> menuList = mm.selectMenuListByCategoryName(tmpCategoryVO.getCategoryName());
							int menuListSize = menuList.size();
							
							//set contents from tableOrderDetailList
							String[][] contents = new String[menuListSize][4];
							String header[] = {"이름","가격"};
							//
							for(int i = 0; i < menuListSize; i ++)
							{
								String menuName = menuList.get(i).getMenuName();
								int menuPrice = menuList.get(i).getMenuPrice();
								contents[i][0] = menuName;
								contents[i][1] = "" + menuPrice;
							}
							DefaultTableModel model = new DefaultTableModel(contents,header) {
								@Override
							    public boolean isCellEditable(int row, int column) {
							       //all cells false
							       return false;
							    }
							};
							goodsTable.setModel(model);
						}
					});
					tmpButton.setPreferredSize(new Dimension(70, 30));
					categoryButtonList.add(tmpButton);
				}
				//remove all components in mrTopPanel
				mrTopPanel.removeAll();
				
				//repaint mrTopPanel
				for(int j = 0 ; j < categoryButtonList.size(); j++)
				{
					mrTopPanel.add(categoryButtonList.get(j));
				}
	        }public void componentHidden(ComponentEvent e) {

	        }

	        public void componentMoved(ComponentEvent e) {

	        }

	        public void componentResized(ComponentEvent e) {

	        }
        });
	}
	public int searchOrderDetailListIndex(List<OrderDetailVO> orderDetailList, String menuName) {
		int searchNum = 0;
		for(OrderDetailVO tmpOrderDetailVO : orderDetailList)
		{
			if(menuName.equals(tmpOrderDetailVO.getMenuName()))
				return searchNum;
			else
				searchNum++;
		}
		return -1;
	}
}
