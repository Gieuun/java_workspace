/*
별도의 제한 조건은 없다
현실에 존재하는 자동차를 최대한 표현하라
*/
package com.sds.app0229.car;

/*
Has a 관계 : 객체가 다른 객체를 부품으로 갖는 관계
				자바 언어로 has a 관계를 표현할 때는,
				멤버 변수에 객체 자료형 변수로 둔다
*/
public class Car{
	public Wheel[] wheel; //객체 자료형도 자료형이므로, 멤버변수로 선언이 당연히 가능
	public Handle handle;
	public Door[] door;
	int price =50; // has a 관계x -> is a, has a 모두 객체간 관계를 표현
	//has a 관계로 객체를 보유한 클래스의 인스턴스를 올릴때는 초기하 작업이 일반 자료형 보다
	//처리 해야할 작업이 많다..따라서 저극적으로 생성자를 활요하자

	public Car(){
		wheel = new Wheel[4]; //배열 생성, 무저간 그 크기를 명시해야한다
		wheel[0] = new Wheel();	//바퀴 1개 생성
		wheel[1] = new Wheel();
		wheel[2] = new Wheel();
		wheel[3] = new Wheel();

		handle = new Handle(); //핸들 생성

		door = new Door[2]; //2개짜리 스포츠카용 문짝 생성할 공간마련
		door[0]=new Door();	
		door[1]=new Door();
		
	}


}
