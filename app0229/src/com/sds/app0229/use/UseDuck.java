package com.sds.app.use;

import com.sds.app0229.bird.Duck;

class  UseDuck{
	public static void main(String[] args) {
		//�⺻�ڷ��� �� ����ȯ
		//�ڹٿ����� ����� �ڷ����̶��, ���� ����ȯ�� �����ϴ�
		//����(byte, short, int, long, float, double) ����(char)
		
		//�ڹٿ��� ��ü���� �ڷ����̶��, ��ü�� ����ȯ�� �����ҳ�? yes
		//[����] �ڹٿ��� ��Ӱ��迡 �ִ� �ڷ����� ���� ����� �ڷ������� �����ȴ�.
		//���� ��ü�� ����ȯ�� ����

		//���� �Ѹ��� �ν��Ͻ� �ø���
		Duck d = new Duck();

		//�θ���� ������ name ����
		System.out.println(d.name);
		d.eat();

		//�θ� ��ü�� �ڽ��� ��ü�� ���� �� �ִ�.
		Bird bird = new Duck();
		System.out.println(bird.age); //up casting

		//�� ū ������ ��ü �ڷ���(�θ�)�� ���� ����� ��ü �ڷ���(�ڽ�)���� ����ȯ
		Duck dc  = (Duck)bird;	//down casting

		//���߿� ����� �ڹ� Ȯ��

	}
}

