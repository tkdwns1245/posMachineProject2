package posMachineProejct.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import posMachineProject.gui.FrameTemplate;

public class PageManager {
	Map pageMap = new HashMap<String,FrameTemplate>();
	int tableNumber;
	public void setPageList(List<FrameTemplate> frameList){
		for (FrameTemplate frame : frameList)
		{
			pageMap.put(frame.getClass().getName(),frame);
		}
	}
	
	public void goStartPage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("posMachineProject.gui.LoginFrame");
		tmpTemplate.setVisible(true);
	}
	public void goJoinPage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("posMachineProject.gui.JoinFrame");
		tmpTemplate.setVisible(true);
	}
	public void goMainPage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("posMachineProject.gui.MainFrame");
		tmpTemplate.setVisible(true);
	}
	public void goTablePage(int tableNum) {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("posMachineProject.gui.TableFrame");
		this.tableNumber = tableNum;
		tmpTemplate.setVisible(true);
	}
	public void goTableManagePage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("posMachineProject.gui.TableManageFrame");
		tmpTemplate.setVisible(true);
	}
	public void goGoodsManagePage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("posMachineProject.gui.GoodsManageFrame");
		tmpTemplate.setVisible(true);
	}
	public void goSalesStatusPage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("posMachineProject.gui.SalesStatusFrame");
		tmpTemplate.setVisible(true);
	}
	public void goReceiptManagePage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("posMachineProject.gui.ReceiptManageFrame");
		tmpTemplate.setVisible(true);
	}
	public int getTableNumber() {
		return this.tableNumber;
	}
}
