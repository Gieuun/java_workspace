package com.sds.project0307.copy;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUICopy extends JFrame implements ActionListener, WindowListener {
	JLabel la_ori, la_dest;
	JTextField t_ori, t_dest;
	JButton bt;

	// 필요한 겍채가 있다면 has a로 보유
	FileInputStream fis;
	FileOutputStream fos;

	public GUICopy() {
		super("파일 복사 프로그램"); // 프로그램 타이틀
		la_ori = new JLabel("원본위치");
		la_dest = new JLabel("원본위치");

		t_ori = new JTextField("D:/java_workspace/project0307/res/RetroMario.webp");
		t_dest = new JTextField("D:/java_workspace/project0307/res/RetroMario2.webp");

		bt = new JButton("복사 실행");

		// 스타일 적용
		Dimension d1 = new Dimension(180, 35);
		Dimension d2 = new Dimension(450, 35);

		la_ori.setPreferredSize(d1);
		la_dest.setPreferredSize(d1);

		t_ori.setPreferredSize(d2);
		t_dest.setPreferredSize(d2);

		// 조립
		setLayout(new FlowLayout());
		add(la_ori);
		add(t_ori);
		add(la_dest);
		add(t_dest);
		add(bt);

		// 버튼과 리스너 연결
		bt.addActionListener(this);

		// 윈도우 설정
		setSize(700, 200);
		setVisible(true);
		setLocationRelativeTo(null); // js의 margin=auto

		// 스트림과 같이 사용 후, 메모리에서 해제시켜야할 자원이 있는경우 아래의 프로세스 종료는
		// 위험하다 스트림 닫을 기회를 못 가지니깐
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// 복사실행
	public void copy() {
		// 원본 파일에 빨대 꽂기(스트림 생성)
		try {
			fis = new FileInputStream(t_ori.getText());
			fos = new FileOutputStream(t_dest.getText());
			setTitle("파일을 대상으로 스트림 생성 성공");

			// 생성된 스트림들을 이용하여, 데이터를 읽어들이고(read()), 내뱉어 보자(write())
			int data = -1; // 바이트를 읽어서 보관해 놓을 변수
			while (true) {
				data = fis.read(); // 1 byte 읽기

				if (data == -1)
					break; // 파일을 다 읽었으면 루프 종료

				fos.write(data); // 읽어들였던 1 byte를 비어있는 파일에 출력
			}
			JOptionPane.showMessageDialog(this, "파일 복사완료");

		} catch (FileNotFoundException e) {
			JOptionPane.showInternalMessageDialog(this, "파일의 경로를 확인 해주세요");
			e.printStackTrace();
		} catch (IOException e) {
			setTitle("파일 입출력 중 에러 발생");
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("bt clicked");
		copy();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	// 창 닫을 때
	public void windowClosing(WindowEvent e) {
		// 우리가 생성한 스트림을 닫자
		if (fis != null) { // 스트림이 존재한다면
			try {
				fis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (fos != null) { // 스트림이 존재한다면
			try {
				fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {

	}

	public void windowActivated(WindowEvent e) {

	}

	public void windowDeactivated(WindowEvent e) {

	}

	public static void main(String[] args) {
		new GUICopy();
	}

}
