package db;

import java.sql.DriverManager; //java SE에 rt.jar에 들어있음 즉 이미 우리가 가지고 있다
import java.sql.SQLException;
import java.sql.Connection;

class OracleTest {
	
	public static void main(String[] args){
		/*오라클 뿐 아니라, 모든 dbms를 연동하고 싶다면, 해당 dbms 사에서
	    제공하는 드라이버를 이용해야한다.
	*/

	//드라이버 로드
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Class에 대한 정보를 가진 클래스를 Class 클래스라하는데.
		//이 클래스의 static 즉 클래스 메서드 중에서 forName() 메서드를 이용하면,
		//오라클 연동과 관련되 드라이버 클래스를 jvm에 메모리 영역에 Load 시킬 수 있다.
		System.out.println("드라이버 로드 성공");
		
		//BATMAN/1234 접속
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "batman";
		String pass = "1234";
		
		Connection con = null; // 접속 성공 시, 그 접속 정보를 가진 객체
										 // 띠라서 만일 이 개체가 null 이라면 접속에 실패한거다.
		con = DriverManager.getConnection(url , id, pass);
		if(con != null){
			System.out.println("접속 성공");
		}

		}catch(ClassNotFoundException e){
			//해당 우려가 정말 현길화 되어, 에러가 발생한다면, jvm에 의해
			//예외 객체인 ClassNotFountException의 인스턴스가 생성되어,
			//catch문의 매개변수 e로 전달된다
			System.out.println("드라이버를 확인해 주세요");
		}catch(SQLException e){
			System.out.println("접속 실패"); //접속 시도시 엘거가 날 가능성이 있으므로 예외처리
		}
	}
}
