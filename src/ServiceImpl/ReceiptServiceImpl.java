package ServiceImpl;

import java.util.List;
import daoImpl.MenuDaoImpl;
import daoImpl.ReceiptDaoimpl;
import data.CategoryVO;
import data.MenuVO;
import data.ReceiptJoinedVO;
import service.MenuService;
import service.ReceiptService;

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