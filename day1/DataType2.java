/*������ �ڷ���*/

/**
 * DataType2
 */
public class DataType2 {

    public static void main(String[] args) {
        /*
         ���� : char 2 byte
         ����: �Ǽ� ����
         1)�Ǽ�: float(4) < double(8)
         2)����: byte(1) < short(2) < int(4) < long(8)
         ����: boolean(1)
         */
        
         byte b=127; //dl byte�� ���� 256������ ���ڸ� ������ �ִ�. -128~127
		
		//�ڹٿ����� ��� �Ǽ��� Ư���� ǥ�ø� ���� ������ default���� double�� �����Ѵ� 
		//���� float �ڷ����� ����Ҷ�, �Ҽ��� ���� f �� ǥ���Ѵ�.
		 float x=0.96f;
         

		 //����
		 boolean k = true;

		 //���� �ڷ��� ����) ���ڿ��� �ƴ�
		 char m='Y'; //ö�� �ϳ����� ���� �� �ִ�.
		 System.out.println(m);
    }
}