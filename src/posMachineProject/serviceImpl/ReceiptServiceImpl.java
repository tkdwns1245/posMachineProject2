package posMachineProject.serviceImpl;

import java.util.List;

import data.ReceiptJoinedVO;
import posMachineProject.daoImpl.ReceiptDaoimpl;
import posMachineProject.service.ReceiptService;

public class ReceiptServiceImpl implements ReceiptService{
	ReceiptDaoimpl ReceiptDao = new ReceiptDaoimpl();
	
	public ReceiptServiceImpl() { 
	}

	@Override
	public List<ReceiptJoinedVO> selectJoinedReceiptTable() {
		try {
			return ReceiptDao.selectJoinedReceiptTable();
		}catch(Exception e) {
				e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}



}