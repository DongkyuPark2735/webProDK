package com.lec.quiz2;

import java.util.Scanner;

import javax.jws.soap.SOAPBinding.Use;

//0<=Math.random() <1
//0<= Math.random()*3 <3
public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int User, computer = (int) (Math.random() * 3);
		System.out.println("����(0) ����(1) ��(2) �� �ϳ��� �Է��Ͻÿ�");
		User = sc1.nextInt();
		int Sci, Rok, Pap;

		if (User == 0) {
//			Sci = User;
			System.out.print("����� ����\t");
		} else if (User == 1) {
//			Rok = User;
			System.out.print("����� ����\t");
		} else if (User == 2) {
//			Pap = User;
			System.out.print("����� ��\t");
		} else {
			System.out.println("��ȿ�� ���� �Է��Ͻÿ�");
			User = 3;
		}
		if (User != 3) {
			String msg = (computer == 0) ? "��ǻ�ʹ� ����" : (computer == 1) ? "��ǻ�ʹ� ����" : "��ǻ�ʹ� ��";
			// ������ �������� if��
			System.out.println(msg);
			if (User == 0) {//
				if (computer == 0) {
					System.out.println("����");
				} else if (computer == 1) {
					System.out.println("����");
				} else if (computer == 2) {
					System.out.println("�̰��");
				}
			} else if (User == 1) {
				if (computer == 0) {
					System.out.println("�̰��");
				} else if (computer == 1) {
					System.out.println("����");
				} else if (computer == 2) {
					System.out.println("����");
				}
			} else if (User == 2) {
				if (computer == 0) {
					System.out.println("����");
				} else if (computer == 1) {
					System.out.println("�̰��");
				} else if (computer == 2) {
					System.out.println("����");
				} // if
			} // if-���� ���
		} // if
	}// main
}// class
