package com.lec.test;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Customer> hashCust = new HashMap<String, Customer>();
		
		OutputStream os = null;
		String tempName, tempTel, tempAddr, check;

		do {
			System.out.println("ȸ�������� �Է��ϼ��� (�Է� : Y, ���� : N)");
			check = sc.next();
			if (check.equalsIgnoreCase("n"))
				break;
			else if (check.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է��ϼ��� ex)ȫ�浿");
				tempName = sc.next();
				
				System.out.println("��ȭ��ȣ�� �Է��ϼ��� ex)000-0000-0000");
				tempTel = sc.next();
				
				System.out.println("�ּҸ� �Է��ϼ��� ex)����� 00�� 00�� ");
				sc.nextLine();
				tempAddr = sc.nextLine();
				hashCust.put(tempTel, new Customer(tempName, tempTel, tempAddr));
			}
		} while (true);
		sc.close();
		if (hashCust.isEmpty()) {
			System.out.println("���Ե� ȸ���� �����ϴ�.");
		} else {
			Iterator<String> iter1 = hashCust.keySet().iterator();
			while(iter1.hasNext()) {
				System.out.println(hashCust.get(iter1.next()));
			}
		}

	}

}
