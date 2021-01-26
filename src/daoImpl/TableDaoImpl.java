package daoImpl;

import java.util.List;

import dao.TableDao;
import data.TableVO;

public class TableDaoImpl implements TableDao{
	
	//싱글톤패턴으로 구현해주세요
	DatabaseModule dbModule = DatabaseModule.getInstance();
	public TableDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * dbModule에 query변수를 입력하면 데이터를불러오는 getData() 메소드를 구현해주세요
	 * 이때 불러온 데이터는 return 타입과 같아야합니다.
	*/
	@Override
	public List<TableVO> selectTableList() {
		String query="SELECT * FROM TABLE";
		return dbModule.getData(query);
	}
}
