package com.lec.ex1_runnable;

// "�ȳ��ϼ��� 10��" �ϴ� target or task
public class TargetEx01 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("�ȳ��ϼ��� - " + i);
			try {
				Thread.sleep(500);//���� ������(�۾�)�� 0.5�ʵ��� �����·�  
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
}
