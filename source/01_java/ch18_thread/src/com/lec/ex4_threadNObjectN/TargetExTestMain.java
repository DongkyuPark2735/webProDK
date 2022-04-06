package com.lec.ex4_threadNObjectN;

public class TargetExTestMain {

	public static void main(String[] args) {
		TargetEx targetObject1 = new TargetEx();
		TargetEx targetObject2 = new TargetEx();//객체 두개 생성ㅇ

		Thread threadA = new Thread(targetObject1, "A");
		//n개의 스레드에n개의 타겟을 하려면 상속받아서 직접넣는것을 많이하낟.
		Thread threadB = new Thread(targetObject2, "B");//스레드의 입력받는 타겟을 서로다르게 주면된다 

		threadA.start(); // 스레드가 타겟을 공유하면 타겟안의 필드와 메소드도 공유되기때문에
		threadB.start(); // B의 로직이 돌면서 A만 증가하게 시키는 변수도 공유된다.
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("target1의 num :" + targetObject1.getNum());
		System.out.println("target2의 num :" + targetObject2.getNum());
		System.out.println("main 함수 끝");
	}
}
