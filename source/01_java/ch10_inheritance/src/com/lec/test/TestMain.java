package com.lec.test;

public class TestMain {

	public static void main(String[] args) {

			Person s1 = new Student("A01", "������","Java��");
			Person s2 = new Student("A02", "ȫ�浿","C++��");
			Person st1 = new Staff("S01", "���浿","�������");
			Person st2 = new Staff("S01", "���浿","���������");
			Person g1 = new Gangsa("G01", "�̱浿", "��ü����");
			Person[] per = {s1, s2, st1, st2, g1};
			for(Person i : per) {
				i.print();
			}
	}
	
}
