package com.lec.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Member> hashMem = new HashMap<String, Member>();
		String stop;
		
		do {
			System.out.println("ȸ�������� �����Ͻðڽ��ϱ�? (Y/N)");
			stop = sc.next();
			if (stop.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է��ϼ��� ");
				String tempName = sc.next();
				System.out.println("��ȭ��ȣ�� �Է��ϼ��� ");
				String tempTel = sc.next();
				sc.nextLine();
				System.out.println("�ּҸ� �Է��ϼ��� ");
				String tempAddress = sc.nextLine();
				hashMem.put(tempTel, new Member(tempName, tempTel, tempAddress));
			}
		} while (!stop.equalsIgnoreCase("n"));
			System.out.print(hashMem);
	}

}
