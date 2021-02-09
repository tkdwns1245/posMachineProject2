package service;

import java.util.List;

import data.TableVO;

public interface TableService {
	public abstract List<TableVO> selectTableList();
	public abstract int countOfTables();
}
