package ssz.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ssz.manager.PageManager;

public abstract class FrameTemplate3 extends JFrame { 
	protected int width=1000;
	protected int height=600;
	protected PageManager pageManager;
	public FrameTemplate3() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = screen.width / 2-width /2;
		int y =  screen.height / 2 - height/2;
        this.setTitle("SLR�� PosMachine");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(width, height);
		this.setLocation(x,y);
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
