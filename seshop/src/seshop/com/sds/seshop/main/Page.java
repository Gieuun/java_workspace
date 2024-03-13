package seshop.com.sds.seshop.main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

//하위의 모든 페이지마다 공통적인 코드가 발견되었으므로, 유지보수성을 위해
//최상위 객체를 정의한다...따라서 중복되는 코드이면서 보편적인 코드라면 이 클래스에 작성하자
public class Page extends JPanel{
	protected JPanel container; //모든 sub들이 하나씩 반드시 가진다
	protected ShopMain shopmain;
	
	public Page(Color color) {
		//page를 호출하는 sub들은 page의 생성자 호출시, Color의 인스턴스도 넘겨라
		//ex) super(Color.RED)
		setBackground(color);
		setPreferredSize(new Dimension(1000,800));
	}
}
