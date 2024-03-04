/*
현실의 자동차를 정의하기 위한 클래스가 아니라, car.java에 자체적으로
실행부가 들어있지 않기 때문에ㅡ 현재 이 클래스에서 실행을 담당하기위해 작성
*/

class UseCar {
	public static void main(String[] args) {

		Car c = new Car(); //거푸집으로 부터 인스턴스 1개를 생성하여. c라는 변수로 보관
		
		int r = c.getRandom();
		
		System.out.println(r);
	}
}
