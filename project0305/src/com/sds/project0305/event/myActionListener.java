package com.sds.project0305.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 사용자들이 GUI 프로그램에서 이벤트를 일으키면 1차적으로는 OS가 감지하여
 * 해당정보를 프로그램에 전달해준다
 * java의 경우 jvm이 이벤트 정보를 전달 받고, 이벤트 객체로 재해석하여
 * 정보를 담고있는 이벤트 객체의 인스턴스를 생성한다
 * ex) 클릭 이벤트 정보를 os로부터 전달 받으면 jvm은 click 대신 'action' 이라는 용어를 사용하므로
 * ActionEvent 객체를 메모리에 생성하게 되고, 이 객체는 개발자에게 전달 되어야 개발자가 원하는
 *처리를 할 수 있으므로 action을 감지하는 Listner객체가 감지 하게된다.
 *이 리스너를 사용하기위해서는 인터페이스로 되어 있으므르, 자식 객체를 재정의 하여 자식을 new하여 
 *메모리에 올린다
 * */

// 인터페이스는 몸체 없는 메서드 만을 보유하므로, 추상적이다.
public class myActionListener implements ActionListener{
	
	//이 메서드는 사용자에 의해 액션이벤트가 발생할때마다, 호출되어진다.
	//이때 jvm이 생성한 이벤트 정보 객체인 ActionEvnet 인스턴스가 아래의 매개변수인 e 변수로
	//대입 되고, 개발자는 더 많은 이벤트 정보를 보고싶다면 매개변수 e를 사용하면된다.
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		
	}
}
