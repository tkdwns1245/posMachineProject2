package posMachineProject.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.util.CreateComponentUtil;
import posMachineProejct.manager.UserManager;

public class JoinFrame extends FrameTemplate{
	UserManager um = new UserManager();
	CreateComponentUtil ccUtil = new CreateComponentUtil();
	Font plainFont = new Font("",Font.PLAIN,10);
	JPanel mainPanel;

	JPanel titlePanel;
	JPanel joinPanel;
	JPanel bottomPanel;
	
	JLabel titleLabel;
	JLabel idLabel;
	JLabel passwordLabel;
	
	JButton okButton;
	JButton cancelButton;
	
	JTextField idTextField;
	JTextField passwordTextField;
	
	public JoinFrame() {
		init();
	}
	@Override
	public void initComponent() {
		mainPanel = new JPanel();
		//Utilï¿½ï¿½  defaultï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ø¾ï¿½ ï¿½Ï´ï¿½ï¿½ï¿½
		ccUtil.setMainPanel(mainPanel);
		joinPanel= (JPanel)ccUtil.createJcomponent("p",width*3/10,height/4, width*35/100,height*225/1000);
		titlePanel= (JPanel)ccUtil.createJcomponent("p",width*4/10,height*50/600, width*3/10,height/20);
		
		titleLabel= (JLabel)ccUtil.createJcomponent("l",width*3/10, height/6, width*4/10, height/60*5);
		titleLabel.setText("·Î±×ÀÎ");
		titleLabel.setFont(plainFont);
		
		idLabel= (JLabel)ccUtil.createJcomponent("l",width/10, height/30, width*60/1000, height*30/600);
		idLabel.setText("¾ÆÀÌµð : ");
		idLabel.setFont(plainFont);
		
		passwordLabel= (JLabel)ccUtil.createJcomponent("l",width/10, height/30, width*60/1000, height*70/600);
		passwordLabel.setText("ÆÐ½º¿öµå : ");
		passwordLabel.setFont(plainFont);
		
		idTextField= (JTextField)ccUtil.createJcomponent("tf",width/1000*100, height/600*20, width/1000*150, height/600*30);
		idTextField.setColumns(10);
		
		passwordTextField= (JTextField)ccUtil.createJcomponent("tf",width/1000*100, height/600*20, width/1000*150, height/600*70);
		passwordTextField.setColumns(10);
		
		okButton= (JButton)ccUtil.createJcomponent("b",width/1000*90, height/600*30, width/1000*40, height/600*110);	
		okButton.setText("È¸¿ø°¡ÀÔ");
		okButton.setFont(plainFont);
		
		cancelButton= (JButton)ccUtil.createJcomponent("b",width/1000*90, height/600*30, width/1000*150, height/600*110);
		cancelButton.setText("Ãë¼Ò");
		cancelButton.setFont(plainFont);
		
	}
	@Override
	public void addGui() {
		this.add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(155,155,155));
		mainPanel.add(joinPanel);
		mainPanel.add(titlePanel);
		
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setBackground(new Color(100,100,100));
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(new Font("·Î±×ÀÎ",Font.BOLD, 20));
		titlePanel.add(titleLabel);
				
		joinPanel.setLayout(null);
		idLabel.setFont(new Font("¾ÆÀÌµð",Font.PLAIN,13));
		passwordLabel.setFont(new Font("ÆÐ½º¿öµå",Font.PLAIN,13));
		joinPanel.add(idLabel);
		joinPanel.add(passwordLabel);
		
		joinPanel.add(idTextField);
		joinPanel.add(passwordTextField);
		joinPanel.add(okButton);
		joinPanel.add(cancelButton);	

		
		
	}
	@Override
	public void initEvent() {
		okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int joinCheck = 2;
            	joinCheck = um.joinUser(idTextField.getText(),passwordTextField.getText());
                if(joinCheck == 1)
                {
                	JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔ¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
                	dispose();
                	pageManager.goStartPage();
                }else if(joinCheck == 0) {
                	 JOptionPane.showMessageDialog(null, "È¸¿ø°¡ÀÔ¿¡ ¼º°øÇÏ¿´½À´Ï´Ù.");
                	 idTextField.setText("");
                	 passwordTextField.setText("");
                }
            }
        });
		cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	pageManager.goStartPage();
            }
        });
	}
	
}
