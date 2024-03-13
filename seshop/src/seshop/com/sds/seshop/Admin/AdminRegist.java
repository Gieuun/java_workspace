package seshop.com.sds.seshop.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import seshop.com.sds.seshop.lib.EncryptionManager;
import seshop.com.sds.seshop.main.Page;
import seshop.com.sds.seshop.main.ShopMain;

//관리자 등록 페이지
public class AdminRegist extends Page {
	JLabel la_id, la_pass, la_email, la_profile;
	JTextField t_id;
	JPasswordField t_pass;
	JTextField t_email;
	JButton bt_profile;// 프로필 사진 선택 창 띄우기 버튼
	JLabel la_dummy;// 프로필 사진의 공백을 메울 목적
	JPanel p_preview; // 사진 미리보기
	JButton bt_regist, bt_login;
	JFileChooser chooser; // 파일 탐색기
	Image image = null; // 최초에는 파일 선택을 안한 상태

	public AdminRegist(ShopMain shopmain) {
		super(Color.CYAN);
		this.shopmain = shopmain;

		container = new JPanel();

		la_id = new JLabel("ID");
		la_pass = new JLabel("Password");
		la_email = new JLabel("Email");
		la_profile = new JLabel("프로필사진");
		la_dummy = new JLabel("");

		t_id = new JTextField();
		t_pass = new JPasswordField();
		t_email = new JTextField();
		bt_profile = new JButton("파일 찾기");
		// p_preview라는 패널의 자식 클래스를 원래 .java 파일로 정의해야 하지만
		// 재사용성이 떨어진다면, 즉 1회성리아면 굳이 .java를 외부로 둘 필요가 없다
		// 내부익명 클래스로 정의하자
		p_preview = new JPanel() {
			public void paint(Graphics g) {
				g.setColor(Color.GRAY);
				g.fillRect(0, 0, 280, 280);

				if (image == null) { //아직 이미지를 선택하지 않았다면 문구
					g.setColor(Color.WHITE);
					g.drawString("파일 선택", 40, 40);
				}else { //이미 객체가 채워져 있다면 그림을 출력
					g.drawImage(image, 0, 0, 280, 280, p_preview);					
				}
			}
		};
		bt_regist = new JButton("가입");
		bt_login = new JButton("Login");
		chooser = new JFileChooser("D:\\js_workspace\\images"); // 디폴트 경로

		// 스타일
		container.setBackground(Color.LIGHT_GRAY);
		container.setPreferredSize(new Dimension(600, 700));

		Dimension d = new Dimension(280, 40);

		la_id.setPreferredSize(d);
		t_id.setPreferredSize(d);
		la_pass.setPreferredSize(d);
		t_pass.setPreferredSize(d);
		la_email.setPreferredSize(d);
		t_email.setPreferredSize(d);
		la_profile.setPreferredSize(d);
		bt_profile.setPreferredSize(d);
		la_dummy.setPreferredSize(d);

		p_preview.setPreferredSize(new Dimension(280, 280));

		// 조립
		container.add(la_id);
		container.add(t_id);
		container.add(la_pass);
		container.add(t_pass);
		container.add(la_email);
		container.add(t_email);
		container.add(la_profile);
		container.add(bt_profile);
		container.add(la_dummy);
		container.add(p_preview);
		container.add(bt_regist);
		container.add(bt_login);

		add(container);

		// 프로필 버튼에 리스너 연결
		bt_profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preview();

			}
		});

		// 가입 버튼에 리스너 연결
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
			}
		});
		// 로그인 버튼에 리스너 연결
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shopmain.showHide(4);

			}
		});
	}

	// 프로파일 열어서 이미지를 패널에 그리기
	public void preview() {
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) { // 열기른 누르면
			// 유저가 선택한 파일 알아맞추고, 그 이미지 파일을 이용하여 p_preview 패널에 그림을 그려보자
			File file = chooser.getSelectedFile(); // 유저가 선택한 파일
			String filename = file.getAbsolutePath(); //현재 파일의 풀 하드 경로
			ImageIcon icon = new ImageIcon(filename);
			image=icon.getImage(); //멤버변수인 image에 대입
			//미리보기 패널에게 다시 그릴 것을 명령
			p_preview.repaint();
		}
	}

	// 회원 가입 메서드 정
	public void regist() {
		// 쿼리문 수행
		// 쿼리문 수행은 접속 이후에 가능 하므로, 접속 객체로 부터 얻어 와야한다
		java.sql.PreparedStatement pstmt = null;

		// shopmain의 con은 나와 다른 패키지에 있는 멤버 변수 이므로 접근 제한을 해제하려면
		// getter를 구현 하던가 public으로 접근 제한을 헤제하자
		try {
			String id = t_id.getText(); // 텍스트 필드에서 사용자가 입력한 id
			String pass = new String(t_pass.getPassword()); // pass
			String email = t_email.getText(); // email
			String filename = "123123.png"; // 사용자가 선택한 사진의 파일이름

			pass = EncryptionManager.getConvertedData(pass);

			String sql = "insert into admin(admin_idx, id, pass, email, filename)";
			sql += " values(seq_admin.nextval, '" + id + "','" + pass + "','" + email + "','" + filename + "')";
			pstmt = shopmain.con.prepareStatement("sql");

			// 오라클 실행전 검증
			System.out.println(sql);

			pstmt = shopmain.con.prepareStatement(sql);

			// 준비된 커리문 수행
			int result = pstmt.executeUpdate(); // 쿼리 실행 DML인 경우 0이 나오면 실패

			if (result == 0) {
				JOptionPane.showConfirmDialog(this, "가입 실패");
			} else {
				JOptionPane.showConfirmDialog(this, "가입 성공\n 이용하시려면 로그인 해주세요");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
