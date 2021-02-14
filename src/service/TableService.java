package service;

import java.util.List;

import data.TableOrderDetailVO;
import data.TableVO;

public interface TableService {
	public abstract List<TableVO> selectTableList();
	public abstract int countOfTables();
	public abstract List<TableOrderDetailVO> selectTableOrderDetail(int tableNum);
}
