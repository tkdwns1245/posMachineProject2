package posMachineProject.service;

import java.util.List;

import data.CategoryVO;
import data.MenuVO;
import data.ReceiptJoinedVO;

public interface ReceiptService {
 
	public abstract List<ReceiptJoinedVO> selectJoinedReceiptTable();
	public Object[][] CreateReceiptDetailJtableContents(int rcNumber);
	public Object[][] CreateReceiptJtableContents(int year,int month,int day);
	public void returnThisSale(int rcNumber);
	public int getRowCount();
	public void insertReceiptAndReceiptDetail(Object[][] payItems,String payType,int totalPrice);
}
