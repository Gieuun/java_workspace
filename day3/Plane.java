class Plane {
	String line="kor 747";
	String brand="대한한공";
	int seat=120;
	int height = 0;

//자바에서 코드의 내용에 큰 차이가 없다면, 굳이 메서드명을 지어내려고 고생할 필요가 없다
//즉 메서드 명은 직관성이 부여되기 때문에 , 기존에  힘들게 명명해 놓은 메서드 명을 피하기 위해
//로직에 큰 차이가 없음에도 불구하고, 새로운 메서드명을 지아낼 필요가 없다.
//즉, 자바에서는 비슷한로직일 경우 메서드명을 유지할 수 있는 메서드 정읩 기법을 지원해준다
//메서드명은 동일 하되, 전혀 구분이 불가능하면 안도ㅣ므로, 매개변수의 자료형과 갯수를 구분하는 기법
	public void fly(){
		height=300;
	}

	public void fly(int height){
		this.height=height;
	}

	public void fly(int height, String line){
	height = 500;
	}
}
