package com.sds.project0305.event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//사용자가 프렝미창을 대상으로 각종 이벤트를 일으키면 발생하는 이벤트는 WindowEvent이고
//이 WindowEvent를 실시간으로 청취하는 리스너가 바로 WindowListner이다
//인터페이스이므로, 재정의 하자
public class MyWindowListener implements WindowListener {
	//윈도우창이 사용중일때, 포커스가 현재 창에 올라올때 
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
		
	}
	//closing 보다 나중시점
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
		
	}
	
	//윈도우 닫기 버튼 누를때
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
 		System.exit(0); //프로세스(=현재 실행중인 프로그램) 종류
		
	}
	
	//포커스에서 벗어날 때
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
		
	}
	
	//최소화된 창이 다시 복귀될 때
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
		
	}
	
	//위도우 창이 최소화 됏을때
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
		
	}
	
	//윈도우 생성 될때
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
		
	}
}
