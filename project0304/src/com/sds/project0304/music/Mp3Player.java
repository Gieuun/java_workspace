package com.sds.project0304.music;

//들고 다닐 수 있는 포터블한 플레이어 정의
//개발자: A라는 사원
//이 사원에게 구현을 강제시켜보자
public class Mp3Player extends MusicPlayer  implements Board, ZetFly{
															/*Board 자체를 상속 받는게 아니라, 기능을 상속 받게된다
															 * 클래스간 다중 상속을 피할 수 있다(is a 관계)*/
	
	String brand;
	String produnctName;
	
	public void showEqualizer(){ //이퀄라이저 시각화 시키기
		
	}
		
	// @(어노테이션) = 주석이긴 하나, 프로그래밍 실행시 사용,해석되는 주석
	//java 5 버전 부터 지원시작, 프로그래밍 언어에서 무언가를 표시할 때 사용
	//Spring에서 압도적으로 많이 사용
	@Override
	public void playerMp3File() {
		System.out.println("mp3파일을 재상합니다.");
	}
	@Override
	public void setVolume() {
		System.out.println("볼륨을 조절합니다.");
		
	}
	
	//Board의 기능을 나의 상황에 맞게 오버라이딩한다
	@Override
	public void roll() {
		System.out.println("이 음향기기를 타고 다녀요");
	}
	
	//ZetFly 인터페이스
	@Override
	public void fly() {
		System.out.println("타고 날아요");
	}
}
