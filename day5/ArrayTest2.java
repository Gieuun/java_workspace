class ArrayTest2 {
	public static void main(String[] args) {
		/*
		js���� ����� ���ÿ� ���� �Ҵ��ϴ� ������� �迭�� �����Ҷ� �Ʒ��� ����
		let arr=["���","����","������"];
		*/

		String[] arr={"���","����","������"};
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}

		//jdk5 ���� ���� �������� �����ʹ� ������ ����(improved loop)�� ����
		//for(�ѿ�� :������) �ӵ� ��������, ������ ó�� �� ����
		for(String fruit :arr){
			System.out.println(fruit);
		}
		

	}
}