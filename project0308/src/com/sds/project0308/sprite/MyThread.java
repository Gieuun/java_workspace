package com.sds.project0308.sprite;

//현재  프로그램내에서 독립적으로 실행될 수 있는 세부 실행단위인 쓰레드를 정의해본다
public class MyThread extends Thread {

	Animation ani; // 에니메이션의 변수에 접근하기 위한 변수

	public MyThread(Animation ani) {
		this.ani = ani; // Animation class의 레퍼런스 변수
	}

	// 독립적으로 실핼시키고 싶은 코드가 있을때 run()에 작성해야함
	public void run() {
		while (true) {
			// Animation class가 보유한 move() 호출
			ani.move();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
