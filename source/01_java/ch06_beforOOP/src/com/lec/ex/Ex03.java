package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);//�ٸ� Ŭ���� ���� ���� import
		Arithmetic ar = new Arithmetic();
		//�ּҰ� ����� ar�̶�� ������ ���� new�����������
		System.out.println("-7�� ���밪��"+ ar.abs(18));
	}
}
