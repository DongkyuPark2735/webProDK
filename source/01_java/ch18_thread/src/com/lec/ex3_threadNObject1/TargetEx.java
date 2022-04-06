package com.lec.ex3_threadNObject1;

public class TargetEx implements Runnable {// Runnable로 구현받은 타겟
	private int num = 0; // thread 아님

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

	private synchronized void out() { //메서드 단위로 싱크로나이즈 가능 
		if (Thread.currentThread().getName().equals("A")) {// "A"스레드일 경우
			System.out.println("~~~~~A스레드 수행중~~~~~~~~");
			num++;
		}
		System.out.println(Thread.currentThread().getName() + "의 num =" + num);
	}

}
