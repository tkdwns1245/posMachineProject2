package posMachineProject.service;

import java.util.List;

import data.CategoryVO;
import data.MenuVO;
import data.ReceiptJoinedVO;

public interface ReceiptService {
 
	public abstract List<ReceiptJoinedVO> selectJoinedReceiptTable();
	public int getRowCount();
}
