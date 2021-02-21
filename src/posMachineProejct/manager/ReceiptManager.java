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

}

