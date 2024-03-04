package com.sds.project0304;
/*
 * static : 변수, 메서드등을  클래스 원본에 고정시키는 수식자
 * abstract :추상 클레스, 추상 메서드 선언시 사용
 * final : (js에서 const와 동일) final로 선언된 변수는 변경이 물가능 
 * */
public class ModiferTest {
	public static void main(String[] args) {
		final int x = 5; //이 시점 부터는 변경이 불가능, 이 자체가 자바의 상수로 보기는 부족함
			
		//x = 8;
	}
}
