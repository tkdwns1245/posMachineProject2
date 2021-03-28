package posMachineProject.daoImpl;

import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import data.ReceiptJoinedVO;
import data.ReceiptVO;
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


	@Override
	public void returnThisSale(int rcNumber) {
		// TODO Auto-generated method stub
		sql=new StringBuffer();
		sql.append("UPDATE posmachine.RECEIPT ");
		sql.append("SET status='return' ");
		sql.append("WHERE rcNumber= ? ");
		
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setInt(1, rcNumber);
				pstmt.executeUpdate();
				
			}
		}.execute();
		
		
	}
	
	@Override
	public void insertReceiptAndReceiptDetail(Object[][] payItems,String payType, int totalPrice) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		StringBuffer sql=new StringBuffer();
		sql.append("INSERT INTO posmachine.RECEIPT");
		sql.append("(sumPrice,payType,regTime,status)");
		sql.append("VALUES (?,?,?,?)");
		
		StringBuffer sql2=new StringBuffer();
		sql2.append("INSERT INTO posmachine.RECEIPT_DETAILS");
		sql2.append("(rcNumber,menu_Name,menu_Price,numberOf,rowSum)");
		sql2.append("VALUES (?,?,?,?,?)");
		
		ReceiptVO receiptVO = new ReceiptVO();;
		new DatabaseUtil() {
			@Override
			public void query() throws Exception {
				// TODO Auto-generated method stub
				pstmt=con.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, totalPrice);
				pstmt.setString(2, payType);
				pstmt.setTimestamp(3, timestamp);
				pstmt.setString(4, "normal");
				pstmt.executeUpdate();			
				
				rs = pstmt.getGeneratedKeys();
				rs.next();
				vofactory.setReceiptId(receiptVO,rs);
			}
			
		}.execute();
		
		for(int i= 0; i <payItems.length; i++)
		{
			int j = i;
			new DatabaseUtil() {
				@Override
				public void query() throws Exception {
					// TODO Auto-generated method stub
					pstmt=con.prepareStatement(sql2.toString());
					pstmt.setInt(1, receiptVO.getRcNumber());
					pstmt.setString(2, payItems[j][0].toString());
					pstmt.setInt(3,Integer.parseInt(payItems[j][1].toString()));
					pstmt.setInt(4,Integer.parseInt(payItems[j][2].toString()));
					pstmt.setInt(5,Integer.parseInt(payItems[j][3].toString()));
					pstmt.executeUpdate();
				}
			}.execute();
		}
	}

}



