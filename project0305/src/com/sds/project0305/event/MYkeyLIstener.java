package com.sds.project0305.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MYkeyLIstener implements KeyListener{

	//키보드 누를때 호출되는 메서드
	public void keyPressed(KeyEvent e) {
		
		
	}
	
	//키보드 눌렀다 뗄때 호출되는 메서드
	public void keyReleased(KeyEvent e) {
		//System.out.println(e);
		if(e.getKeyCode()==10) {
			System.out.println("엔터");
		}
		
	}
	
	//타이핑할때
	public void keyTyped(KeyEvent e) {

	}
}
