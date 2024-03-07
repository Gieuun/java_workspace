package com.sds.project0305.member;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.Actionlistener;
import java.awt.event.KeyEvent;
import java.awt.event.Keylistener;
import java.awt.event.WindowEvent;
import java.awt.event.Windowlistener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * java.awt 패키지는 os 에 따라 다른 디자인으로 보여질 수 있기 때문에 
 * 이를 개선한 패키지인 javax.swing 패키지를 이용해보자 
 * os 중립적인  자체적인 Look&Feel 을 가진다..
 * No 걱정 - awt와 크게 달라지지 않고 기존의 awt 컴퍼넌트에 J접두어 붙이자 
 * 그리고 여전히 java.awt 의 레이아웃 배치관리자와 java.awt.event  여전히 java.awt 를 유지   
 * 
 * 이벤트 프로그래밍의 3단계 절차 
 * 1) 적절한 리스너 선택 
 * 2) 해당 리스너의 메서드 오버라이드(개발자가 원하는 코드로 재정의)
 * 3) 컴포넌트와 리스너 연결
 * */
public class MemberJoin extends JFrame implements Windowlistener, Actionlistener, Keylistener{
	JLabel la_title; //회원가입 제목 
	JPanel p_content; // 가운데 영역 
	JLabel la_id, la_pass, la_jumin, la_gender, la_hobby, la_file, la_zip;
	
	JTextField t_id; //아이디 
	JPasswordField t_pass; //비밀번호 
	JTextField t_jumin1, t_jumin2;//주민번호 앞,뒤자리 
	//JCheckbox를 그룹화 시켜놓아야 라디오가 등장, html 에서도  radio는 배열로 존재시켜야 함 
	CheckboxGroup cg;
	Checkbox man;
	Checkbox woman;
	
	JCheckBox[] hobby = new JCheckBox[4]; //취미
	String[] hobbyName= {"Travel","Programming","exercise", "movie"};
	JTextField t_profile; //프로필 사진 경로 
	JTextField t_filename, t_ext; //파일명과 확장자 
	JTextField t_zip1, t_zip2; //우편번호 앞,뒤자리 
	JButton bt_regist; //가입버튼
	
	int hobby_count=0; //체크박스의 총 체크 횟수를 증가 알 수 있는 변수
								//1미만 -> 체크를 안한사람 -> return
	
