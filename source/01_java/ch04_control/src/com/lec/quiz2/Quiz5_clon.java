package com.lec.quiz2;

import java.util.Scanner;

import javax.jws.soap.SOAPBinding.Use;

//0<=Math.random() <1
//0<= Math.random()*3 <3
public class Quiz5_clon {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		int User, computer = (int) (Math.random() * 3);
		System.out.println("����(0) ����(1) ��(2) �� �ϳ��� �Է��Ͻÿ�");
		User = sc1.nextInt();

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
			// ����Ǽ�
		}
//		if((User ==0 && computer ==1)||(User==1)||(computer==1)){
//			
//		}
		// u 0 c 2
		if ((User + 1) % 3 == computer) {
			System.out.println("����� �����");
		} else if (User == computer) {
			System.out.println("����");
		} else {
			System.out.println("����� �̰���");
		}
	} // if-���� ���
}// main
