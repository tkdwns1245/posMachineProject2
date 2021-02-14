package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.TableDao;
import data.CountVO;
import data.TableOrderDetailVO;
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
	
	@Override
	public List<TableOrderDetailVO> selectTableOrderDetail(int tableNum) throws Exception {
		StringBuffer sql=new StringBuffer();
		List<TableOrderDetailVO> tableOrderDetailVoList = new ArrayList<TableOrderDetailVO>();
		
		sql.append("SELECT t.num AS tableNum, ");
		sql.append("o.num AS orderNum, o.status, ");
		sql.append("od.num AS orderDetailNum, od.num_of, ");
		sql.append("m.num AS menuNum, m.menu_name, m.menu_price ");
		
		sql.append("FROM posmachine.TABLE t ");
		sql.append("LEFT JOIN posmachine.ORDER o ON t.num = o.table_num ");
		sql.append("LEFT JOIN posmachine.ORDER_DETAIL od ON o.num = od.order_num ");
		sql.append("LEFT JOIN posmachine.MENU m ON od.menu_num = m.num ");
		
		sql.append("WHERE t.num = ? ");
		System.out.println(sql);
		new DatabaseUtil() {
			TableOrderDetailVO tmpTableOrderDetailVo;
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setInt(1,tableNum);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					tmpTableOrderDetailVo = new TableOrderDetailVO();
					voFactory.setTableOrderDetailVO(tmpTableOrderDetailVo,rs);
					tableOrderDetailVoList.add(tmpTableOrderDetailVo);
				}
				
			}
		}.execute();
		System.out.println(tableOrderDetailVoList);
		return tableOrderDetailVoList;
	}
}
