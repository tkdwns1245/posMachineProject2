package posMachineProject.service;

import java.util.List;

import data.OrderDetailVO;
import data.TableOrderDetailVO;
import data.TableVO;

public interface TableService {
	public abstract List<TableVO> selectTableList();
	public abstract int countOfTables();
	public abstract List<TableOrderDetailVO> selectTableOrderDetail(int tableNum);
	public abstract void saveOrderDetailList(List<OrderDetailVO> updateList,List<OrderDetailVO> deleteList,List<OrderDetailVO> insertList);
	public abstract void insertTable(int tableNum);
	public abstract void deleteTable(int tableNum);
	public abstract void moveTable(int from, int to);
	public abstract List<String> selectTableStatusList();
	public abstract void settingTable(int tableNum);
	public abstract void unSettingTable(int tableNum);
}
