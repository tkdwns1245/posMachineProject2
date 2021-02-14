package dao;

import java.util.List;

import data.TableOrderDetailVO;
import data.TableVO;

public interface TableDao {
	public abstract List<TableVO> selectTableList() throws Exception;
	public abstract int countOfTables() throws Exception;
	public abstract List<TableOrderDetailVO> selectTableOrderDetail(int tableNum) throws Exception;
}
