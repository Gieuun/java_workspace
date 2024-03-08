package com.sds.project0308.sprite;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

//개발자가 그림을 뺏어서 그리기 위해 JPanel을 상속받아 paint() 메서드를 재정의 해야한다.
public class MyPanel extends JPanel {
	//스프라이트 이미지는 배열로 선언
	int index = 0; //어떤 이미지를 보여줄지를 결정짓는 배열의 index
	
	Toolkit kit= Toolkit.getDefaultToolkit(); //이미지를 얻어 오기 위한 도구
	String[] path = {
			"D:/java_workspace/project0308/res/hero/image1.png",
			"D:/java_workspace/project0308/res/hero/image2.png",
			"D:/java_workspace/project0308/res/hero/image3.png",
			"D:/java_workspace/project0308/res/hero/image4.png",
			"D:/java_workspace/project0308/res/hero/image5.png",
			"D:/java_workspace/project0308/res/hero/image6.png",
			"D:/java_workspace/project0308/res/hero/image7.png",
			"D:/java_workspace/project0308/res/hero/image8.png",
			"D:/java_workspace/project0308/res/hero/image9.png",
			"D:/java_workspace/project0308/res/hero/image10.png",
			"D:/java_workspace/project0308/res/hero/image11.png",
			"D:/java_workspace/project0308/res/hero/image12.png",
			"D:/java_workspace/project0308/res/hero/image13.png",
			"D:/java_workspace/project0308/res/hero/image14.png",
			"D:/java_workspace/project0308/res/hero/image15.png",
			"D:/java_workspace/project0308/res/hero/image16.png",
			"D:/java_workspace/project0308/res/hero/image17.png",
			"D:/java_workspace/project0308/res/hero/image18.png"
			};
	Image[] imgArray = new Image[path.length]; //이미지가 들어갈 공간 확보
	
	public MyPanel() {
		for(int i=0; i<imgArray.length; i++) {
			imgArray[i]=kit.getImage(path[i]);		//이미지 생성
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.yellow); //그림에 사용될 페이튼 색상을 결정하는 메서드
		g.fillRect(0, 0, 500, 400); //채워진 사각형을 그리는 메서드
		
		g.drawImage(imgArray[index], 140, 80, 200, 213, this);

	}
}