package com.sds.project0305.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

public class Website extends Frame{
							/* is a */
	/*윈도우가 버튼들을 가지고 있다(has a) 멤버 변수
	 * Frame has a Button
	 * */
	Button[] bt= new Button[4]; // 버튼 4개를 담을 수 있는 '공간'
	String[] naviTitle = {"introduce","product","brand","contact"};
	Label subNavi;
	Panel content;
	Label copyright;
	Panel p_North; // 버튼들을 Flowlayout에 올릴 페널
	
	//has a 관계에 있는 사물들은 Website 객체가 탄생할 때 함께 탄생해야 할
	//부품들이다 -> 생성자의 기회를 놓치지 말자
	public Website() {
		p_North = new Panel();
		
		//jdk 5 버전부터 improved loop지원
		//부품으로 보유한 객체들을 메모리에 적용하기
		for(int i=0; i<bt.length; i++) {
			bt[i]= new Button(naviTitle[i]); //버튼 부품 생성
			
			//생성되는 버튼들을 페널에 부착
			//패널은 배치 능력이 있는 컴포넌트이고, default가 flowlayout이다
			p_North.add(bt[i]);
		}
		subNavi = new Label("apple banana strawberry pine");
		content = new Panel();
		copyright = new Label("copyright all reserved");
		
		//style 적용
		subNavi.setBackground(Color.yellow);//좌측 라벨에 배경색 적용
		subNavi.setPreferredSize(new Dimension(80, 300));
		
		content.setBackground(Color.green);//우측 라벨에 배경색 적용
		
		copyright.setBackground(Color.CYAN);
		copyright.setPreferredSize(new Dimension(500,100));
		
		
		//부모 container인 frame에 부착
		/*생성자도 멤버메서드 이므로, 멤버메서드 영역에서는 인스턴스가 
		자기 자신을 가리킬때, this 레퍼런스 변수를 사용할 수 있으며,
		이때 this 조차 생략이 가능(객체가 객체 본인을 지칭 하기때문)
		레이이웃을 명시 하지 않으면 프레임은 보더레이아웃을 디폴트로 갖는다*/
		add(p_North, BorderLayout.NORTH);
		add(content); //방위를 명시하지 않으면 디폴트는 CENTER
		add(copyright, BorderLayout.SOUTH);
		add(subNavi, BorderLayout.WEST);
		
		//프레임은 기본적으로 눈에 보이지 않고, 크기도 없어서 지정
		setVisible(true);
		setSize(500,400);
	}
	
	public static void main(String[] args) {
		Website w = new Website();
		
	}

}
