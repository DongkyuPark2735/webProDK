package com.lec.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Member> hashMem = new HashMap<String, Member>();
		String stop, tempName, tempTel, tempAddress;
		// ��ȭ��ȣ �ߺ� ��� �� Ű�� �����ؼ� �ȿ� �����Ͱ� null�ϋ� �Է� �����ϰ�
		// �ؽ��Լ� get�� Ű������ ����� �����Ͱ��� ������
		do {
			System.out.println("ȸ�������� �����Ͻðڽ��ϱ�? (Y/N)");
			stop = sc.next();
			if (stop.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է��ϼ��� ");
				tempName = sc.next();
				System.out.println("��ȭ��ȣ�� �Է��ϼ��� ");
				tempTel = sc.next();
				if (hashMem.get(tempTel) != null) {
					System.out.println("�̹� ���ԵǾ� �ִ� ��ȭ��ȣ �Դϴ�.");
					continue;
				}
				sc.nextLine();
				System.out.println("�ּҸ� �Է��ϼ��� ");
				tempAddress = sc.nextLine();
				hashMem.put(tempTel, new Member(tempName, tempTel, tempAddress));
			}
		} while (!stop.equalsIgnoreCase("n"));
		sc.close();
		if (hashMem.isEmpty()) {
			System.out.println("���Ե� ȸ���� �����ϴ�.");
		} else {
			System.out.println(hashMem);
		}
	}
}
