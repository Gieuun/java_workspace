package com.sds.project0304;

//게임의 촤상의 객체인 GameObject를 상속받아, 특히 현재 나의 상황에 맞지
//않는 메서드인 move()를 나의 현실에 맞게 업그레이드(오버라이딩)하자
public class Hero extends GameObject {
	/*
	 * 추상 메서드를, 상속 받는 자식을 부모의 재산을 물려 받는 느낌x
	 * 부모가 진 빚을 물려 받는 느낌으로 개발
	 * 따라서 부모가 완성하지 못했던, 해당 메서드를 자식 세대에서 완성시켜야 할 의무를 가진다
	 *이러한 자식에게 부여되는 의무를 '구현 강제'라 한다.
	 * */
	
	public void move() {
		//나만의 움직임 코드 작성
	}
	
	public static void main(String[] args) {
		Hero h = new Hero();
		h.move();
	}
}

