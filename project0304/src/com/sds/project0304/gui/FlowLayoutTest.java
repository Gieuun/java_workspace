package com.sds.project0304.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

/*
 * 자바의 컴포넌트 배치 방법중 FlowLayout을 학습한다
 * FlowLayout: 수직 수평 방향으로 컴포넌트들을 흐르도록하는 배칭방법
*/

public class FlowLayoutTest {

	public static void main(String[] args) {
		Frame frame = new Frame();
		
		Button[] btn = new Button[20];
		
		//부착하기 전에 FlowLayout을 적용하지 않으면 디폴트 BorderLayout이 적용됨
		FlowLayout flow = new FlowLayout();
		
		frame.setLayout(flow); // 이 시점 부턴 윈도우에 컴포넌트를 부착할때,
		//수직 수평으로 흐르면서 부착됨
		for(int i =0; i<btn.length; i++) {
			frame.add(btn[i]=new Button(i+"btn"));
		}
		
		frame.setSize(300,400);
		frame.setVisible(true);
	}
}
