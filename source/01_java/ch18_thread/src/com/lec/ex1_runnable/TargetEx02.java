package com.lec.ex1_runnable;

// "반갑습니다. 10번" 하는 target 
public class TargetEx02 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "번째, 반갑습니다.");
			try {
				Thread.sleep(500);// 현재 스레드(작업)를 0.5초동안 대기상태로
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
