package test;

import java.util.ArrayList;
import java.util.List;

import data.MenuVO;
import database.DatabaseUtil;
import posMachineProejct.manager.PageManager;
import posMachineProject.gui.FrameTemplate;
import posMachineProject.gui.GoodsManageFrame;
import posMachineProject.gui.JoinFrame;
import posMachineProject.gui.LoginFrame;
import posMachineProject.gui.MainFrame;
import posMachineProject.gui.ReceiptManageFrame;
import posMachineProject.gui.SalesStatusFrame;
import posMachineProject.gui.TableFrame;
import posMachineProject.gui.TableManageFrame;

public class Test {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		DatabaseUtil.init();
		PageManager pm = new PageManager();
//		TableDaoImpl tdi = new TableDaoImpl();
		List<FrameTemplate> templateList = new ArrayList<FrameTemplate>();
		System.out.println("페이지 로딩중...");
		templateList.add(new GoodsManageFrame());
		templateList.add(new ReceiptManageFrame());
		templateList.add(new SalesStatusFrame());
		templateList.add(new TableManageFrame());
		templateList.add(new LoginFrame());
		templateList.add(new JoinFrame());
		templateList.add(new MainFrame());
		templateList.add(new TableFrame());
		
		//각 프레임에 PageManager등록
		for(FrameTemplate FrameTemplate : templateList )
		{
			FrameTemplate.setPageManager(pm);
		}
		pm.setPageList(templateList);
		System.out.println("페이지 로딩완료");
		pm.goStartPage();
	}
}


