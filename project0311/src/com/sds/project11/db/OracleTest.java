package com.sds.project11.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*오라클이 내 pc에 설치돼있던, 외부에 있던 네트워크로 접속을 시도해야 한다
 * SQLplus 대신 자바 프로그램을 접속 시도하는 것이므로, 접속 과정이 크게 달라지지 않는다
 * 
 * 1) 오라클의 원격지 URL(ip, 도메인 등)
 * 2) 계정 아이디, 비밀번호
 * */
public class OracleTest {

	// JAVA에서 오라클을 제어하기 위해서는 오라클용 클래스 집합인 드라이버 jar가 필요하다
	// jar( Java Archive)의 약자로써, .class 파일을 2개 이상 모아놓은 압축파일을 말한다
	// 오라클 드라이버를 현재 클래스에 환경변수에 등록해야 하지만, 이클립스의 경우 이클립스 내에 등록한다
	public static void main(String[] args) {
		Connection con=null; //접속이 성공한 이후에 생성되는 객체이므로, 만일 이 객체가  null이라면
		//접속은 실패한 것임
		//접속이 성공되었으니, 현재 접속 객체를 이용하여 오라클에 insert 문을 실행해본다 (DML)
		//jdbc에서 쿼리문 수행을 담당하는 객체를 PreparedStatement 라 하면 인터페이스이다 
		
		PreparedStatement pstmt=null;
		//인터페이스는 개발자가 new 하지 못한다..jdbc에서 PreparedStatement 객체는 
		//접속 객체인 Connection 객체로부터 인스턴스를 얻을 수 있다 
		//즉 우리가 자식 클래스를 만드는 방법이 아니라, sun 자체에서 인스턴스를 생성하여 준다
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");

			// 오라클에 접속해 보기
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String id = "batman";
			String pass = "1234";

			con = DriverManager.getConnection(url, id, pass);
			if (con != null) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패");
			}

			String sql = "insert into car(car_idx, name, price) values(seq_car.nextval, 'BMW', 6000)";
			pstmt = con.prepareStatement(sql);
			// sql 문을 준비해 놓으면, 네트워크를 통해 오라클에 전송
			// 하고 이 문장을 받은 오라클은 쿼리문을 수행한다
			// 현재는 쿼리문을 작성만 한 상태

			// pstmt의 메서드를 호출할때 실행왼다
			int result = pstmt.executeUpdate();
			// insert(), update(), delete() 메서드가 따로있는것이 아닌.
			// 모든 DML 쿼리는 executeUpdate() 메서드로 수행됨
			if (result < 1) {// 0은 실패로 간주
				System.out.println("등록 실패");
			} else {
				System.out.println("등록 성공");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("로그인 중 에러 발생");
		}finally {
			// try문 이건 catch문을 거쳐온 실행부이건 모두 이 코드 블럭을 피해갈 수 없다
			// 다 사용한 데이터 베이스 접속 및 쿼리문을 실행했던 객체는 무조건 닫아줘야한다/
			// 다중 사용자 일 경우 메모리 낭비와 서버 다운의 원인이 된다.
			if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
