package com.sds.project0306.graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

//평상시에는 버튼을 그냥 쓰기만 했지만, 이번에는 버튼이 보유한 paint()메서드를
//뺐기 위해 별도의 클래스로 버튼을 상속받아 paint()오버라이딩 해본다
public class MyButton extends JButton {

	// 버튼이 스스로 자기자신을 ㅡ릴때ㅔ 사용하는 메서드인 paint()를 우리가 재정의 해본다
	public void paint(Graphics g) {
		
		g.setColor(Color.red);
		g.drawString("button err",0, 10);
		System.out.println("버튼 방해중");
	}
}
