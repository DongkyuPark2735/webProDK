package com.lec.ex4_threadNObjectN;

public class TargetExTestMain {

	public static void main(String[] args) {
		TargetEx targetObject1 = new TargetEx();
		TargetEx targetObject2 = new TargetEx();//��ü �ΰ� ������

		Thread threadA = new Thread(targetObject1, "A");
		//n���� �����忡n���� Ÿ���� �Ϸ��� ��ӹ޾Ƽ� �����ִ°��� �����ϳ�.
		Thread threadB = new Thread(targetObject2, "B");//�������� �Է¹޴� Ÿ���� ���δٸ��� �ָ�ȴ� 

		threadA.start(); // �����尡 Ÿ���� �����ϸ� Ÿ�پ��� �ʵ�� �޼ҵ嵵 �����Ǳ⶧����
		threadB.start(); // B�� ������ ���鼭 A�� �����ϰ� ��Ű�� ������ �����ȴ�.
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("target1�� num :" + targetObject1.getNum());
		System.out.println("target2�� num :" + targetObject2.getNum());
		System.out.println("main �Լ� ��");
	}
}
