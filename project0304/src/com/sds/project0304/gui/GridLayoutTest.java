package com.sds.project0304.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

/*
 * 자바의 매치 방법 중 GridLayout을 알아보자
 * Grid = 격자 (행, 열)로 컴포넌트를 배치하는 방법을 제공함
 * */

public class GridLayoutTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		GridLayout grid = new GridLayout(3, 2);  //3층 2호수
		
		frame.setLayout(grid); //원하는 배치관리객체 윈도우에 부착
		//바로 이 시점 부터는 Frame의 디폴트 배치관리자인 BorderLayout이 적용되는게 아니라,
		//GridLayout으로 적용됨
		
		Button[] btn = new Button[6];
		
		for(int i=0; i<btn.length; i++) {
			btn[i] = new Button(i+"'st button");
			frame.add(btn[i]);// 윈도우에 버튼 부착
		}
		
		frame.setSize(300,200);
		frame.setVisible(true);
	}

}
