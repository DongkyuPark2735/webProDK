package com.lec.ex3_threadNObject1;

public class TargetExTestMain {

	public static void main(String[] args) {
		TargetEx targetObject = new TargetEx();
		
		Thread threadA = new Thread(targetObject, "A");
		Thread threadB = new Thread(targetObject, "B");
		
		threadA.start();	//�����尡 Ÿ���� �����ϸ� Ÿ�پ��� �ʵ�� �޼ҵ嵵 �����Ǳ⶧����
		threadB.start();	//B�� ������ ���鼭 A�� �����ϰ� ��Ű�� ������ �����ȴ�.  
		
		System.out.println("main �Լ� ��");
	}
}
