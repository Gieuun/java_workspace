package seshop.com.sds.seshop.product;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import seshop.com.sds.seshop.main.Page;
import seshop.com.sds.seshop.main.ShopMain;

//상품 목록 페이지
public class ProductList extends Page {
	public JTable table;
	JScrollPane scroll;
	JPanel p_south, p_preview; // 상세 상품 이미지가 그려질 패널
	JLabel la_product_name, la_price, la_brand;
	ProductTableModel model;
	Image img;

	MouseListener mouse;

	String value = null;

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
		p_preview = new JPanel() {
			public void paint(Graphics g) {
				// 페인트통 색상 지정
				g.setColor(Color.yellow);
				g.fillRect(0, 0, 250, 200);
				g.drawImage(img, 0, 0, 350, 280, p_south);
			}
		};
		la_product_name = new JLabel("상품 나올곳");
		la_price = new JLabel("상품 가격");
		la_brand = new JLabel("상품 이름");

		// 스타일
		p_south.setPreferredSize(new Dimension(800, 250));
		p_south.setBackground(Color.CYAN);
		p_preview.setPreferredSize(new Dimension(350, 280));
		Dimension d = new Dimension(220, 20);
		la_product_name.setPreferredSize(d);
		la_price.setPreferredSize(d);
		la_brand.setPreferredSize(d);

		// 조립
		container.add(scroll); // 센터에 부착됨
		container.add(p_south, BorderLayout.SOUTH); // south 에 부착
		p_south.add(p_preview);
		p_south.add(la_product_name);
		p_south.add(la_price);
		p_south.add(la_brand);

		add(container);

		// JTable과 마우스 리스너 연결
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = table.getSelectedRow(); // 층수
				int col = table.getSelectedColumn(); // 호수

				// 유저가 어떤 곳을 눌러도 product_idx를 가져오기 위해서 col = 0
				value = (String) table.getValueAt(row, 0);

				System.out.println(row + "," + col + "의 값은" + value);

				getProductDetail(Integer.parseInt(value)); // 상품 상세 1건 가져오기
			}
		});
	}

	// 선택한 상품 정보를 1건 가져오기
	public void getProductDetail(int product_idx) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from product where product_idx=" + product_idx;
		System.out.println(sql); // 쿼리 검증

		try {
			pstmt = shopmain.con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // select 문 수행 후 결과 반환

			// rs의 값을 상세보기 패널에 반영하자
			rs.next(); // 커서 한칸전진
			String filename = "C:/Users/gieun/SeShop/" + rs.getString("filename");
			ImageIcon icon = new ImageIcon(filename);
			img = icon.getImage(); // 아이콘을 그림으로 변환
			p_preview.repaint(); // 패널에게 그림을 다시 그리도록 요청

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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

}