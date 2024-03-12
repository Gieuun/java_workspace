package com.sds.project0312.select;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CarSelect extends JFrame {
	JButton bt_connect, bt_select;
	JPanel p_north; // 버튼 2개를 올려놓을 북쪽 패널
	JTable table;
	JScrollPane scroll;

	// mysql
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/javase";
	String user = "root";
	String pass;

	// oracle
//	String driver = "oracle.jdbc,driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost@:1521:XE";
//	String user = "batman";
//	String pass = "1234";

	Connection con = null;

	MyTableModel model; // JTable에게 데이터정보를 제공해주는 컨트롤러 중간자

	public CarSelect() {
		// 생성
		bt_connect = new JButton("접속");
		bt_select = new JButton("가져오기");
		p_north = new JPanel();
		table = new JTable(model = new MyTableModel()); // 컨트롤러를 넣을 예정
		scroll = new JScrollPane(table);

		// 조립
		p_north.add(bt_connect);
		p_north.add(bt_select);
		add(p_north, BorderLayout.NORTH); // 프레임의 북쪽에 패널 부착

		// 센터 부착
		add(scroll);

		// 접속 버튼과 리스너 연결
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});

		// 조회버튼과 리스너 연결
		bt_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}

		});

		// 현재 프레임에 윈도우 리스너 연결
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// 데이터 베이스 해제할 예쩡
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				System.exit(0);
			}
		});

		// 윈도우 설정
		setSize(600, 400);
		setVisible(true);
	}

	public void connect() {
		// 1 단계: 드라이버 로드
		try {
			Class.forName(driver);
			setTitle("드라이버 로드 성공");

			// 2 단계 : 접속
			con = DriverManager.getConnection(url, user, pass);
			if (con == null) {
				setTitle("접속 실패");
			} else {
				setTitle("접속 성공");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			setTitle("드라이버 로드 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3 단계 : 쿼리문 수행
		// 4 단계 : 자원 해제
	}

	// 원격지에 연결된 데이터베이스 접속 정보는 Connection 객체를 이용하여,
	// 쿼리문 객체를 생성한 후, 네트워크 select 쿼리를 전송하고, 그 결과도 가져오자
	public void load() {
		java.sql.PreparedStatement pstmt = null;

		// 접속이 된 이후에나 쿼리를 실핼 할 수 있으므로,connection 객체로부터 얻어올수 잇다
		String sql = "select * from car order by car_idx asc";

		// 쿼리문에 오타가 있을 수 있으모 예외처리
		try {
			pstmt = con.prepareStatement(sql); // 쿼리 실행 객체 생성( 아직 쿼리 수행x)
			// DML인 경우 excuteUpdate() 메서드 사용하고. select문인 경우 executeQuery()

			// 오라클의 표를 담고 있는 인터페이스 -> ResultSet
			ResultSet rs = pstmt.executeQuery();

			// DB에 있는 레코드를 가져오기 전에 기존의 list에 담겨져 있었던 제거하고 다시 불러오기
			//갱신
			model.list.removeAll(model.list);
			
			// rs 는 최초에는 아무런 열도 가리키고 있지 않으며 첫번째 레코드 바로 위
			while (rs.next()) { // 한칸 전진
				// 비어 있는 3개 짜리 스트칭 배여을 만들어서, 하나의 층에 있는 레코드를 담자
				String[] data = new String[3];

				// 컬럼의 자료형에 따라 int 일때 getInt(), varchar일때 getString() 될 수 있다
				System.out.println(rs.getInt("car_idx") + "," + rs.getString("name") + "," + rs.getInt("price"));

				data[0] = Integer.toString(rs.getInt("car_idx"));
				data[1] = rs.getString("name");
				data[2] = Integer.toString(rs.getInt("price"));
				
				//하나의 자동차 레코드가 배열에 닮겼으므로, TableModel이 보유한 list에 추가하자
				model.list.add(data);
				System.out.println("현재까지 담아진 레코드 수는"+model.list.size());
				
				//JTable 갱신하여 추가된 레코드가져오기
				table.updateUI();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new CarSelect();
	}

}
