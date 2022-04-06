package com.lec.ex4_threadNObjectN;

//ThreadEx t1 = new ThreadEx()
//t1.setName("A);
public class ThreadEx extends Thread {
	private int num = 0;

	public ThreadEx(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {// "A"�������� ���
				System.out.println("~~~~~A������ ������~~~~~~~~");
				num++;
			} // ���� �޼ҵ带 ȣ���ؾ� synchronized
			System.out.println(Thread.currentThread().getName() + "�� num =" + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

//	private synchronized void out() {//synchronized �� �Լ��� ������ �ٸ�  ������ ���ԺҰ�
//									// �Լ� ������θ� ��ũ�γ����� ����
//									// �޼���ȭ �ؾ���	
//		if (Thread.currentThread().getName().equals("A")) {// "A"�������� ���
//			System.out.println("~~~~~A������ ������~~~~~~~~");
//			num++;
//		}//���� �޼ҵ带 ȣ���ؾ� synchronized 
//		System.out.println(Thread.currentThread().getName() + "�� num =" + num);
//	}
//
	public int getNum() {
		return num;
	}

}
