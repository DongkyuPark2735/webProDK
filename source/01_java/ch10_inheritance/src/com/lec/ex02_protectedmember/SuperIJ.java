package com.lec.ex02_protectedmember;

//데이터 - 생성자 - 메소드 - 오버라이드 매소드 - set get
public class SuperIJ {
	private int i;
	private int j;

//상속받은 클래스에서 Super 클래스 (부모단) 생성자 함수를 먼저 호출
	public SuperIJ() {
		System.out.println("매개변수 없는것 SuperIJ 생성자 함수");

	}

	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는 SuperIJ 생성자 함수로 i, j 값 초기화");
	}

	protected int getI() {
		return i;
	}

	protected void setI(int i) {
		this.i = i;
	}

	protected int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}
