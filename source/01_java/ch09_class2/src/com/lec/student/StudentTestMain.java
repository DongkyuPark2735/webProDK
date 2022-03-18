package com.lec.student;

public class StudentTestMain {
	public static void main(String[] args) {

		Student[] person = { new Student("���켺", 90, 90, 90), new Student("���ϴ�", 90, 90, 91),
				new Student("Ȳ����", 81, 80, 80), new Student("������", 80, 80, 80), new Student("������", 70, 70, 70) };

		int[] tot = new int[5];
		double[] avg = new double[5];

		Student.textPrint();
		
		for (Student p : person) {
			System.out.printf(p.perInfo() + "\n");
			tot[0] += p.getKor();
			tot[1] += p.getEng();
			tot[2] += p.getMat();
			tot[3] += p.subTotal();
			tot[4] += p.averige(); // (int)(tot[4] + p.getAvg()
		}

		for (int i = 0; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println();
		for (int i = 0; i < avg.length; i++) {// ����� ��հ�� avg[0] = tot[0]/5
			avg[i] = (double) tot[i] / person.length;
		}
		System.out.print("\t����\t");
		for (int t : tot) {
			System.out.print(t + "\t");
		}
		System.out.print("\n\t���\t");
		for (double a : avg) {
			System.out.print(a + "\t");
		}
		System.out.println();
		for (int i = 0; i < 50; i++) {
			System.out.print('��');
		}
		//�Ҽ��� �ݿø� 
		//%4d = 4�ڸ��� ������ Ȯ����, ���ڰ� 4�ڸ� ���� ������ ���� Ȯ��
	}

}
