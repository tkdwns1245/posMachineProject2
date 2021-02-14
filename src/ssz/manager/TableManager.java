package ssz.manager;

import java.util.List;

import ServiceImpl.TableServiceImpl;
import data.TableOrderDetailVO;
import data.TableVO;
import service.TableService;

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
	
}
