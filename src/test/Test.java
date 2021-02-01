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
		for(FrameTemplate3 FrameTemplate : templateList )
		{
			FrameTemplate.setPageManager(pm);
		}
		pm.setPageManger(templateList);
		
		pm.goStartPage();
//		GoodsManage gm = new GoodsManage();
		System.out.println("Å×½ºÆ®8");
	}
}


