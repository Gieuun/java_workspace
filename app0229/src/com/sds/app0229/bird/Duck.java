package com.sds.app0229.bird;


//���� �ڽ��� ������ �����Ѵ�
public class Duck extends Bird{
						/*= is a */
	String color= "White";
	/*
	public Duck(){
		super();	
	}
	*/

	public void quack(){
		System.out.println("������ ��");
	}

	public void fly(){
		System.out.println("���� ����.");
	}

	public static void main(String[] args){
		Bird bird = new Bird();
		bird.fly();	//�θ�

		Bird d = new Duck();
		d.fly();	//�ڽ� ���
	}
}
	
