/*�ڵ����� �����Ѵ�*/

class Car {
	/*����, �Լ�*/

	String color = "yellow"; //������ �����
	int price = 200; //������ 200

	//�ڹٿ����� �޼��� ���� �� ��ȯ�� ���� ���θ� �ݵ�� �˷���� �Ѵ�.
	//reuturn���� ���� �޼���� ȣ���ڰ� �ƹ��͵� ������ ���� ���ٰ� �Ͽ� void�� �ٿ��ش�
	public void setColor(){
		color ="red";
	}

	//return�� ���� �ڷ����� void �ڸ��� �ۼ��ؾ���.
	public int getRandom(){
		return 5;
	}

	public boolean flag(){
		return true;
	}

	public void setPrice(){
		price = 500;
	}
}
