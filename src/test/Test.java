package test;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import ssz.gui.FrameTemplate3;
import ssz.gui.JoinFrame;
import ssz.gui.LoginFrame3;
import ssz.gui.MainFrame;
import ssz.manager.PageManager;

public class Test {
	public static void main(String[] args) {
		PageManager pm = new PageManager();
		
		List<FrameTemplate3> templateList = new ArrayList<FrameTemplate3>();
		templateList.add(new LoginFrame3());
		templateList.add(new JoinFrame());
		templateList.add(new MainFrame());
		
		//각 프레임에 PageManager등록
		for(FrameTemplate3 FrameTemplate : templateList )
		{
			FrameTemplate.setPageManager(pm);
		}
		pm.setPageList(templateList);
		
		pm.goStartPage();
		System.out.println("테스트8");
	}
}


