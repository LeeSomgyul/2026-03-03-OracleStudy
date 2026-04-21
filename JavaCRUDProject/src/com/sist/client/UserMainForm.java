package com.sist.client;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserMainForm extends JFrame implements ActionListener{
	
	MenuPenal mp = new MenuPenal();
	ControllerPenal cp;
	
	public UserMainForm() {
		cp=new ControllerPenal(this);
		setLayout(null);
		mp.setBounds(150, 15, 860, 35);
		add(mp);
		cp.setBounds(20, 60, 980, 670);
		add(cp);
		setSize(1024, 768);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mp.b1.addActionListener(this);
		mp.b5.addActionListener(this);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}

		new UserMainForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == mp.b5) {
			cp.card.show(cp, "BLIST");
		}else if(e.getSource() == mp.b1) {
			cp.card.show(cp, "HOME");
		}
		
	}

}
