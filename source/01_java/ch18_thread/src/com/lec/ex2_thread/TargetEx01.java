package com.lec.ex2_thread;

//Thread t1 = new ThreadEx01();
//Thread t1 = new ThreadEx01("A");
public class TargetEx01 extends Thread {// ������ ��� �Ϲ�Ŭ������

	public TargetEx01() {
	}

	public TargetEx01(String name) {
		super(name);
	}

	@Override // �����������̵� �������� ���ο� run����
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("�ȳ��ϼ��� -" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
