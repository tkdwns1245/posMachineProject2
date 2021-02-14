package lmh.manager;

import java.util.List;

import ServiceImpl.ReceiptServiceImpl;
import data.ReceiptJoinedVO;
import lmh.serviceimpl.LmhServiceImpl;
import service.ReceiptService;

public class ReceiptManager {
	ReceiptService rs = new ReceiptServiceImpl();	
	LmhServiceImpl lmhrs=new LmhServiceImpl();
	
	public List<ReceiptJoinedVO> selecttReceipt(){
		return rs.selectJoinedReceiptTable();

	}
	
	public List<ReceiptJoinedVO> selecttReceipt_Details(){
		return rs.selectJoinedReceiptTable();

	}
	
	public Object[][] CreateReceiptJtableContents(int year,int month, int day){
		return lmhrs.CreateReceiptJtableContents(year, month, day);
	}
	
	public Object[][] CreateReceiptDetailJtableContents(int rcNumber){
		return lmhrs.CreateReceiptDetailJtableContents(rcNumber);
	}

}

