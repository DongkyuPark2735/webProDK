package com.lec.Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> arrMem = new ArrayList<Member>();
		String tempName, tempTel, tempAddress, answer;

		do {
			System.out.println("ȸ�������� �����Ͻðڽ��ϱ�? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if(answer.equalsIgnoreCase("y")){
				System.out.println("�̸��� �Է��ϼ��� ");
				tempName = sc.next();
				System.out.println("��ȭ��ȣ�� �Է��ϼ��� ");
				tempTel = sc.next();
				sc.nextLine();
				System.out.println("�ּҸ� �Է��ϼ��� ");
				tempAddress = sc.nextLine();
				arrMem.add(new Member(tempName, tempTel, tempAddress));
			}
		} while (true);
		sc.close();
		
		if(arrMem.isEmpty()) {
			System.out.println("���Ե� ȸ���� �����ϴ�.");
		}else {
			System.out.println(arrMem);
		}
	}
}
