package seshop.com.sds.seshop.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import seshop.com.sds.seshop.main.Page;
import seshop.com.sds.seshop.main.ShopMain;

//상품 목록 페이지
public class ProductList extends Page {
	public JTable table;
	JScrollPane scroll;
	JPanel p_south;
	ProductTableModel model;

	public ProductList(ShopMain shopMain) {
		super(Color.RED);
		this.shopmain = shopMain;

		// 컨테이너 올리기
		container = new JPanel();
		container.setPreferredSize(new Dimension(800, 700));
		container.setBackground(Color.YELLOW);
		container.setLayout(new BorderLayout()); // 원래 FlowLayout던 것을 BorderLayout 교체

		// 생성
		table = new JTable(model = new ProductTableModel());
		scroll = new JScrollPane(table);
		p_south = new JPanel();

		// 스타일
		p_south.setPreferredSize(new Dimension(800, 250));
		p_south.setBackground(Color.CYAN);

		// 조립
		container.add(scroll); // 센터에 부착됨
		container.add(p_south, BorderLayout.SOUTH); // south 에 부착

		add(container);
	}

	// 상품 가져오기
	public void getProductList() {
		PreparedStatement pstmt = null; // 쿼리실행 객체
		ResultSet rs = null; // 표를 표현한 객체

		String sql = "select * from product order by product_idx asc"; // 오름차순

		try {
			pstmt = shopmain.con.prepareStatement(sql); // 쿼리 실행 객체 생성
			rs = pstmt.executeQuery(); // 쿼리실행 후 결과 받기

			// 기존의 컨트롤러가 보유한 list를 싸악~~비우고 채우자
			model.list.removeAll(model.list);

			while (rs.next()) { // next()는 커서를 전진했을때 값이 있다면 true를 반환
				String[] record = new String[6];
				record[0] = Integer.toString(rs.getInt("product_idx"));
				record[1] = rs.getString("product_name");
				record[2] = Integer.toString(rs.getInt("price"));
				record[3] = rs.getString("brand");
				record[4] = rs.getString("filename");
				record[5] = Integer.toString(rs.getInt("subcategory_idx"));

				// 완성된 하나의 배열을 컨트롤러가 보유한 list 에 추가하자
				model.list.add(record);
			}

			System.out.println("컨트롤러에 현재까지 채워진 레코드 수는 " + model.list.size());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}