package daoImpl;

import java.util.List;

import dao.TableDao;
import data.TableVO;

public class TableDaoImpl implements TableDao{
	
	//�̱����������� �������ּ���
	DatabaseModule dbModule = DatabaseModule.getInstance();
	public TableDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * dbModule�� query������ �Է��ϸ� �����͸��ҷ����� getData() �޼ҵ带 �������ּ���
	 * �̶� �ҷ��� �����ʹ� return Ÿ�԰� ���ƾ��մϴ�.
	*/
	@Override
	public List<TableVO> selectTableList() {
		String query="SELECT * FROM TABLE";
		return dbModule.getData(query);
	}
}
