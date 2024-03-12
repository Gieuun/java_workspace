package com.sds.project0312.insert;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

/* mysql과 연동하고 테이블에 데이터 넣어보기
 * 드라이버란? 프로그래밍 언어가 DBMS 제품을 제어하기 위한 소프트웨어이고,
 * 이 소프웨어는 DBMS 제조사가 개발자들에게 제공할 의무가 있다
 *  MySQL을 연동하려면 MySQL 제조사로 가서 드라이버를 다운 받자
 *  driver.class 파일이 들어있는 .jar 파일을 이클립스 path로 등록하자
 *  
 *  [MySQL 가동하는 법 - 바이너리 압축 버전]
 *  1.환경 변수 path 등록 (~~/bin까지)
 *  2. cmd에 mysql.exe 가동 프로그램으로 서버 시작
 *  3. 새로운 cmd 창으로 mysq -h localhos -u root로 로그인
 */
public class CarInsert extends JFrame {
	JButton bt_connect, bt_regist; // DB 연결 버튼과 등록 버튼
	JTextField t_name, t_price; // 차 이름, 차 가격

	// DB 정보는 절대 노출되어서는 안된다.
	// mysql
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/javase";
	String user = "root";
	String pass = "";

	// 오라클
//	String driver ="oracle.jdbc.driver.OracleDriver";
//	String url="jdbc:oracle:thin:@localhost:1521:XE";
//	String user="batman";
//	String pass="1234";

	Connection con = null; // 접속이 성공된 이후에 접속 정보를 가진 객체

	public CarInsert() {
		// 생성
		bt_connect = new JButton("접속");
		t_name = new JTextField();
		t_price = new JTextField();
		bt_regist = new JButton("등록");

		// 스타일
		Dimension d = new Dimension(270, 38);
		t_name.setPreferredSize(d);
		t_price.setPreferredSize(d);

		// 조립
		setLayout(new FlowLayout());
		add(bt_connect);
		add(t_name);
		add(t_price);
		add(bt_regist);

		// 접속 버튼과 리스너 연결
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});

		// 등록 버튼과 리스너 연결
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
			}
		});

		// 현재 창에 윈도우 리스너 연결
		this.addWindowListener(new WindowListener() {
			// 이벤트 관련 Listener를 구현한 객체들을가리켜 어댑터라 한다.
			// 어댑터는 인터페이싀 추상메서드를 재정의 해놓았으므로, 우리가 그중 원하는 것만
			// 오버라이드하여 사용하면된다
			public void windowClosing(WindowEvent e) {
				// 데이터 베이스 접속 끊기
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				// 현재 프로세스도 종료
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		// 윈도우 설정
		setSize(300, 200);
		setVisible(true);
	}

	public void connect() {
		// 1. 드라이버 로드
		try {
			Class.forName(driver);

			// 2. 접속
			// 접속이 성공이 된 이후에, Connection 인스턴스가 반환된다

			con = DriverManager.getConnection(url, user, pass);
			setTitle("드라이버 로드 성공");

			if (con == null) {
				setTitle("접속 실패");
			} else {
				setTitle("접속 성공");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 등록 (네트워크를 통해 준비된 쿼리문을 전송하자)
	public void regist() {
		java.sql.PreparedStatement pstmt = null; // 쿼리문 담당 객체

		// Oracle
		// String sql="insert into car(car_idx, name, price)";
		// sql+=" values(seq_car.nextval,'"+t_name.getText()+"',
		// "+t_price.getText()+")";

		// MySQL
		String sql = "insert into car(name, price)";
		sql += " values('" + t_name.getText() + "', " + t_price.getText() + ")";

		try {
			// 쿼리문 수행하기
			// 쿼리문은 접속이 성공되어야 실행할 수 있기 때문에,접속 정보를 가진 Connection 객체로부터
			// 인스턴스를 얻어올 수 있다..
			pstmt = con.prepareStatement(sql); // 쿼리문 준비만 한거다....
			int result = pstmt.executeUpdate(); // DML(insert, update ,delete)의 경우 이 메서드로 실행
			// insert 문에 의해 영향을 받은 row count 1이므로 1이 반환됨 (언제나 1건씩 들어가므로...)
			// update문에 의해 영향을 받은 row count는 0보다 커야 한다 (여러건 수정이 가능하므로...)
			// delete 문에 의해 영향을 받은 row count는 0보다 커야 한다 (여러건 삭제가 가능하므로..)

			if (result < 1) {
				this.setTitle("등록 실패");
			} else {
				this.setTitle("등록 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) { // PreparedStatement 객체는 1개당 1:1대응하면 쿼리 수행후 닫아버린다
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new CarInsert();
	}

}
