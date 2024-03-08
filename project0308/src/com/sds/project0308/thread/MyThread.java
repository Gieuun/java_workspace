package com.sds.project0308.thread;


//하나의 프로세스 내에서 독립적으로 실행시키고 싶은 단위인
//쓰레드를 나만의 로직으로 재정의 해보자
//쓰레드란 하나의 프로세스 내에서 또 다른 작은 다위의 프로세스
public class MyThread extends Thread{
	
	int count;
	String msg; //출력 대상 문자열
	
	 public MyThread(String msg) {
		this.msg = msg;
	}

	//개발자는 독립적으로 실행시키고 싶은 로직이 있다면
	//run() 메서드에 작성해야 한다, 개발자가 정의해놓으면,
	//jvm이 알아서 run 메서드를 호출해준다
	public void run() {
		while(true) {
			count++;
			System.out.println(msg);
			//System.out.println(count);
			
			try {
				Thread.sleep(10);//1초각 non-runnable에 있다가 와라 (1초 뒤에 자동 복귀)
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
