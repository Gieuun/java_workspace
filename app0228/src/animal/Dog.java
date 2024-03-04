/*
[패키지를 사용하는 이유]

1).java와 .class파일을 함께 두지 않고 분리시켜 개발
2)관련성 있는 클래스들은 같은 디렉토리끼리 묶어서 개발
3)클래스명 중복 문제를 피해갈 수 있다.
*/

package animal;

//패키지에 담겨진 클래스를 외부에서 사용하게 하려면 반드시 
public class Dog {
	private String name="뽀미";
	private age=3;

	//변수를 퍼블릭으로 해도 되지만, 중요한 정보일 경우가 있으므로
	//퍼블릭으로 놓는 개발 방식은 거의 찾아 볼 수 없다.
	//따라서 소중한 변수를 private 외부 접근을 막고, 오직 허용된 메서드를
	//통해 변수값을 제어할 수 있도록 하는 클래스 정의 기법을 가르켜
	//캡슐화(은닉화) - encapsulation

	public String getName(){ //getter reading
		return name;
	}
publvi void setName(String name){ //setter wrighting
	this.name=name;
}

}
