package posMachineProject.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import database.DatabaseUtil;
import posMachineProejct.manager.PageManager;

public abstract class FrameTemplate extends JFrame{ 
	protected int width=1000;
	protected int height=600;
	protected PageManager pageManager;
	protected int selectedTableNumber;
	public FrameTemplate() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = screen.width / 2-width /2;
		int y =  screen.height / 2 - height/2;
        this.setTitle("SLR의 PosMachine");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(width, height);
		this.setLocation(x,y);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	new DatabaseUtil().close();
		    	System.out.println("프로그램 종료");
		    }
		});

	}  
	public void init() {
		initComponent();
		addGui();
		initEvent();		
//		this.setVisible(true);
	}
	public abstract void initComponent();
	public abstract void addGui();
	public abstract void initEvent();
	public void setPageManager(PageManager pageManager) {
		this.pageManager = pageManager;
	};
	
}
