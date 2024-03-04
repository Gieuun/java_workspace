package flower; //이클래스의 컴파일파일은 bin 밑에 flower로 존재할것임

public class Rose{
	String color = "red"; //default 접근 제한자 적용(같은 페키지 내의 클래스만 허용)
									//주의) 상속관계의 자식이 다른 페키지에 있을 경우 접근 불가
	private String name = "장미"; //현재 클래스내의 메스드만 접근가능


	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}

}

	
