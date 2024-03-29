package com.sds.project0304.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

/*
자바의 UI 컴포넌트들을 화면 어디에 올려 놓을지를 결정하려면 배치에 대해 학습해야한 
java.awt 배치는 LayoutManager라 불리는 객체들로 지원됨

[배치의 유형]
	1) BorderLayout : 동서남북의 망위를 갖는 방식의 배치
	2) GridLayout : 행과 열을 갖는 격자 방식의 배치
	3) FlowLayout : 수평 및 수직의 방향으로 요소들을 흐르게 배치하는 방식
	4) CardLayout : 여러장의 장면 중 누구를 보여줄지를 결정하는 배치방식, 오직 하나씩 보여줌
						  카드 놀이에서 카드와 동일
    5) GridBag : GridLayout을 좀 더 세분화하여 배치하는 방식
 */
public class LayoutTest {
		public static final int Width=600;
		public static final int Height=500;
		
	public static void main(String[] args) {
		Frame frame = new Frame(); //윈도우  생성
		frame.setVisible(true); //윈도우의 가려짐 속성을 보이도록 바꿈
		frame.setSize(Width,Height);//윈도우 너비와 높이
		
		//버튼을 5개 준비하영 각각 BorderLayout에 원하는 방위에 부착해보자
		BorderLayout borderLayout = new BorderLayout() ;
		frame.setLayout(borderLayout); //개발자가 원하는 레이아웃 객체
		
		Button[] btn = new Button[5]; //자바에서 객체자료형도 자료형이므로, 버튼형 배열로 표현가능
		//배열만 생성했을 뿐, ㅇㅏ직 버튼이 생성된 것은 아니다
		btn[0]= new Button("North");
		btn[1]= new Button("East");
		btn[2]= new Button("South");
		btn[3]= new Button("West");
		btn[4]= new Button("Center");
		
		//북쪽 영역에 컴포넌트 넣기
		//상수 - public static final
		//frame.add(btn[0], BorderLayout.NORTH);
		//frame.add(btn[2], BorderLayout.SOUTH);
		//frame.add(btn[1], BorderLayout.EAST);
		//frame.add(btn[3], BorderLayout.WEST);
		//frame.add(btn[4], BorderLayout.CENTER);
		
		//만일 Frame에 개발자가 아무런 배치관리자를 적용하지 않으면, 디폴트는 BorderLayout이 적용된다
		//아까 이전 예제에서 우리가 아무런 배치를 적용하지 않았기 때문에
	}

}
