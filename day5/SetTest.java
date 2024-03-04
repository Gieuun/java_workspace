/*
컬렉션 프렝미윅에서 지원하는 객체중, 순서 없는 객체들의 집합을 다루는 
Set을 알아보자

[특징]
1) 순서 없이 모여진다
2)중복을 허용하지 않는다(중복 데이터는 덮어씀)
3)오직 객체만을 담을 수 있다.(컬레션 프레임웍 객체의 공통 특징)
*/
import java.util.HashSet;

class SetTest {
	public static void main(String[] args) {
		HashSet set = new HashSet();

		set.add("BMW");
		sett.add("Audi");
		set.add("Benz");
		
		//모든 요소들을 반복문으로 출력 가능?
		Iterator it = set.iterator();

	}
}
