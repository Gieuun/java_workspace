package com.sds.project0305.chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.Actionlistener;
import java.awt.event.KeyEvent;
import java.awt.event.Keylistener;

public class ChatA extends Frame implements Actionlistener, Keylistener {

	TextArea area; //html에서의 textarea와 동일
	Panel p_south;
	TextField t;
	Button bt;
    ChatB chatB;
    
	public ChatA() {
		area= new TextArea();
		p_south=new Panel();
		t= new TextField(15);
		bt = new Button("open");
		
		
		//스타일 적용
		area.setBackground(Color.yellow);
		
		//조립
		add(area); //보더레이아웃.센터 부착
		p_south.add(t); //판자에 텍스트필드
		p_south.add(bt); //버튼 부착
		
		add(p_south, BorderLayout.SOUTH); //Panel을 South에 부착
		
		bt.addActionlistener(this); //내가 객체의 주체다
		t.addKeylistener(this);
		
		setBounds(200,300, 300,400); //위치 + 너비 까지 지정 가능
		setVisible(true);
	}
	
	//액션리스너의 추상메드 오버라이딩
	public void actionPerformed(ActionEvent e) {
		
		if(chatB==null)
			chatB = new ChatB(this); // 생성시 ChatB에게 ChatA의 주소값을 전달해주자
			
	}
	
	//키리스너의 추상메서드들 오버라이등
	public void keyReleased(KeyEvent e) {
		//자바에서 상수가 직관성을 보유한 의미가 부여된 데이터
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			//A의 area에 체팅로그 추가
			String str=this.t.getText();
			this.area.append(str+"\n");
			
			//chatB의 area에 체팅로그 추가
			chatB.area.append(str+"\n");
			
			//로그를 남긴 후에는 입력했던 텍스트를 다시 초기화
			t.setText("");
		}
		
	}

	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	
	public static void main(String[] args) {
		new ChatA();
		
	}
}
