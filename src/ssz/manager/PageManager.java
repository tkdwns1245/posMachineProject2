package ssz.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ssz.gui.FrameTemplate3;

public class PageManager {
	Map pageMap = new HashMap<String,FrameTemplate3>();
	int tableNumber;
	public void setPageList(List<FrameTemplate3> frameList){
		for (FrameTemplate3 frame : frameList)
		{
			pageMap.put(frame.getClass().getName(),frame);
		}
	}
	
	public void goStartPage() {
		FrameTemplate3 tmpTemplate = (FrameTemplate3)pageMap.get("ssz.gui.LoginFrame3");
		tmpTemplate.setVisible(true);
	}
	public void goJoinPage() {
		FrameTemplate3 tmpTemplate = (FrameTemplate3)pageMap.get("ssz.gui.JoinFrame");
		tmpTemplate.setVisible(true);
	}
	public void goMainPage() {
		FrameTemplate3 tmpTemplate = (FrameTemplate3)pageMap.get("ssz.gui.MainFrame");
		tmpTemplate.setVisible(true);
	}
	public void goTablePage(int tableNum) {
		FrameTemplate3 tmpTemplate = (FrameTemplate3)pageMap.get("ssz.gui.TableFrame");
		this.tableNumber = tableNum;
		tmpTemplate.setVisible(true);
	}
	public void goTableManagePage() {
		FrameTemplate3 tmpTemplate = (FrameTemplate3)pageMap.get("lmh.gui.TableManage");
		tmpTemplate.setVisible(true);
	}
	public void goGoodsManagePage() {
		FrameTemplate3 tmpTemplate = (FrameTemplate3)pageMap.get("lmh.gui.TableManage");
		tmpTemplate.setVisible(true);
	}
	public void goSalesStatusPage() {
		FrameTemplate3 tmpTemplate = (FrameTemplate3)pageMap.get("kukirun.gui.Sales_Status");
		tmpTemplate.setVisible(true);
	}
	public int getTableNumber() {
		return this.tableNumber;
	}
}
