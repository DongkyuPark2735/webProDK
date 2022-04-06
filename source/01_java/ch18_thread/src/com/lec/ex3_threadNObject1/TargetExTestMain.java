package com.lec.ex3_threadNObject1;

public class TargetExTestMain {

	public static void main(String[] args) {
		TargetEx targetObject = new TargetEx();
		
		Thread threadA = new Thread(targetObject, "A");
		Thread threadB = new Thread(targetObject, "B");
		
		threadA.start();	//스레드가 타겟을 공유하면 타겟안의 필드와 메소드도 공유되기때문에
		threadB.start();	//B의 로직이 돌면서 A만 증가하게 시키는 변수도 공유된다.  
		
		System.out.println("main 함수 끝");
	}
}
