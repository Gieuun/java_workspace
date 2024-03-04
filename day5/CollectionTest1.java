//현재 클래스와는 다른 위치에 있는 외부 클래스를 사용하려면 
//해당 외부 클래스의 위치를 등록해야 한다.
import java.util.ArrayList; //java 패키지 밑 util 패키지 밑에 위치

class  CollectionTest1 {
/*
[자바 배열의 특징]
1.한 종류의 데이터만 담을 수 있다. ex) int[] arr= new int[5]
2.크기가 고정돼 있다, 동적 변경 불가능
3.모든 배열은 객체로 본다. 따라서 배열수명을 출력하는 주소값이 출력
	ex) char[] arr2=new char[2];
			System.out.println(arr2); // 벼열의 힙에서 주소값 출력

[수업주제]
배열의 특징 중, 동적변경이 불가능한 것은 프로그램에서 한계점을 유발한다.
ex) 총알 발사할때 마다 배열에 담는 것은 자바에서 불가능
		Bullet[] bulletArray = new Bullet[크기고정];<--

[해결책] 
자바의 lib중 collection framework 이라 불리는 라이브러리(class를 모아놓은 집합)를 사용해보자

■collection framework
- 객체를 모아서 처리할때 유용한 기능을 지원하는 자바 라이브러리 (패키지로 지원) java.util 패키지(디렉토리)

■컬렉션을 이루는 객체들의 유형
	컬렉션 프레임웍의 관심의 대상은 오직 object다. 
	따라서 기본 자료형은 프레임웍 라이브러리 대상이 아니다.
	오직 객체만을 대상으로 한다.

	1)순서가 있는 유형(List 형)
	2)순서가 없는 유형(Set 형)
	3)key-value로 이루어진 유형(Map 형)
*/
	public static void main(String[] args){
		//컬렉션 프레임웍의 순서있는 객체들의 집합을 제어할 수 있는 객체인
		//List의 자식인 ArrayList를 사용해본다
		//List는 우리가 사용해왔던 배열과 거의 같다
		//단 차이점은 
		//1)크기의 동적변경 가능 (js의 배열과 동일한 효과)
		//2)오직 객체만을 담을 수 있다.
		//3)객체들을 섞어서 담을 수도 있다.
		ArrayList list = new ArrayList(); //인스턴스 생성
		
		list.add("apple");
		list.add("바나나");
		list.add(1);

		System.out.print("리스트의 사이즈는" + list.size());
	}
}
