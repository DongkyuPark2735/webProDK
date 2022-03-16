package com.lec.ex2_human;

//Man kim = new Man(22, 160, 50.5, "010-00agi0fi");
public class Man {
	private int age;
	private int height;
	private double weight;
	private String phoneNum;

	public Man() {
	}// 디폴트 생성자 함수
	//매서드의 오버로딩은 매서드의 매개변수 타입이나 갯수로 구분함
	//같은 자료형과 같은 매개변수 갯수로는 구분할수 없음
	public Man(int age) {
			this.age = age;			
	}

	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;

		System.out.println("파라미터가 4개짜리 함수 호출");
	}

	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;

		System.out.println("파라미터가 3개짜리 함수 호출");
	}
}
