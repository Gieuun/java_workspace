package com.sds.project0312.select;

import java.util.ArrayList;

import javax.swing.JButton;

/*
 * 컬렉션 프레임웍에는 개발자가 특별한 제한을 가하지 않으면 객체들이 섞여 들어가는 것을 허용해준다
 * 만일 개발자가 이부분이 마음에 들지 않는다면, 사용하고자 하는 컬렉션 프레임웍 객체의 자료형형을
 *  특정 자료형으로 제한 할 수 있고, 이러한 제한 기법을 Generic Type 이라한다
 * */
public class CollectionTest {
	
	public static void main(String[] args) {
		/*
		 * Generic 사용 시 장점
		 * 1) 자료형을 섞이지 않게 안전 장치
		 * 2) 모든 컬렉션 프레임웍은 넣거나 뺄때 Object형으로 사용해야하지만
		 * 		제네릭을 사용하며 지정한 정확한 자료형으로만 넣거나 뺄 수 있으므로 형변환 과정이 불필요
		 * */
	
		ArrayList<String> list = new ArrayList<String>(null);
		
		//list.add(new JButton("")); -> 메서드에는 스트링만 넣을 수 있다는 컴파일 오류 구문이 출력된다		
		//컴파일 타임, 문법 검사 시점부터 제한을 가해준다 (안전장치)
		list.add("banana");
		
		String str = 	list.get(0);
		str.charAt(0);
	}
}
