package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.TableDao;
import data.CountVO;
import data.TableVO;
import database.DatabaseUtil;
import database.VOFactory;

public class TableDaoImpl implements TableDao{
	
	final VOFactory voFactory = new VOFactory();
	@Override
	public List<TableVO> selectTableList() throws Exception {
		StringBuffer sql=new StringBuffer();
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
					TableVO tmpTableVO = new TableVO();
					voFactory.setTableVO(tmpTableVO,rs);
					tableList.add(tmpTableVO);
				}
				
			}
		}.execute();
		return tableList;
	}
	
	@Override
	public int countOfTables() throws Exception {
		StringBuffer sql=new StringBuffer();
		CountVO tmpCount = new CountVO();
		sql.append("SELECT COUNT(*) ");
		sql.append("FROM posmachine.TABLE ");
		
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					tmpCount.setCount(rs.getInt(1));
				}
				
			}
		}.execute();
		return tmpCount.getCount();
	}

}
