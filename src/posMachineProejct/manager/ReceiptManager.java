package posMachineProejct.manager;

import java.util.List;


import data.ReceiptJoinedVO;

import posMachineProject.service.ReceiptService;
import posMachineProject.serviceImpl.ReceiptServiceImpl;

public class ReceiptManager {
	ReceiptService rs = new ReceiptServiceImpl();	
	
	public List<ReceiptJoinedVO> selecttReceipt(){
		return rs.selectJoinedReceiptTable();

	}
	
	public List<ReceiptJoinedVO> selecttReceipt_Details(){
		return rs.selectJoinedReceiptTable();

	}
	
	public Object[][] CreateReceiptJtableContents(int year,int month, int day){
		return rs.CreateReceiptJtableContents(year, month, day);
	}
	
	public Object[][] CreateReceiptDetailJtableContents(int rcNumber){
		return rs.CreateReceiptDetailJtableContents(rcNumber);
	}
	public void returnThisSale(int rcNumber) {
		rs.returnThisSale(rcNumber);
	}

}

