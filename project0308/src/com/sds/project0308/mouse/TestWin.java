package com.sds.project0308.mouse;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestWin extends JFrame {
	JButton bt;
	
	public TestWin() {
		bt = new JButton("click");
		
		setLayout(new FlowLayout());
		
		add(bt);
		//버튼과 리스너 연결
		//클리이라는 행위를 .java 까지 만들어가면서 구현을 할 필요가 있는가?
		//이벤트 구현시 .java 까지 만들지 않고, 내부익명클래스로 많이 구현함
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked?");
			}
		});
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TestWin();

	}

}
