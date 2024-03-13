package seshop.com.sds.seshop.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import seshop.com.sds.seshop.main.Page;
import seshop.com.sds.seshop.main.ShopMain;

//관리자 로그인 페이지
public class Login extends Page{
	JPanel container;
	JLabel la_id, la_pass;
	JTextField t_id; 
	JPasswordField t_pass;
	JButton bt_regist, bt_login;
	
	ShopMain shopmain;
	
	public Login(ShopMain shopmain) {
		super(Color.MAGENTA);
		this.shopmain= shopmain;
		
		//생성
		container = new JPanel();
		la_id = new JLabel("ID");
		la_pass = new JLabel("PassWord");
		t_id = new JTextField();
		t_pass = new JPasswordField();
		bt_login= new JButton("login");
		bt_regist = new JButton("관리자 가입");
		
		//스타일
		container.setPreferredSize(new Dimension(600, 250));
		container.setBackground(Color.CYAN);
		
		Dimension d = new Dimension(280, 40);
		la_id.setPreferredSize(d);
		t_id.setPreferredSize(d);
		la_pass.setPreferredSize(d);
		t_pass.setPreferredSize(d);
		
		//조립
		add(container);
		container.add(la_id);
		container.add(t_id);
		container.add(la_pass);
		container.add(t_pass);
		container.add(bt_login);
		container.add(bt_regist);
		
		//관리자 가입에 리스너 연결
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				shopmain.showHide(3);
				
			}
		});
	}
}
