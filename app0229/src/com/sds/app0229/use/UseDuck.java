package com.sds.app.use;

import com.sds.app0229.bird.Duck;

class  UseDuck{
	public static void main(String[] args) {
		//기본자료형 간 형변환
		//자바에서는 비슷한 자료형이라면, 서로 형변환이 가능하다
		//숫자(byte, short, int, long, float, double) 문자(char)
		
		//자바에서 객체형도 자료형이라면, 객체간 형변환도 가능할끼? yes
		//[증요] 자바에서 상속관계에 있는 자료형은 서로 비슷한 자료형으로 인정된다.
		//따라서 객체간 형변환도 지원

		//오리 한마리 인스턴스 올리기
		Duck d = new Duck();

		//부모님이 물려준 name 접근
		System.out.println(d.name);
		d.eat();

		//부모 객체는 자식의 객체를 담을 수 있다.
		Bird bird = new Duck();
		System.out.println(bird.age); //up casting

		//더 큰 개념의 객체 자료형(부모)을 작은 계념의 객체 자료형(자식)으로 형변환
		Duck dc  = (Duck)bird;	//down casting

		//나중에 강사님 자바 확인

	}
}

