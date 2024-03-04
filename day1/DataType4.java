class DataType4{

	public static void mian(String[] args){
		char c ='강'; //2byte 용량임, 전세계의 모든 문자를 다 수용할 수 있음
							//만일 1byte 였다면, 영문자와 특수 문자 밖에 수용 못함

		//char 형이 비록, 2byte(2^16 가지)를 표현할 수 있다 할지라도.
		//결국 유니코드를 담기 위한 즉 문자를 담기 위한 목적이므로, 음수를 지원하지 않음
		//따라서 산수 연산 목적에 데이터를 사용하는데이는 한계가 있다.
		//char a = 65;
			
			byte b =13;
			int x =67;
			x=b;		//가능 byte는 1, int형은 4 바이트 이기 때문에, 작은 자료형을 큰 자료형에 대입할 수 있다.

			short s=26;

			b=s; //2byte

			//우측의 데이터를 좌측의 데이터로 변환하고자 할때, 만일 손실이 예상되면
			//프로그램은 자동으로 형변환을 하지 않고, 개발자에게 컴파일 에러를 일으켜 물어본다
			//이때 손실을 감수하더라도 진행을  하려면, 강제 형변환 연산자인 
			//(cast) 연산자를 사용한다
			b=(byte)s;

			//byte < short < int < long

			short s=123;
			byte b=7;
			int x=78;
			
			//우측의 b는 1byte이고, 이 b를 좌측 s에 대입하려 할때
			//컴파일러는 연산을 수행하기저 전에, 양측의 컴파일러는 동일하게 맞추려 할 것이다.
			//이때 우측의 b가 좌측의 s보다 작은 자료형이므로, b-->s로 변환 한다고 하여 
			//손실이 발생하지 않기 때문에, 개발자에게 물어보지 않고 자동으로 b를 shor로 변환한다
			//이러한 현상을 가르켜 자동형변환이라 한다.
			s=b;

			b=(byte)x;

	}
}