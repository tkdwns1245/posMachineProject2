package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.TableDao;
import data.TableVO;
import database.DatabaseUtil;
import database.VOFactory;
import userTable.UserVO;

public class TableDaoImpl implements TableDao{
	
	final StringBuffer sql=new StringBuffer();
	final UserVO uservo=new UserVO();
	final VOFactory voFactory = new VOFactory();
	@Override
	public List<TableVO> selectTableList() throws Exception {
		List<TableVO> tableList = new ArrayList<TableVO>();
		sql.append("SELECT * ");
		sql.append("FROM posmachine.TABLE ");
		
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					tableList.add((TableVO)voFactory.createVO("table",rs));
				}
				
			}
		}.execute();
		return tableList;
	}	

}
