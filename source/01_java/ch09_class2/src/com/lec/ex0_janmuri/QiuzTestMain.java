package com.lec.ex0_janmuri;

public class QiuzTestMain {

	public static void main(String[] args) {

		Quiz1[] person = { new Quiz1("정우성", 90, 90, 90), new Quiz1("김하늘", 90, 90, 91), new Quiz1("황정민", 81, 80, 80),
				new Quiz1("강동원", 80, 80, 80), new Quiz1("유아인", 70, 70, 70) };

		int[] tot = new int[5]; // tot[0] 국어누적, ...
		double[] avg = new double[5];// avg[0] 국어평균

		for (int i = 0; i < 50; i++) {
			System.out.print('■');
		}
		System.out.println("\n\t\t\t성적표 ");
		for (int i = 0; i < 50; i++) {
			System.out.print('-');// 라인을 클래스 함수에 넣어서 학생정보 출력할때 같이 출력될수 있도록
		}
		System.out.println("\n   이름\t" + "국어\t" + "영어\t" + "수학\t" + "총점\t" + "평균");
		// 배열로 만들어볼것
		for (int i = 0; i < 50; i++) {
			System.out.print('-');
		}
		System.out.println();// String?
		for (Quiz1 p : person) {// 같은 자료형에 넣어야하기때문
			System.out.printf(p.perInfo() + "\n");
			tot[0] += p.getKor();
			tot[1] += p.getEng();
			tot[2] += p.getMat();
			tot[3] += p.subTotal();
			tot[4] += p.averige(); // (int)(tot[4] + p.getAvg()
		}
		
		for (int i = 0; i < avg.length; i++) {// 출력할 평균계산 avg[0] = tot[0]/5
			avg[i] = (double)tot[i] / person.length;
		}
		System.out.print("   총점\t");
		for (int t : tot) {
			System.out.print(t+"\t");
		}
		System.out.print("\n   평균\t");
		for(double a: avg) {
			System.out.print(a+"\t");
		}
		
		System.out.println();// String?

		for (int i = 0; i < 50; i++) {
			System.out.print('■');
		}
	}
}
