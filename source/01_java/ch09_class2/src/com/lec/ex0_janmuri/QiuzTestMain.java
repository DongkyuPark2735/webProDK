package com.lec.ex0_janmuri;

public class QiuzTestMain {

	public static void main(String[] args) {
				
		Quiz1[] person = { new Quiz1("���켺", 90, 90, 90), new Quiz1("���ϴ�", 90, 90, 91), new Quiz1("Ȳ����", 81, 80, 80),
				new Quiz1("������", 80, 80, 80), new Quiz1("������", 70, 70, 70) };
		for (int i = 0; i < 50; i++) {
			System.out.print('��');
		}
		System.out.println("\n\t\t\t����ǥ ");
		for (int i = 0; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println("\n   �̸�\t" + "����\t" + "����\t" + "����\t" + "����\t" + "���");
		for (int i = 0; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println();//String?
		for(Quiz1 p : person) {//���� �ڷ����� �־���ϱ⶧�� 
			System.out.printf(p.perInfo()+"\n");	
		}
		for (int i = 0; i < 50; i++) {
			System.out.print('��');
		}
	}
}
