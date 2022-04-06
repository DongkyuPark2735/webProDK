package com.lec.ex4_threadNObjectN;

public class ThreadExTestMain {

	public static void main(String[] args) {
		ThreadEx threadA = new ThreadEx("A");
//		Thread threadA = new ThreadEx("A");//��ü�� Ÿ�� ThreadEx ������ Ÿ�� Thread
		ThreadEx threadB = new ThreadEx("B");
		
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A�� num :"+ threadA.getNum());
		System.out.println("B�� num :"+ threadB.getNum());
		
	}
}
