package com.sds.project0308.thread;

/* ■ 멀티테스킹이란?
 *		- OS의 다중 프로세스 실행 기법 
 *			CPU(두뇌)가 하나인 경우, 동시에 여러 프로그램을 가동하는 것은 불가능하기 때문에,
 *			시간을 분할하여(시 분할, timesharing ) 빠른 동작으로 여러 프로세스를 실행하는 기법
 *			-> 사용자는 동시 실행으로 느끼게 된다
 *			
 *			OS 차원에서 멀티태스킹 기법을 모방하여, 하나의 자바 프로세스 내에서도 비슷한
 *			원리를 적용한 멀티쓰레딩 기법이 지원된다
 * 
 * ■ 쓰레드란?
 * 		- 하나의 프로세스 내에서 독립적으로 실행될 수 있는 또 하나의 세부 실행단위 * 
 * */

//카운터 프로그램
public class ThreadTest {
	MyThread thread;
	MyThread thread2;
	
	public ThreadTest() {
		// 쓰레드 탄생
		thread = new MyThread("★");
		thread2 = new MyThread("☆");
		
		// 개발자가 쓰레드의 메서드를 직접호출하게 되면
		// jvm에 의한 관리 방법이 아니기 때문에, 시분할 방법등을 사용할 수 없다.
		// 일반 메서드 호출이 된다 --> jvm에게 맡겨야한다
		thread.start();
		
		thread2.start();
	}

	public static void main(String[] args) {
		new ThreadTest();
	}

}
