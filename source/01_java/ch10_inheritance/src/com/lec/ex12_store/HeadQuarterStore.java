package com.lec.ex12_store;

//���� ��ħ         : ��ġ�-5,000  �δ��-6,000  �����-6,000 ���뱹-5,000  �����-1,000��
public class HeadQuarterStore {
	private String str; // "����" ���� ����
	
	public HeadQuarterStore(String str) {
		this.str = str;
	}

	public void kimchi() {
		System.out.println("��ġ� - 5,000��");
	}
	public void bude() {
		System.out.println("�δ�� - 6,000��");
	}
	public void bibim() {
		System.out.println("����� - 6,000��");
	}
	public void sunde() {
		System.out.println("���� - 5,000��");
	}
	public void gonggibab() {
		System.out.println("����� - 1,000��");
	}
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}
