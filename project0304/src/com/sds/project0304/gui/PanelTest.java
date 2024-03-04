package com.sds.project0304.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;

/*
 * 자바의 컴포넌트 중, Panel은 판자이며 다른 컴포넌트(버튼, Checkbox)는 다르게
 * 배치 능력을 보유하고 있다, 즉 배치관리자(borderlayou, grid, flow...)의 적용이 가능
 * 마치 웹브라우저라는 윈도우를 내부적으로 디자인 영역을 나눌때 쓰는 div와 비슷한 역할을 수행
 * div 와 마찬가지로 투명이다.
 * */

public class PanelTest {
	public static void main(String[] args) {
		Frame frame = new Frame("Panel Study");
		
		frame.setLayout(new FlowLayout()); //디폴트가 보더레이아웃이므로 변경
		
		//div 역할을 수행할 panel을 두개 준비하자
		Panel p1 = new Panel(); //첫번째 div
		Panel p2 = new Panel(); //두번째 div
		/* [panel]
		 * 1) 배치 관리자를 사용할 수 있음
		 * 		만일 개발자가 아무덧도 배치관리자를 적용하면 panel은 default로 Flowlayout이 적용됨
		 * 2) Frame에서 사용한 add()도 사용할 수 있음
		 * 		(Container가 될 수 있다 = parent가 될 수 있다)
		 * */
		p1.setBackground(new Color(255,130,135));
		p2.setBackground(new Color(255,78,87));
		
		p1.setPreferredSize(new Dimension(200, 150)); //크기조정
		p2.setPreferredSize(new Dimension(200, 150)); //크기조정
		
		frame.add(p1);
		frame.add(p2);
		
		frame.setVisible(true);
		frame.setSize(300, 350);
	}
}
