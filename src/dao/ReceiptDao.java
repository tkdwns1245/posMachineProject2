package dao;

import java.sql.ResultSet;
import java.util.List;

import data.ReceiptJoinedVO;

public interface ReceiptDao {

	
	public List<ReceiptJoinedVO> selectJoinedReceiptTable();
	public void returnThisSale(int rcNumber);
	public int getRowCount();
}
