package service;

import java.util.List;

import data.TableVO;

public interface TableService {
	public abstract List<TableVO> selectTableList();
}
