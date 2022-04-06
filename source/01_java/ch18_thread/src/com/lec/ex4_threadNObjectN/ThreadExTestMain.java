package com.lec.ex4_threadNObjectN;

public class ThreadExTestMain {

	public static void main(String[] args) {
		ThreadEx threadA = new ThreadEx("A");
//		Thread threadA = new ThreadEx("A");//객체의 타입 ThreadEx 변수의 타입 Thread
		ThreadEx threadB = new ThreadEx("B");
		
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A의 num :"+ threadA.getNum());
		System.out.println("B의 num :"+ threadB.getNum());
		
	}
}
