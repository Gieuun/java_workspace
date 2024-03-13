package seshop.com.sds.seshop.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import seshop.com.sds.seshop.Admin.AdminList;
import seshop.com.sds.seshop.Admin.AdminRegist;
import seshop.com.sds.seshop.Admin.Login;
import seshop.com.sds.seshop.product.ProductList;
import seshop.com.sds.seshop.product.ProductRegist;

//쇼핑몰관리자 페이지의 메인
public class ShopMain extends JFrame {
	JPanel p_north;
	JButton bt_regist, bt_list, bt_admin, bt_join, bt_login;
	String[] iconArray = { "regist.png", "list.png", "admin.png", "join.png", "login.png" };

	// js와 달리, 자바의 순수 배열은 js처럼 다양한 indexOf 등이 없다. 대신 컬렉션 프레임웍에 들어있다
	// 아래의 배열을 Collection Framework에서 지원하는 3가지 객체 중 선택하여 바꾸자
	// 1)순서가 있는 배열 (List) 2) 순서가 없는 배열 () 3) key : value (Map)
	ArrayList<JButton> btn = new ArrayList<JButton>();// 버튼을 담을 수 있는 배열

	Page[] pages = new Page[5]; // 모든 페이지를 담게될 배열

	JPanel p_center; // 교체될 페이지들이 붙은 컨테이너(삼품등록, 상품목록, 관리자명단, 관리자등록, 로그인폼)

	String dirver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "shop";
	String pass = "1234";

	public Connection con = null; // 접속한 이후 그 정보를 가진 객체, 정보를 가지고 있으므로 추후 접속 해제 까지 가능

	public ShopMain() {
		p_north = new JPanel();

		Dimension d = new Dimension(70, 60);

		for (int i = 0; i < iconArray.length; i++) {
			JButton bt = new JButton(getIcon(iconArray[i]));
			bt.setPreferredSize(d);
			p_north.add(bt); // 버튼을 패널에 부착
			btn.add(bt); // 버튼을 ArrayList에 넣기

		}

		// 센터 프레임 생성
		p_center = new JPanel();
		p_center.setBackground(Color.gray);

		// 5 페이지 생성
		pages[0] = new ProductRegist();
		pages[1] = new ProductList();
		pages[2] = new AdminList();
		pages[3] = new AdminRegist(this);
		pages[4] = new Login(this); // 로그인 객체는 ShopMain 인스턴스 주소값을 원함니다

		// 5 페이지를 center에 부착
		for (int i = 0; i < pages.length; i++) {
			p_center.add(pages[i]);
		}

		// 5페이지 중 누구를 default 화면으로할지 결정하는 코드
		showHide(pages.length - 1); // 로그인인 마지막 페이지

		// 프레임에 패널 부착
		add(p_north, BorderLayout.NORTH);
		add(p_center);

		// 윈도우 어댑터를 익명으로 연결
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// DB 커넥션 닫을 예정
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

		// 상품 등록 버튼에 리스너 연결
		for (int i = 0; i < btn.size(); i++) {
			btn.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("당신이 누른 버튼의 배열의 index는" + btn.indexOf(e.getSource()));

					showHide(btn.indexOf(e.getSource()));
				}
			});
		}

		// 윈도우설정
		setSize(1000, 850);
		setVisible(true);

		// 오라클 접속 시도
		connect();
	}

	// 5페이지 중 어느 페이지를 보여줘야 할지를 경정짓는 메서드
	public void showHide(int index) {
		for (int j = 0; j < pages.length; j++) {
			if (j == index) {
				pages[j].setVisible(true); // 선택한 index번째 페이지만 true
			} else {
				pages[j].setVisible(false); // 조건에 맞지 않으면 false
			}
		}
	}

	// 지정한 경로의 아이콘을 반환해주는 메서드
	// filename에 원하는 이미지 명을 넣으면, 아이콘으로 반환
	public ImageIcon getIcon(String filename) {
		URL url = getClass().getClassLoader().getResource(filename); // url 객체로 받기
		ImageIcon icon = new ImageIcon(url);

		// Imageicon 클래스 자체에는 크기를 조정하는 메서드가 지원되지 않으므로, Image로 변환 후
		// Image가 보유한 getScaledInstance() 메서드로 크기를 조정하자
		Image image = icon.getImage();
		image = image.getScaledInstance(100, 90, Image.SCALE_SMOOTH);

		return new ImageIcon(image); // 변환시킨 이미지를 다시 이미지아이콘으로 변환하여 반환
	}

	// 오라클 접속
	public void connect() {
		setTitle("접속 시도중...");

		try {
			Class.forName(dirver);

			// 접속
			// 접속이 성공하게 되면 con은 더이상 null이 아님
			con = DriverManager.getConnection(url, user, pass);
			if (con == null) {
				setTitle("접속 실패");
			} else {
				setTitle("오라클 연결 됨");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			setTitle("드라이버를 확인해주세요");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("오라클 연결 됨");
	}

	public static void main(String[] args) {
		new ShopMain();
	}

}
