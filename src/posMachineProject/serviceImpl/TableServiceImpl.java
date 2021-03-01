package posMachineProject.serviceImpl;

import java.util.List;

import data.OrderDetailVO;
import data.TableOrderDetailVO;
import data.TableVO;
import posMachineProject.daoImpl.TableDaoImpl;
import posMachineProject.service.TableService;

public class TableServiceImpl implements TableService{
	TableDaoImpl tableDao = new TableDaoImpl();
	
	public TableServiceImpl() {
	}
	
	@Override
	public List<TableVO> selectTableList() {
		try {
			return tableDao.selectTableList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<TableOrderDetailVO> selectTableOrderDetail(int tableNum) {
		try {
			return tableDao.selectTableOrderDetail(tableNum);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int countOfTables() {
		try {
			return tableDao.countOfTables();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public void saveOrderDetailList(List<OrderDetailVO> updateList, List<OrderDetailVO> deleteList,List<OrderDetailVO> insertList) {
		try {
			tableDao.deleteOrderDetailList(deleteList);
			tableDao.updateOrderDetailList(updateList);
			tableDao.insertOrderDetailList(insertList);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteTable(int tableNum) {
		try {
			tableDao.deleteTable(tableNum);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void insertTable(int tableNum) {
		try {
			tableDao.insertTable(tableNum);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void moveTable(int from, int to) {
		try {
			tableDao.moveTable(from,to);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<String> selectTableStatusList(){
		try {
			return tableDao.selectTableStatusList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void settingTable(int tableNum){
		try {
			tableDao.settingTable(tableNum);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void unSettingTable(int tableNum){
		try {
			tableDao.unSettingTable(tableNum);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
