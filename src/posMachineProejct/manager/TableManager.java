package posMachineProejct.manager;

import java.util.List;

import data.OrderDetailVO;
import data.TableOrderDetailVO;
import data.TableVO;
import posMachineProject.service.TableService;
import posMachineProject.serviceImpl.TableServiceImpl;

public class TableManager {
	TableService tableService = new TableServiceImpl();
	
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
	
}
