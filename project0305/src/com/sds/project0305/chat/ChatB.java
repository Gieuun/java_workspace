package com.sds.project0305.chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.Keylistener;

public class ChatB extends Frame implements Keylistener {

	TextArea area; //html에서의 textarea와 동일
	Panel p_south;
	TextField t;
	ChatA chatA; //ChatA를 제어하기 위해, 주소를 보유하자 현재는 null

	public ChatB(ChatA chatA) {
		area= new TextArea();
		p_south=new Panel();
		t= new TextField(15);
		this.chatA= chatA; //매개변수로 넘겨받은 ChatA의 주소값을 멤버변수로 보관하자
		//,그래야 ChatA를 제어할 수 있다
		
		//스타일 적용
		area.setBackground(Color.yellow);
		
		//조립
		add(area); //보더레이아웃.센터 부착
		p_south.add(t); //판자에 텍스트필드
		
		add(p_south, BorderLayout.SOUTH); //Panel을 South에 부착
		
		//텍스트 필드와 리스너 연결
		t.addKeylistener(this);
		
		setSize(300, 400);
		setVisible(true);
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			//B의 area에 체팅로그 추가
			String str=this.t.getText();
			this.area.append(str+"\n");
			
			//chatA의 area에 체팅로그 추가
			chatA.area.append(str+"\n");
			
			//로그를 남긴 후에는 입력했던 텍스트를 다시 초기화
			t.setText("");
		}
		
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
}
