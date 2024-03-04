package com.sds.app0229.bird;


//새의 자신인 오리를 정의한다
public class Duck extends Bird{
						/*= is a */
	String color= "White";
	/*
	public Duck(){
		super();	
	}
	*/

	public void quack(){
		System.out.println("오리는 꽥");
	}

	public void fly(){
		System.out.println("오리 날다.");
	}

	public static void main(String[] args){
		Bird bird = new Bird();
		bird.fly();	//부모

		Bird d = new Duck();
		d.fly();	//자식 출력
	}
}
	
