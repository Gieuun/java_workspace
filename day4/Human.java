/*
인류의 보편적 특징을 정의하는 클래스
즉 모든 인종의 최상위 객체
*/

class Human {
	int eyenum=2;
	int legs=2;

	public human(int eye, int legs){
		this.eyenum=eye;
		this.legs=legs;
	}

	public void eat(){
		System.out.print("살려고 먹어요\n");
	}

	public void think(){
		System.out.print("지성이 있어요\n");
	}

}