	public MemberJoin() {
		//생성
		la_title = new JLabel("Member Regist");
		p_content = new JPanel();
		la_id = new JLabel("ID");
		la_pass = new JLabel("Password");
		la_jumin = new JLabel("주민번호");
		la_gender = new JLabel("성별");
		la_hobby = new JLabel("취미");
		la_file = new JLabel("프로필 사진명"); 
		la_zip = new JLabel("우편번호");
		
		t_id = new JTextField();
		t_pass = new JPasswordField();
		t_jumin1 = new JTextField();
		t_jumin2 = new JTextField();
		cg = new CheckboxGroup(); //그룹을 생성한다.
		man = new Checkbox("man", cg, false); //cg 그룹에 소속시킨다
		woman = new Checkbox("woman", cg, false); //cg 그룹에 소속시킨다
		
		
		for(int i=0;i<hobby.length;i++) {
			hobby[i] = new JCheckBox(hobbyName[i]);
		}
		t_profile = new JTextField();
		t_filename = new JTextField();
		t_ext = new JTextField();
		t_zip1 = new JTextField();
		t_zip2 = new JTextField();
		bt_regist = new JButton("가입하기");
		
		//스타일
		//제목의 텍스트 크게 하기 
		la_title.setFont(new Font("Verdana", Font.BOLD, 50));
		p_content.setBackground(Color.green);
		
		//아이디스타일 
	 	Dimension d=new Dimension(290, 28);
		la_id.setPreferredSize(d);		
		t_id.setPreferredSize(d);
		
		//패스워드 스타일 
		la_pass.setPreferredSize(d);
		t_pass.setPreferredSize(d);
		
		//주민번호 스타일 
		la_jumin.setPreferredSize(d);
		Dimension d2 = new Dimension(145, 28);
		t_jumin1.setPreferredSize(d2);
		t_jumin2.setPreferredSize(d2);
		
		//성별 스타일 
		la_gender.setPreferredSize(d);
		
		//취미 라벨 스타일
		la_hobby.setPreferredSize(d);
		
		//프로필 스타일 
		la_file.setPreferredSize(d);
		Dimension d3 = new Dimension(110, 28);
		t_profile.setPreferredSize(d3);
		t_filename.setPreferredSize(d3);
		t_ext.setPreferredSize(d3);
		
		//우편번호 스타일 
		la_zip.setPreferredSize(d);
		t_zip1.setPreferredSize(d2);
		t_zip2.setPreferredSize(d2);
		
		
		//조립
		add(la_title, BorderLayout.NORTH); //프레임의 북쪽에 부착 
		add(p_content); // 센터에 부착 
		
		p_content.add(la_id);
		p_content.add(t_id);
		
		p_content.add(la_pass);
		p_content.add(t_pass);
		
		p_content.add(la_jumin);
		p_content.add(t_jumin1);
		p_content.add(t_jumin2);
		
		p_content.add(la_gender);
		p_content.add(man);
		p_content.add(woman);
		
		//취미를 반복문으로 부착 
		p_content.add(la_hobby);
		for(int i=0; i<hobby.length;i++) {
			p_content.add(hobby[i]);
		}
		
		//프로필 사진 부착 
		p_content.add(la_file);
		p_content.add(t_profile);
		p_content.add(t_filename);
		p_content.add(t_ext);
		
		//우편번호 부착
		p_content.add(la_zip);
		p_content.add(t_zip1);
		p_content.add(t_zip2);
		
		//버튼 부착 
		p_content.add(bt_regist);
		
		//현재 프레임과 리스너 연결 
		//현재프레임.addWindowlistener( 리스너 구현한 者)
		//this 의 정의? 레퍼런스 변수이다.
		this.addWindowlistener(this);
		
		//버튼과 리스너 연결 
		bt_regist.addActionlistener(this);
		
		//주민번호 뒷자리 텍스트필드와 리스너 연결
		t_jumin2.addKeylistener(this);
		
		//윈도우 설정 
		setSize(700,500);
		setVisible(true);
	}
	
	//유효성 체크 
	public void checkForm() {
		//getText() 메서드의 반환값은  String 이고, 
		//String 은 객체이므로 String 객체의 api를 활용할 수 있다
		if(t_id.getText().length() <1) {
			JOptionPane.showMessageDialog(this , "아이디를 입력하세요");
			t_id.requestFocus();
			return;
		}
		
		//비밀번호 유효성 체크 
		char[] pass = t_pass.getPassword();
		if(pass.length <1) {
			JOptionPane.showMessageDialog(this , "비밀번호를 입력하세요");
			t_pass.requestFocus();
			return;
		}
		
		
		//웹 : 서버로 전송하거나,
		//독립실행형: 오라클에 직접 insert 수행
		System.out.println("오라클에 등록할 예정");
	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println("눌렀어?");//유효성
		//체크박스 중 하나를 눌렀을때
		
		//버튼을 눌렀을때
		checkForm();
		
	}
	
	//t_jumin2에 대해 키보드 눌렀다 뗄때 호출
	public void keyReleased(KeyEvent e) {
		char n=t_jumin2.getText().charAt(0); //주민번호 뒷자리 String 중 앞 첫 문자 반환
		//'1'  --> 정수 1  js:  parseInt() 
		//자바에서는 모든 기본 자료형을 객체자료형으로 바꾼다거나, 역으로 객체 자료형을 기본자료형으로 
		//변환하는 기능을 지원하는 객체가 있으며, 이 객체를 가리켜 wrapper 클래스라 한다
		// byte - Byte, short-Short, int-Integer ,long-Long ,float, double , char-Character, boolean
		String s = Character.toString(n); //  '1' 을 "1"로 변환
		int result = Integer.parseInt(s);//  "1" 을 정수 1로 변환
		
 		if(result==1) { //남자라면
			man.setState(true);   //체크되어있게
		}else if(result==2){//여자라면
			woman.setState(true);//체크되어있게..
		}
 		
	}
	
	public static void main(String[] args) {
		MemberJoin mj = new MemberJoin();
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); //프로세스(실행중인 프로그램) 종료
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}