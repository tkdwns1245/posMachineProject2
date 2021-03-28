package posMachineProejct.manager;

import java.util.List;

import data.OrderDetailVO;
import data.TableOrderDetailVO;
import data.TableVO;
import posMachineProject.service.ReceiptService;
import posMachineProject.service.TableService;
import posMachineProject.serviceImpl.ReceiptServiceImpl;
import posMachineProject.serviceImpl.TableServiceImpl;

public class TableManager {
	TableService tableService = new TableServiceImpl();
	ReceiptService receiptService = new ReceiptServiceImpl();
	public TableManager() {
		// TODO Auto-generated constructor stub
	}
	public List<TableVO> selectTableList() {
		return tableService.selectTableList();
	}
	public List<TableOrderDetailVO> selectTableOrderDetail(int tableNum){
		return tableService.selectTableOrderDetail(tableNum);
	}
	public int countOfTables() {
		return tableService.countOfTables();
	}
	public void saveOrderDetailList(List<OrderDetailVO> updateList, List<OrderDetailVO> deleteList, List<OrderDetailVO> insertList) {
		try {
			tableService.saveOrderDetailList(updateList, deleteList, insertList);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void insertTable(int tableNum) {
		tableService.insertTable(tableNum);
	}
	public void deleteTable(int deleteNum) {
		tableService.deleteTable(deleteNum);
	}
	public void moveTable(int from, int to) {
		tableService.moveTable(from, to);
	}
	public List<String> selectTableStatusList(){
		return tableService.selectTableStatusList();
	}
	public void settingTable(int tableNum) {
		tableService.settingTable(tableNum);
	}
	public void unSettingTable(int tableNum) {
		tableService.unSettingTable(tableNum);
	}
	public int selectOrderNum(int tableNum) {
		return tableService.selectOrderNum(tableNum);
	}
	public void payTable(int tableNum,Object[][] payItems,String payType,int totalPrice) {
		tableService.unSettingTable(tableNum);
		receiptService.insertReceiptAndReceiptDetail(payItems,payType,totalPrice);
	}
	
}
