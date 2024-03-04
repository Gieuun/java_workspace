//실행을 위한 클래스 
class UseHuman {
	public static void main(String[] args) {
		//아시안과 서양인은 실질적으로 메서드를 1개씩만 보유
		//하지만 상속을 통해 부모의 재산을 접근할 수 있으므로,
		//많은 속성과 메서드를 보유한 결과다 돼버림
		
		Asian as = new Asian();
		as.farmRice();//보유 메서드
		as.eat();//상속 메서드
		as.think();//상속 메서드
	}
}
