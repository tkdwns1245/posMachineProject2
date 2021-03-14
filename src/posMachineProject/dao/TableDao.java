package posMachineProject.dao;

import java.util.List;

import data.OrderDetailVO;
import data.TableOrderDetailVO;
import data.TableVO;

public interface TableDao {
	public abstract List<TableVO> selectTableList() throws Exception;
	public abstract int countOfTables() throws Exception;
	public abstract List<TableOrderDetailVO> selectTableOrderDetail(int tableNum) throws Exception;
	public abstract void updateOrderDetailList(List<OrderDetailVO> orderDetailList) throws Exception;
	public abstract void deleteOrderDetailList(List<OrderDetailVO> orderDetailList) throws Exception;
	public abstract void insertOrderDetailList(List<OrderDetailVO> orderDetailList) throws Exception;
	public abstract List<String> selectTableStatusList() throws Exception;
	public abstract void insertTable(int tableNum) throws Exception;
	public abstract void settingTable(int tableNum) throws Exception;
	public abstract void unSettingTable(int tableNum) throws Exception;
	public abstract void deleteTable(int tableNum) throws Exception;
	public abstract void moveTable(int from, int to) throws Exception;
	public abstract int selectOrderNum(int tableNum) throws Exception;
}
