package com.lec.ex1_store;

public class Store1 extends HeadQuarterStore {

	public Store1(String str) {
		super(str);
	}

	@Override
	public void sunde() {
		System.out.println("���� - ���Ⱦ�");
	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� - 4,500��");
	}

	@Override
	public void bude() {
		System.out.println("�δ�� - 5,000��");

	}

	@Override
	public void bibim() {
		System.out.println("����� - 6,000��");

	}

	@Override
	public void gonggibab() {
		System.out.println("����� - 1,000��");

	}

}
