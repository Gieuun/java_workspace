class ArrayTest1 {

	public static void main(String[] args) {
		//자바는 일반적인 프로그래밍 언어(c, c#...)와 마찬가지로
		//배열 선언시 반드시 그 크기를 명시해야 한다
		//즉 js와는 틀리다...자동으로 늘어나거나 하지 못함..고정적임
		
		//자바에서 배열은 일반적인 변수 선언과 마찬가지로 반드시 자료형을 명시해야함

		int[] arr = new int[4]; //크기가 4인 배열을 생성한다
		System.out.println("배열의 크기는?"+arr.length);

		//모든 배열은 객체로 처리됨 따라서 배열 변수 자체를 출력하면 주소값이 출력
		//결론: "자바에서 배열은 객체이다"
		System.out.println(arr);

		/*자바의 모든 자료형으로 배열을 생성할 수 있다.
		자바의 언어에서 자료형은 기본자료형 + 객체 자료형
		*/

		boolean[] arr2 = new boolean[3]; //논리값
		char[] arr3 = new char[5];			//문자형

		//객체 자료형으로 배열 선언하기
		String[] arr4 = new String[3];
		arr4[0]="사과";
		arr4[1]="딸기";
		arr4[2]="바나나";

		for(int i=0; i<arr4.length; i++){
			System.out.println(arr4[i]);
		}
	
	//사용자가 정의한 자료형인 Dog형도 배열로 선언이 가능
	//Dog <-- 사용자 지정 객체 자료형이기 때문에

	Dog[] arr5 = new Dog[3];
	Dog d1 = new Dog("메리",3);
	Dog d2 = new Dog("뽀미",5);
	Dog d3 = new Dog("짱구",9);
	
	arr5[0]=d1;
	arr5[1]=d2;
	arr5[2]=d3;

	for(int i = 0; i<arr5.length; i++){
			System.out.println(arr5[i]);
		}
	}
}
