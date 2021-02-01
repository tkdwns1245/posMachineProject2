package ssz.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ssz.gui.FrameTemplate3;

public class PageManager {
	Map pageMap = new HashMap<String,FrameTemplate3>();
	
	public void setPageManger(List<FrameTemplate3> frameList){
		for (FrameTemplate3 frame : frameList)
		{
			pageMap.put(frame.getClass().getName(),frame);
		}
	}
	
	public void goStartPage() {
		FrameTemplate3 tmpTemplate = (FrameTemplate3)pageMap.get("ssz.gui.LoginFrame3");
		tmpTemplate.setVisible(true);
	}
	public void goMainPage() {
		FrameTemplate3 tmpTemplate = (FrameTemplate3)pageMap.get("ssz.gui.MainFrame");
		tmpTemplate.setVisible(true);
	}
}
