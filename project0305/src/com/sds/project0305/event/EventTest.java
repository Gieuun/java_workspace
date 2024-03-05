package com.sds.project0305.event;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;

public class EventTest extends Frame {
								/* is a */
	// has a 관계란, 멤버변수가 객체자료형일때를 의미
	// 어떤 사물이 사물을 부품으로 보유하는 관계
	
	//멤버변ㄴ수들은 개발자가 초기화하지 않으면 컴파일러에 의해 디폴트값이 들어감
	//객체자료형 -null int-0 boolean-false 문자-공백
	Button btn; // EvnetTest has a btn
	
	TextField t;
	Choice ch; // html에서의 select 박스 

	public EventTest() {
		btn = new Button("click me");
		t= new TextField(20); //주의 20 자만 허용하는 것이 아니라, 20자 크기를 확보하고 탄생
		ch = new Choice();
		//초이스 아이템들을 넣어보기 html의 select option과 동일
		ch.addItem("appel");
		ch.addItem("banana");
		ch.addItem("grape");
		ch.addItem("lemon");
		
		//프레임에 부착
		this.setLayout(new FlowLayout());
		
		add(btn); //프레임에 버튼 부착
		add(t);	//프레임에 텍스트박스 부착
		add(ch); //프레임에 섹렉트박스 부착
		//버튼에 리스너 연결(js와 상당히 흡사)
		myActionListener my = new myActionListener();
		btn.addActionListener(my); //리스너 객체의 인스턴스가 매개변수로 전달되어야 한다
		
		//텍스트 필드에 키보드 이벤트 리스너 연결
		t.addKeyListener(new MYkeyLIstener());
		
		//초이스에 아이템 변경 리스너 연결
		ch.addItemListener(new MyItmeListener());
		
		//현재 프레임에 윈도우 리스너 연결
		this.addWindowListener(new MyWindowListener());
		
		setBackground(Color.DARK_GRAY);
		setSize(300,400); //윈도우창 크기 지정
		setVisible(true); //위도우창 보이게 처림
	}
	
	public static void main(String[] args) {
		 //객체 생성후 할일이 없다면, 굳이 변수를 사용할 이유가 없기 때문에 생성만 처리
		new EventTest();

	}

}
