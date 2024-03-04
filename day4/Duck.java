/*
새의 자식 중 오리를 성의 한다
*/

class  Duck extends Bird
{
	//보편적 특징은 부모 클래스에서 이미 보유 중
	//여기서는 오리만이 갖는 특성만을 표현하는게
	//효율적

	public Duck(){
		//상곡관계에서
		//super() 디폴트 생성자를 자동 호출
		//부모가 매개변수 있는 생성자만 가지고 있을때
		//컴파일러에 의한 자동호출에 의지라지 말고
		//개발자가 직접 나서야한다.
		super("red");
		System.out.print("난 오리\n");
	}

	public void quack(){
		System.out.print("꽥");
	}
}
