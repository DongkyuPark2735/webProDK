package com.lec.student;

public class StudentTestMain {
	public static void main(String[] args) {

		Student[] person = { new Student("정우성", 90, 90, 90), new Student("김하늘", 90, 90, 91),
				new Student("황정민", 81, 80, 80), new Student("강동원", 80, 80, 80), new Student("유아인", 70, 70, 70) };

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
		for (int i = 0; i < avg.length; i++) {// 출력할 평균계산 avg[0] = tot[0]/5
			avg[i] = (double) tot[i] / person.length;
		}
		System.out.print("\t총점\t");
		for (int t : tot) {
			System.out.print(t + "\t");
		}
		System.out.print("\n\t평균\t");
		for (double a : avg) {
			System.out.print(a + "\t");
		}
		System.out.println();
		for (int i = 0; i < 50; i++) {
			System.out.print('■');
		}
		//소수점 반올림 
		//%4d = 4자리의 공간을 확보함, 숫자가 4자리 보다 적으면 공란 확보
	}

}
