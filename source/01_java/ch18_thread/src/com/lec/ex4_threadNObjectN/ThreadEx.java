package com.lec.ex4_threadNObjectN;

//ThreadEx t1 = new ThreadEx()
//t1.setName("A);
public class ThreadEx extends Thread {
	private int num = 0;

	public ThreadEx(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {// "A"스레드일 경우
				System.out.println("~~~~~A스레드 수행중~~~~~~~~");
				num++;
			} // 같은 메소드를 호출해야 synchronized
			System.out.println(Thread.currentThread().getName() + "의 num =" + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

//	private synchronized void out() {//synchronized 이 함수를 쓸때는 다른  쓰레드 진입불가
//									// 함수 기반으로만 싱크로나이즈 가능
//									// 메서드화 해야함	
//		if (Thread.currentThread().getName().equals("A")) {// "A"스레드일 경우
//			System.out.println("~~~~~A스레드 수행중~~~~~~~~");
//			num++;
//		}//같은 메소드를 호출해야 synchronized 
//		System.out.println(Thread.currentThread().getName() + "의 num =" + num);
//	}
//
	public int getNum() {
		return num;
	}

}
