class DataType4{

	public static void mian(String[] args){
		char c ='��'; //2byte �뷮��, �������� ��� ���ڸ� �� ������ �� ����
							//���� 1byte ���ٸ�, �����ڿ� Ư�� ���� �ۿ� ���� ����

		//char ���� ���, 2byte(2^16 ����)�� ǥ���� �� �ִ� ������.
		//�ᱹ �����ڵ带 ��� ���� �� ���ڸ� ��� ���� �����̹Ƿ�, ������ �������� ����
		//���� ��� ���� ������ �����͸� ����ϴµ��̴� �Ѱ谡 �ִ�.
		//char a = 65;
			
			byte b =13;
			int x =67;
			x=b;		//���� byte�� 1, int���� 4 ����Ʈ �̱� ������, ���� �ڷ����� ū �ڷ����� ������ �� �ִ�.

			short s=26;

			b=s; //2byte

			//������ �����͸� ������ �����ͷ� ��ȯ�ϰ��� �Ҷ�, ���� �ս��� ����Ǹ�
			//���α׷��� �ڵ����� ����ȯ�� ���� �ʰ�, �����ڿ��� ������ ������ ������ �����
			//�̶� �ս��� �����ϴ��� ������  �Ϸ���, ���� ����ȯ �������� 
			//(cast) �����ڸ� ����Ѵ�
			b=(byte)s;

			//byte < short < int < long

			short s=123;
			byte b=7;
			int x=78;
			
			//������ b�� 1byte�̰�, �� b�� ���� s�� �����Ϸ� �Ҷ�
			//�����Ϸ��� ������ �����ϱ��� ����, ������ �����Ϸ��� �����ϰ� ���߷� �� ���̴�.
			//�̶� ������ b�� ������ s���� ���� �ڷ����̹Ƿ�, b-->s�� ��ȯ �Ѵٰ� �Ͽ� 
			//�ս��� �߻����� �ʱ� ������, �����ڿ��� ����� �ʰ� �ڵ����� b�� shor�� ��ȯ�Ѵ�
			//�̷��� ������ ������ �ڵ�����ȯ�̶� �Ѵ�.
			s=b;

			b=(byte)x;

	}
}