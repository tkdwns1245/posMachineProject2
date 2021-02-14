package lmh.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lmh.gui.FrameTemplate;

public class PageManager {
	Map pageMap = new HashMap<String,FrameTemplate>();
	
	public void setPageManger(List<FrameTemplate> frameList){
		for (FrameTemplate frame : frameList)
		{
			pageMap.put(frame.getClass().getName(),frame);
		}
	}
	
	public void goGoodsManagePage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("lmh.gui.GoodsManage");
		tmpTemplate.setVisible(true);
		tmpTemplate.run();
	}
	
	public void goReceiptManagePage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("lmh.gui.ReceiptManage");
		tmpTemplate.setVisible(true);
		tmpTemplate.run();

	}
	
	public void goTableManagePage() {
		FrameTemplate tmpTemplate = (FrameTemplate)pageMap.get("lmh.gui.tableManage");
		tmpTemplate.setVisible(true);
		tmpTemplate.run();
	}
}


