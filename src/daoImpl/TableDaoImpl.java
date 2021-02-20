package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.TableDao;
import data.CountVO;
import data.OrderDetailVO;
import data.TableOrderDetailVO;
import data.TableVO;
import database.DatabaseUtil;
import database.VOFactory;
import userTable.AbstractDAO;

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
		sql.append("LEFT JOIN posmachine.MENU m ON od.menu_name = m.menu_name ");
		
		sql.append("WHERE t.num = ? ORDER BY od.num ASC ");
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
		return tableOrderDetailVoList;
	}
	@Override
	public void deleteOrderDetailList(List<OrderDetailVO> orderDetailList) throws Exception {
		
		List<OrderDetailVO> OrderDetailList = orderDetailList;
		for(OrderDetailVO od : OrderDetailList)
		{
			StringBuffer sql=new StringBuffer();
			sql.append("DELETE FROM ");
			sql.append("posmachine.ORDER_DETAIL ");
			sql.append("WHERE menu_name=? AND order_num=?");
			new DatabaseUtil() {
				@Override
				public void query() throws Exception {
					// TODO Auto-generated method stub
					pstmt=con.prepareStatement(sql.toString());
					pstmt.setString(1, od.getMenuName());
					pstmt.setInt(2, od.getOrderNum());
					pstmt.executeUpdate();	
				}
			}.execute();
		}
	}
	@Override
	public void updateOrderDetailList(List<OrderDetailVO> orderDetailList) throws Exception {
		List<OrderDetailVO> OrderDetailList = orderDetailList;
		for(OrderDetailVO od : OrderDetailList)
		{
			StringBuffer sql=new StringBuffer();
			sql.append("UPDATE posmachine.ORDER_DETAIL SET ");
			sql.append("num_of=? ");
			sql.append("WHERE order_num=? AND menu_name=?");
			new DatabaseUtil() {
				@Override
				public void query() throws Exception {
					// TODO Auto-generated method stub
					pstmt=con.prepareStatement(sql.toString());
					pstmt.setInt(1, od.getNumOf());
					pstmt.setInt(2, od.getOrderNum());
					pstmt.setString(3, od.getMenuName());
					pstmt.executeUpdate();					
				}
			}.execute();
		}
	}
	@Override
	public void insertOrderDetailList(List<OrderDetailVO> orderDetailList) throws Exception {
		List<OrderDetailVO> OrderDetailList = orderDetailList;
		for(OrderDetailVO od : OrderDetailList)
		{
			StringBuffer sql=new StringBuffer();
			sql.append("INSERT INTO posmachine.ORDER_DETAIL");
			sql.append("(order_num,num_of,menu_name) ");
			sql.append("VALUES (?,?,?)");
			new DatabaseUtil() {
				@Override
				public void query() throws Exception {
					// TODO Auto-generated method stub
					pstmt=con.prepareStatement(sql.toString());
					pstmt.setInt(1, od.getOrderNum());
					pstmt.setInt(2, od.getNumOf());
					pstmt.setString(3, od.getMenuName());
					pstmt.executeUpdate();					
				}
			}.execute();
		}
	}
}
