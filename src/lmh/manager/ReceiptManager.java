package lmh.manager;

import java.util.ArrayList;
import java.util.List;

import ServiceImpl.MenuServiceImpl;
import ServiceImpl.ReceiptServiceImpl;
import data.CategoryVO;
import data.MenuVO;
import data.ReceiptJoinedVO;
import data.ReceiptVO;
import data.Receipt_DetailsVO;
import service.MenuService;
import service.ReceiptService;

public class ReceiptManager {
	ReceiptService rs = new ReceiptServiceImpl();	
	
	public List<ReceiptJoinedVO> selecttReceipt(){
		return rs.selectJoinedReceiptTable();

	}
	
	public List<ReceiptJoinedVO> selecttReceipt_Details(){
		return rs.selectJoinedReceiptTable();

	}

}

