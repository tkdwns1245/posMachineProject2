package posMachineProject.dao;

import java.sql.ResultSet;
import java.util.List;

import data.ReceiptJoinedVO;

public interface ReceiptDao {

	
	public List<ReceiptJoinedVO> selectJoinedReceiptTable();
	public void insertReceiptAndReceiptDetail(Object[][] payItems,String payType,int totalPrice);
	public void returnThisSale(int rcNumber);
	public int getRowCount();
}
