package posMachineProject.daoImpl;

import java.util.ArrayList;
import java.util.List;

import data.ReceiptJoinedVO;
import database.DatabaseUtil;
import database.VOFactory;
import posMachineProject.dao.ReceiptDao;

public class ReceiptDaoimpl implements ReceiptDao{
	
	
	int Total,rowCount;
	StringBuffer sql;
	VOFactory vofactory = new VOFactory();
	
	
	public List<ReceiptJoinedVO> selectJoinedReceiptTable() {
		
		try 
		{ 
			
			List<ReceiptJoinedVO> ReceiptList=new ArrayList<ReceiptJoinedVO>();
			sql=new StringBuffer();

			sql.append("SELECT RECEIPT.rcNumber,sumPrice,payType,regTime,status,menu_Category,menu_Name,menu_Price,numberOf,rowSum,rowCount ");
			sql.append("FROM posmachine.RECEIPT_DETAILS ");
			sql.append("JOIN posmachine.RECEIPT ON posmachine.RECEIPT.rcNumber=posmachine.RECEIPT_DETAILS.rcNumber");		
			
			new DatabaseUtil() {
				@Override
				public void query() throws Exception {
					// TODO Auto-generated method stub
					pstmt=con.prepareStatement(sql.toString());
					rs=pstmt.executeQuery();
					while(rs.next()) {
						
						ReceiptJoinedVO rjVO=new ReceiptJoinedVO();
						ReceiptList.add(vofactory.setReceiptJoinedVO(rjVO,rs));
						
					}
					
				}
			}.execute();
		
			return ReceiptList;

		} 
		
		catch (Exception e) 
		{ 

			System.out.println(e+"Á¢¼Ó ½ÇÆÐ"); 

			System.out.println(e+"���� ����"); 

		}
		return null;
		
	}
	
	
	public int getRowCount()
	{
		
		sql=new StringBuffer();
		sql.append("SELECT MAX(rowCount) AS alias ");
		sql.append("FROM posmachine.RECEIPT_DETAILS ");
		
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				rs=pstmt.executeQuery();
				rs.next();
				rowCount=rs.getInt(1);
			}
		}.execute();
		return rowCount;

	}
		
	

}



