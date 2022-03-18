package com.lec.ex4_access;

import com.lec.ex3_access.AccessTest;

public class AccessTestMain {
//실행하기전에 힙영역으로
	//힙영역에 클래스 파일이 올라감 
	//static은 힙영역에서 바로 실행 가능함 
	//static은 힙영역에서 해당 클래스에 생성된 인스턴트끼리 변수나 매서드가 공유됨
	//static힙영역에서 사라지지않고 메모리를 차지함 과부하가 걸릴수있음?
	
	
    //오른쪽 가비지 영역은 실행후 종료되면 자바에서 삭제됨
	//스레드?
	//
	public static void main(String[] args) {
//		com.lec.ex3_access.AccessTest obj = new com.lec.ex3_access.AccessTest();
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
//		System.out.println(obj.defaultMember);
//		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
//		obj.privateMethod();
//		obj.defaultMethod();
//		obj.protectedMethod();
		obj.publicMethod();
	}

}
