package com.sds.project0304.gui;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;

/*너비 500 높이 600인 위도우창을 생성해보자
 * java의 GUI객체 들이 모여있는 패키지는 java.awt 패키지이다.
 * */

public class WinTest {
	public static void main(String[] args) {
		/* java gui에서는 위도우 객체는 최상위 객체이므로, 직접 사용하지 않고
		 * 그 하위 객체임 Frame 객체를 사용함*/
		Frame frame=null; //객체의 인스턴스가 존재 하지 않는 상채
		/*
		 sun 또는 남이 제공해준 클래스를 사용하는 방법
		 api를 빨리 보는 방법
		 
		 1) 현재 클래스의 사용목적을 알아야 함, 즉 뭐하는 클래스인지?
		 e.x) Frame 은? 윈도우를 표현한 클래스
		 2) 사용해보기 
		 	- 사용한다는 것은 메모리에 올려야 하는 것이고, 자바에서는 객체를 메모리에 올릴때
		 	3가지 유형에 따라 올리는 방법이 틀리므로, 객체의 유형을 조사
		 	a) 일반 클래스 - new 연산자 직접 올릴 수 있다
		 	b)추상클래스 - new 연산자로 직접 올릴 수 없다
		 						(1) 자식 클래스를 정의 하여 자식을 new
		 						(2) sun 에서 별돌로 제공해준 방법이 있을 경우 그 방법 대로
			c)인터페이스 - new 연산자로 직접 올릴 수 없다
		 						(1) 자식 클래스를 정의 하여 자식을 new
		 						(2) sun 에서 별돌로 제공해준 방법이 있을 경우 그 방법 대로
		 */
		//프레임을 메모리에 올려보자
		frame = new Frame(); //일반 클래스 이므로 new로 올릴 수 있다.
		frame.setVisible(true);
		//setSize() 메서드를 이용하여 너비, 높이 지정
		frame.setSize(500, 600);
		
		//이 프레임 위에, 각종 UI 컴포넌트(버튼, 텍스트박스)들을 올려보자
		Button bt = new Button("나 버튼"); //처음 보는 클래스를 메모리에 올리자
		
		//위도우창에 버튼 부착
		//버튼이 위도우 창 크기 만큼 붙는 이유는? 모든 GUI 프로그램에서는
		//컨테이너인 부모에 자식요소를 붙일때는 반드시
		// 어떤 방식으로 붙일지 즉 배치방법인 레이아웃이 결정되어야 한다.
		//만일 개발자가 레이아웃 방식을 아무것도 지정하지 않으면 디폴트로 적용되는 배치방법이 있는데
		//현재 BorderLayour이라는 배치 방법이 적용되어, 윈도우 크기 만큼 지정됨
		frame.setLayout(new FlowLayout());
		
		//html에서  텍스트박스는 Java에서 TextField라 함
		TextField t1 = new TextField(15);
		
		//html에서 셀렉트박스는 choice라 함
		Choice ch = new Choice();
		ch.add("java");
		ch.add("Oracle");
		ch.add("jsp");
		ch.add("spring");
		
		//html에서의 checkbox는 java에서도 checkbox라 함
		Checkbox box = new Checkbox("여행");
		
		frame.add(bt); //버튼을 윈도우에 부착
		frame.add(t1); //텍스트 필드를 윈도우에 부착 
		frame.add(ch); //초이스 박스를 윈도우에 부착 
		frame.add(box); //채크 박스를 윈도우에 부착 
		
	}
}
