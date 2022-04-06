package com.lec.ex1_runnable;

// "안녕하세요 10번" 하는 target or task
public class TargetEx01 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("안녕하세요 - " + i);
			try {
				Thread.sleep(500);//현재 스레드(작업)를 0.5초동안 대기상태로  
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
}
