package com.lec.test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "����� ��걸", "010-9999-1234", "05-22"));
		friends.add(1, new Friend("��浿", "��⵵ �����ֽ�", "010-8884-6548", "06-01"));
		friends.add(2, new Friend("�ű浿", "��⵵ �����", "010-6546-6546", "11-11"));

		Scanner sc = new Scanner(System.in);
		String tempAddress;
		String friendsAdd;
		Boolean ok = false;

		do {
			System.out.println("�˻��� �ּ� �� ���� 2�ڸ��� �Է��Ͻÿ�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ� )");
			tempAddress = sc.next();
			if (tempAddress.equalsIgnoreCase("x")) {
				break;
			}
			for (int i = 0; i <= friends.size() - 1; i++) {
				friendsAdd = friends.get(i).getAddress();
				if (tempAddress.equals(friendsAdd.substring(0, 2))) {
					System.out.println(friends.get(i));
					ok = true;
				}else {
					ok = false;
				}
			}
			if (!ok){
				System.out.println("�ش� ģ���� ��ȭ��ȣ�� �����ϴ�.");
			}
		} while (true);
		sc.close();
	}
}