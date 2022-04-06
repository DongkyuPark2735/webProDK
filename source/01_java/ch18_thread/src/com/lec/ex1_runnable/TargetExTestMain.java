package com.lec.ex1_runnable;

public class TargetExTestMain {

	public static void main(String[] args) { // main treadA treadB
		TargetEx01 target1 = new TargetEx01();
		TargetEx02 target2 = new TargetEx02();//하나의 타겟을 여러 스레드가 사용 할수있음 
											//타겟은 인터페이스 구현한것
//		Runnable target3 = new TargetEx01();

		// A라는 이름의 tread객체 생성 target1.run() 수행
		Thread threadA = new Thread(target1, "A");  // 동시수행하려면 반드시 스레드 객체생성
													// 스레드 이름 설정안할땐 자동으로 생성됨
		// B라는 이름의 tread객체 생성 target2.run() 수행
		Thread threadB = new Thread(target2, "B"); 
//		Thread threadB = new Thread(target1, "B"); // 동시수행하려면 반드시 스레드 객체생성

		threadA.start();
		threadB.start();// 실행가능한 상태로 내보낸다.
		for (int i = 0; i < 10; i++) {
			System.out.println("나는 main :" + Thread.currentThread().getName() + i);
			// 현재 실행중인 프로세스 스레드 이름
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}

	}
}
