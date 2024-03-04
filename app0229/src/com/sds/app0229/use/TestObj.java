/*
자바에서는 개발자가 아무런 상속관계를 명시하지 않아도,
기본적으로 무조건 상속되는 객체가 있는데, 이 최상위 객체를 Object 클래스
라 하며 개발자가 명시하지 않는다

Object를 import 하지 않아도, 에러가 발생하지 않는 이유는
java.lang 패키지는 언어의 기본적인 객체들이 들어있기 때문에 자동 import 되어있음
String, Object,...
*/
package com.sds.app0299.use;

class TestObj { 
	//TestObj is a Object
	public static void main(String[] args){
		/*
		아래의 3레퍼런스 변수 모드 자식인 TestObj의 인스턴스 주소를 가리킨다.
		그렇다면 상속관계에서 부모의 인스턴스 주소값을 가져올 방법은 없다
		왜? 인스턴스가 올라간적이 없기 때문에, 즉 자식의 인스턴스내에 부모의 재산이 들어간 상태
	
		*/
		
		TestObj to = new TestObj(); //	A) 접근 범위 자식이 보유한 전부다(자식 인스턴스 + 부모 인스턴스)

		Object obj = new TestOBj(); // B) 자식의 인스터는 내의 부모 인스턴스
													// 예외) 만일 자식이 오버라이드한 메서드가 있다면
													//아무리 obj.부모메스드() --> 자동으로 자식메서드 호출
		TestObj re = (TestObj)obj; //C)

	}
}
