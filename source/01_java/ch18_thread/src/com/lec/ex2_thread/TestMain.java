package com.lec.ex2_thread;

public class TestMain {

	public static void main(String[] args) {

		Thread t1A = new TargetEx01();//Thread.currentThread().getName()에서의 이름 
		Thread t2B = new TargetEx02();
		
//		t2B.setName("B"); //t2B객체의 스레드 이름 생성
		
		t1A.start();
		t2B.start();
//		
//		Thread tread = new Thread();
		
//		t1A.run();
//		t2B.run();
//		
		System.out.println(Thread.currentThread().getName());
		System.out.println("main 함수끝");
	}

}
