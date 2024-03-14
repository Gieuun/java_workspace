package seshop.com.sds.seshop.product;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import seshop.com.sds.seshop.lib.FileManager;
import seshop.com.sds.seshop.main.Page;
import seshop.com.sds.seshop.main.ShopMain;

//상품 등록 페이지
public class ProductRegist extends Page {
	JLabel la_top, la_sub, la_product_name, la_price, la_brand, la_image, la_download, la_preview;
	JComboBox b_top, b_sub; // 상 하위 선탣상자
	JTextField t_product_name, t_price, t_brand, t_url;
	JProgressBar bar; // 다운로드 현황
	JPanel p_preview; // 이미지 미리보기
	JButton bt_regist, bt_list, bt_collect; // 상품 등록, 목록 버튼

	// 콤보박스가 디자인에 초첨을 맞춰놓은 컴포넌트 이기 때문에 ,실제 데이터를 담을 수 없다
	// 따라서 코보박스의 각 아이템의 index와 위치가 일치하는 배열과 같은 존재를 하자
	// ArrayList
	ArrayList<Integer> topIdxList = new ArrayList<Integer>();
	
	Thread thread;// 다운로드 프로그레스 바를 제어할 쓰레드
	
	public ProductRegist(ShopMain shopmain) {
		super(Color.CYAN);
		this.shopmain = shopmain;

		// 컨테이너 크기 조정 및 색상 부여
		container = new JPanel();
		container.setPreferredSize(new Dimension(600, 700));
		container.setBackground(Color.LIGHT_GRAY);

		// 생성
		la_top = new JLabel("상위 카테고리");
		la_sub = new JLabel("하위 카테고리");
		la_product_name = new JLabel("제품명");
		la_price = new JLabel("가격");
		la_brand = new JLabel("브랜드");
		la_image = new JLabel("수집 url");
		la_download = new JLabel("다운로드 현황");
		la_preview = new JLabel("미리보기");

		b_top = new JComboBox();
		b_sub = new JComboBox();

		t_product_name = new JTextField();
		t_price = new JTextField("숫자만 넣으세요");
		t_brand = new JTextField();
		t_url = new JTextField();

		bt_collect = new JButton("수집 등록");
		bt_regist = new JButton("상품 추가");
		bt_list = new JButton("상품 목록");

		bar = new JProgressBar();
		p_preview = new JPanel();
		
		//쓰레드 생성
		
		// 스타일
		Dimension d = new Dimension(280, 35);

		la_top.setPreferredSize(d);
		b_top.setPreferredSize(d);

		la_sub.setPreferredSize(d);
		b_sub.setPreferredSize(d);

		la_product_name.setPreferredSize(d);
		t_product_name.setPreferredSize(d);

		la_price.setPreferredSize(d);
		t_price.setPreferredSize(d);

		la_brand.setPreferredSize(d);
		t_brand.setPreferredSize(d);

		la_image.setPreferredSize(d);
		t_url.setPreferredSize(new Dimension(188, 30));

		la_download.setPreferredSize(d);
		bar.setPreferredSize(d);

		la_preview.setPreferredSize(d);
		p_preview.setPreferredSize(new Dimension(280, 280));

		// 조립

		container.add(la_top);
		container.add(b_top);
		container.add(la_sub);
		container.add(b_sub);
		container.add(la_product_name);
		container.add(t_product_name);
		container.add(la_price);
		container.add(t_price);
		container.add(la_brand);
		container.add(t_brand);
		container.add(la_image);
		container.add(t_url);
		container.add(bt_collect);
		container.add(la_download);
		container.add(bar);
		container.add(la_preview);
		container.add(p_preview);
		container.add(bt_regist);
		container.add(bt_list);

		add(container);

		getTopCategory(); // 최상위 카테고리 데이터 불러오기

		// 상위 카테고리에 리스너 연결
		b_top.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) { // html의 onChage 와 동일

				if (e.getStateChange() == e.SELECTED) {
					int index = b_top.getSelectedIndex(); // 현재 콤보박스의 아이템 중 몇번째 칸을 선택했는지 반환
					System.out.println(index + " 번째 칸 선택했어");

					// 원칙은 get() 을 통해 얻어진 객체가 Integer 이지만, 개발자가 int 형으로
					// 대입이 가능한 현상을 unBoxing 이라 한다..이것 또한 편의성때문에 지원한다..

					if (index > 0) { // 0번째는 이미 안내 문구가 들어있으므로, 0번째 보다 큰 애들만 반응하자
						int topcategory_idx = topIdxList.get(index - 1); // 안내문구로 늘어난 인덱스 수 맞추기
						System.out.println("부모의 주민번호는 " + topcategory_idx);

						getSubCategory(topcategory_idx); // 서브 카테고리 목록 가져오기
					}
				}
			}
		});

		// 수집 버튼에 리스너 연결
		bt_collect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 소모품으로써 쓰레드 한개를 생성함
				Thread thread = new Thread() {
					//개발자는 쓰레드로 실행시키고픈 로직을 run()에 작성해 놓으면
					//jvm이 알아서 호출 해준다..하지만 그러기 위해서는 생성된 쓰레드를
					//start() 메서드로 Runnable 영역으로 밀어 넣어야 한다
					@Override
					public void run() {
						downLoadFromURL();
					}
				};
				thread.start();
				
			}
		});
	}

	// 인터넷상의 이미지 주소를 이용하여, 나의 하드디스크에 그 이미지를 저장하자(수집)
	// 웹서버로부터 정적 자원을 가져오려면, HTTP 프로토콜을 사용해야 한다..
	// javaSE에서는 HttpURLConnection 객체가 웹상의 요청을 시도할 수 있는 객체로 지원됨.
	// 즉 웹브라우저의 요청 행위를 따라해보자..이 실습을 위해 오전의 톰켓의 이미지를 다운로드 해보자
	public void downLoadFromURL() {
		URLConnection urlCon = null;
		HttpURLConnection httpCon = null; // 웹 상의 요청을 시도하고 응답을 가져올 수 있는 객체
											// 즉 웹브라우저의 역할을 일 부 수행할 수 있는 객체
		InputStream is = null; // finally에서 닫아야 하므로 try문 밖에 선언
		FileOutputStream fos = null; // 파일을 대상으로 한 바이트 기반출력 스트림

		try {
			URL url = new URL(t_url.getText());
			urlCon = url.openConnection(); // 이 시점에 고양이가 반응을 할까?
			httpCon = (HttpURLConnection) urlCon; // 부모자료형에서 자식자료형으로 down Casting

			int total = httpCon.getContentLength(); // 정적 자원의 바이트 용략
			System.out.println("이미지 크기는 " + total + "bytes");

			// 웹서버에 있는 정적 자원에 대해 스트림을 꽂아버리자!!!
			is = httpCon.getInputStream();

			// 읽어들인 데이터를 출력시킬 파일 출력스트림 생성
			long time = System.currentTimeMillis();
			String ext = FileManager.getExt(t_url.getText());
			String myName = time + "." + ext;

			fos = new FileOutputStream("C:/Users/gieun/SeShop/" + myName);

			int data = -1;
			int count = 0; // 몇번 읽어 들이고 있는지 체크하기 위한 카운터

			while (true) {
				data = is.read(); // 스트림으로부터 1 byte 읽어오기
				if (data == -1)
					break; // 파일의 끝을 만나면 루프 중단
				// System.out.println(data);
				count++; //읽을 때마다 증가
				float percent = (count / (float) total) * 100; //총용량 중, 몇 번째까지 읽었는지 백분율
				System.out.println((int)percent);
				
				//너무 빨라서 그래픽 갱신이 눈에 보이지도 못함, 쓰레드로 속도 조절
				bar.setValue((int)percent);
				
				fos.write(data); // 1byte 내려쓰기
				
			}
			JOptionPane.showMessageDialog(this, "이미지 수집완료");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void getTopCategory() {
		// 콤보박스에 최상위 카테고리를 넣어주기
		PreparedStatement pstmt = null; // 닫으려고..try문 밖에 선언
		ResultSet rs = null; // 닫으려고..try문 밖에 선언

		try {
			pstmt = shopmain.con.prepareStatement("select * from topcategory"); // 쿼리 준비 객체 생성

			// 실행 : DmL-executeUpdate(), select-executeQuery() 실행 후 ResultSet 반환
			rs = pstmt.executeQuery(); // select 문 전송~~후 결과 표 받기

			// 0번째 요소에 안내문구 채우기
			b_top.addItem("카테고리 선택▼");

			while (rs.next()) { // next() 메서드가 참을 반환하는 동안, 커서 전진
				b_top.addItem(rs.getString("topname"));

				// 상위 카테고리의 idx도 담아두자
				topIdxList.add(rs.getInt("topcategory_idx"));
				// 원칙상 int 기본 자료형이므로, 즉 객체자료형이 아니므로
				// ArrayList에 직접 담을 수 없어야 하지만, sun 편의상
				// 컬렉션 객체에 기본 자료형을 담을 자동으로 Wrapper 형태로
				// 변환해주는 현상을 지원.. 기본자료형을 boxing 처리라 한다
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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

	public void getSubCategory(int topcategory_idx) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// String sql="select * subcategory where topcategory=내가선택한top의 idx값";
		String sql = "select * from subcategory where topcategory_idx=" + topcategory_idx;
		System.out.println(sql); // 쿼리문 검증

		try {
			pstmt = shopmain.con.prepareStatement(sql); // 쿼리 준비

			// 쿼리실행
			rs = pstmt.executeQuery(); // 실행 후 표 받기

			// 반복문 돌기전 기존의 아이템이 있다면 모두 삭제 처리
			b_sub.removeAllItems(); // 모든 아이템 지우기

			// 반복문으로 next()해 가면서 두번째 콤보 박스에 채우자
			while (rs.next()) {
				b_sub.addItem(rs.getString("subname"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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