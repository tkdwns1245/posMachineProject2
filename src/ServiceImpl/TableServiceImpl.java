package ServiceImpl;

import java.util.List;

import daoImpl.TableDaoImpl;
import data.TableVO;
import service.TableService;

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
	public int countOfTables() {
		try {
			return tableDao.countOfTables();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
