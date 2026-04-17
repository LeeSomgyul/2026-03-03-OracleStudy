package com.sist.board;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class BoardMain extends JFrame{
	
	private CardLayout card = new CardLayout();
	BoardList bList = new BoardList();
	
	public BoardMain() {
		setLayout(card);
		add("bList", bList);
		setSize(640, 550);
		bList.print();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		
		new BoardMain();

	}



}
