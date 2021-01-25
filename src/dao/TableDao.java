package dao;

import java.util.List;

import data.TableVO;

public interface TableDao {
	public abstract List<TableVO> selectTableList();
}
