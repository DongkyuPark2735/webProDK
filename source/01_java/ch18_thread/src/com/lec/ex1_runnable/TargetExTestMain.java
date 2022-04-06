package com.lec.ex1_runnable;

public class TargetExTestMain {

	public static void main(String[] args) { // main treadA treadB
		TargetEx01 target1 = new TargetEx01();
		TargetEx02 target2 = new TargetEx02();//�ϳ��� Ÿ���� ���� �����尡 ��� �Ҽ����� 
											//Ÿ���� �������̽� �����Ѱ�
//		Runnable target3 = new TargetEx01();

		// A��� �̸��� tread��ü ���� target1.run() ����
		Thread threadA = new Thread(target1, "A");  // ���ü����Ϸ��� �ݵ�� ������ ��ü����
													// ������ �̸� �������Ҷ� �ڵ����� ������
		// B��� �̸��� tread��ü ���� target2.run() ����
		Thread threadB = new Thread(target2, "B"); 
//		Thread threadB = new Thread(target1, "B"); // ���ü����Ϸ��� �ݵ�� ������ ��ü����

		threadA.start();
		threadB.start();// ���డ���� ���·� ��������.
		for (int i = 0; i < 10; i++) {
			System.out.println("���� main :" + Thread.currentThread().getName() + i);
			// ���� �������� ���μ��� ������ �̸�
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}

	}
}
