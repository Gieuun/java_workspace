/*
������ ���� ������ ����
���ǿ� �����ϴ� �ڵ����� �ִ��� ǥ���϶�
*/
package com.sds.app0229.car;

/*
Has a ���� : ��ü�� �ٸ� ��ü�� ��ǰ���� ���� ����
				�ڹ� ���� has a ���踦 ǥ���� ����,
				��� ������ ��ü �ڷ��� ������ �д�
*/
public class Car{
	public Wheel[] wheel; //��ü �ڷ����� �ڷ����̹Ƿ�, ��������� ������ �翬�� ����
	public Handle handle;
	public Door[] door;
	int price =50; // has a ����x -> is a, has a ��� ��ü�� ���踦 ǥ��
	//has a ����� ��ü�� ������ Ŭ������ �ν��Ͻ��� �ø����� �ʱ��� �۾��� �Ϲ� �ڷ��� ����
	//ó�� �ؾ��� �۾��� ����..���� ���������� �����ڸ� Ȱ������

	public Car(){
		wheel = new Wheel[4]; //�迭 ����, ������ �� ũ�⸦ ����ؾ��Ѵ�
		wheel[0] = new Wheel();	//���� 1�� ����
		wheel[1] = new Wheel();
		wheel[2] = new Wheel();
		wheel[3] = new Wheel();

		handle = new Handle(); //�ڵ� ����

		door = new Door[2]; //2��¥�� ������ī�� ��¦ ������ ��������
		door[0]=new Door();	
		door[1]=new Door();
		
	}


}
