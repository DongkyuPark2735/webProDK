package com.lec.ex0_janmuri;

public class QiuzTestMain {

	public static void main(String[] args) {

		Quiz1[] person = { new Quiz1("���켺", 90, 90, 90), new Quiz1("���ϴ�", 90, 90, 91), new Quiz1("Ȳ����", 81, 80, 80),
				new Quiz1("������", 80, 80, 80), new Quiz1("������", 70, 70, 70) };

		int[] tot = new int[5]; // tot[0] �����, ...
		double[] avg = new double[5];// avg[0] �������

		for (int i = 0; i < 50; i++) {
			System.out.print('��');
		}
		System.out.println("\n\t\t\t����ǥ ");
		for (int i = 0; i < 50; i++) {
			System.out.print('-');// ������ Ŭ���� �Լ��� �־ �л����� ����Ҷ� ���� ��µɼ� �ֵ���
		}
		System.out.println("\n   �̸�\t" + "����\t" + "����\t" + "����\t" + "����\t" + "���");
		// �迭�� ������
		for (int i = 0; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println();// String?
		for (Quiz1 p : person) {// ���� �ڷ����� �־���ϱ⶧��
			System.out.printf(p.perInfo() + "\n");
			tot[0] += p.getKor();
			tot[1] += p.getEng();
			tot[2] += p.getMat();
			tot[3] += p.subTotal();
			tot[4] += p.averige(); // (int)(tot[4] + p.getAvg()
		}
		
		for (int i = 0; i < avg.length; i++) {// ����� ��հ�� avg[0] = tot[0]/5
			avg[i] = (double)tot[i] / person.length;
		}
		System.out.print("   ����\t");
		for (int t : tot) {
			System.out.print(t+"\t");
		}
		System.out.print("\n   ���\t");
		for(double a: avg) {
			System.out.print(a+"\t");
		}
		
		System.out.println();// String?

		for (int i = 0; i < 50; i++) {
			System.out.print('��');
		}
	}
}
