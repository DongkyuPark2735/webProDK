package com.lec.ex02_store;

public class Store2 implements HeadQuarterStore {
	private String str;

	public Store2(String str) {
		this.str = str;
	}

	@Override
	public void bude() {
		System.out.println("�δ�� - 5,000��");
	}

	@Override
	public void bibim() {
		System.out.println("����� - 5,000��");
	}

	@Override
	public void kimchi() {
		System.out.println("���� - 5,000��");

	}

	@Override
	public void sunde() {
		System.out.println("���� - 5,000��");

	}

	@Override
	public void gonggibab() {
		System.out.println("����� - ����");
	}
	public String getStr() {
		return str;
	}
}
