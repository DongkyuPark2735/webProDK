package com.lec.ex2_thread;

//Thread t1 = new ThreadEx01();
//Thread t1 = new ThreadEx01("A");
public class TargetEx01 extends Thread {// 스레드 상속 일반클래스임

	public TargetEx01() {
	}

	public TargetEx01(String name) {
		super(name);
	}

	@Override // 강제오버라이드 하지않은 내부에 run있음
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("안녕하세요 -" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
