package com.lec.ex2_thread;

public class TestMain {

	public static void main(String[] args) {

		Thread t1A = new TargetEx01();//Thread.currentThread().getName()������ �̸� 
		Thread t2B = new TargetEx02();
		
//		t2B.setName("B"); //t2B��ü�� ������ �̸� ����
		
		t1A.start();
		t2B.start();
//		
//		Thread tread = new Thread();
		
//		t1A.run();
//		t2B.run();
//		
		System.out.println(Thread.currentThread().getName());
		System.out.println("main �Լ���");
	}

}
