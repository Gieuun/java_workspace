/*
모든 새들의 최상위 객체인 Bird 정의한다
*/

class Bird 
{
	/*최상위 객체일 수록 보편성이 적용되어야 한다*/

	boolean hasWing = true; //모든 새는 날개가 있으므로
	String color;
	
	public Bird(String color){
		this.color=color;
		System.out.print("난 부모 새\n");
	}
}
