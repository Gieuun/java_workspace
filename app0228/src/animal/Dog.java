/*
[��Ű���� ����ϴ� ����]

1).java�� .class������ �Բ� ���� �ʰ� �и����� ����
2)���ü� �ִ� Ŭ�������� ���� ���丮���� ��� ����
3)Ŭ������ �ߺ� ������ ���ذ� �� �ִ�.
*/

package animal;

//��Ű���� ����� Ŭ������ �ܺο��� ����ϰ� �Ϸ��� �ݵ�� 
public class Dog {
	private String name="�ǹ�";
	private age=3;

	//������ �ۺ����� �ص� ������, �߿��� ������ ��찡 �����Ƿ�
	//�ۺ����� ���� ���� ����� ���� ã�� �� �� ����.
	//���� ������ ������ private �ܺ� ������ ����, ���� ���� �޼��带
	//���� �������� ������ �� �ֵ��� �ϴ� Ŭ���� ���� ����� ������
	//ĸ��ȭ(����ȭ) - encapsulation

	public String getName(){ //getter reading
		return name;
	}
publvi void setName(String name){ //setter wrighting
	this.name=name;
}

}
