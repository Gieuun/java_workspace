package db;

import java.sql.DriverManager; //java SE�� rt.jar�� ������� �� �̹� �츮�� ������ �ִ�
import java.sql.SQLException;
import java.sql.Connection;

class OracleTest {
	
	public static void main(String[] args){
		/*����Ŭ �� �ƴ϶�, ��� dbms�� �����ϰ� �ʹٸ�, �ش� dbms �翡��
	    �����ϴ� ����̹��� �̿��ؾ��Ѵ�.
	*/

	//����̹� �ε�
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Class�� ���� ������ ���� Ŭ������ Class Ŭ�������ϴµ�.
		//�� Ŭ������ static �� Ŭ���� �޼��� �߿��� forName() �޼��带 �̿��ϸ�,
		//����Ŭ ������ ���õ� ����̹� Ŭ������ jvm�� �޸� ������ Load ��ų �� �ִ�.
		System.out.println("����̹� �ε� ����");
		
		//BATMAN/1234 ����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "batman";
		String pass = "1234";
		
		Connection con = null; // ���� ���� ��, �� ���� ������ ���� ��ü
										 // ��� ���� �� ��ü�� null �̶�� ���ӿ� �����ѰŴ�.
		con = DriverManager.getConnection(url , id, pass);
		if(con != null){
			System.out.println("���� ����");
		}

		}catch(ClassNotFoundException e){
			//�ش� ����� ���� ����ȭ �Ǿ�, ������ �߻��Ѵٸ�, jvm�� ����
			//���� ��ü�� ClassNotFountException�� �ν��Ͻ��� �����Ǿ�,
			//catch���� �Ű����� e�� ���޵ȴ�
			System.out.println("����̹��� Ȯ���� �ּ���");
		}catch(SQLException e){
			System.out.println("���� ����"); //���� �õ��� ���Ű� �� ���ɼ��� �����Ƿ� ����ó��
		}
	}
}
