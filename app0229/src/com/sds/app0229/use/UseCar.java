package com.sds.app0229.use;

import com.sds.app0229.car.Car;

class UseCar{
	public static void main(String[] args) {
		
		Car car = new Car(); //자동차 1대 생성

		//자동차 핸들의 타입 출력
		System.out.println(car.handle.type);

		//자동차 문짝의 색상
		System.out.println(car.door[0].color);
		
		//자동차 바퀴의 브랜드 출력
		System.out.println(car.wheel[0].brand);
	}
}
