package com.lec.ex1_store;
//HeadQuarterStore h1 = new HeadQuarterStore("����") //�߻�Ŭ������ ��ü ���� �Ұ� 
public abstract class HeadQuarterStore {
	private String str; // "����" ���� ����

	public HeadQuarterStore(String str) {
		this.str = str;
	}

	public abstract void kimchi();

	public abstract void bude();

	public abstract void bibim();

	public abstract void sunde();

	public abstract void gonggibab();

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
