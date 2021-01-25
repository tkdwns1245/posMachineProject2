package ServiceImpl;

import java.util.List;

import daoImpl.TableDaoImpl;
import data.TableVO;
import service.TableService;

public class TableServiceImpl implements TableService{
	TableDaoImpl tableDao = new TableDaoImpl();
	
	public TableServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<TableVO> selectTableList() {
		// TODO Auto-generated method stub
		return tableDao.selectTableList();
	}
}
