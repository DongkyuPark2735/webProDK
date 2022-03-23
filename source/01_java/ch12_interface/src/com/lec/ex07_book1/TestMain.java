package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {

		Book[] b1 = { new Book("111", "java", "ȫ�浿"), new Book("222", "oracle", "�ű浿"), new Book("333", "mysql", "���浿"),
				new Book("444", "web", "��浿"), new Book("555", "jsp", "��浿") };

		Scanner scanner = new Scanner(System.in);

		int fn;// ��ɹ�ȣ 1.���� 2.�ݳ� 3.å list 0. ����
		int idx; // �����ϰų� �ݳ��Ϸ��� �Ҷ� ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate;// ������� å�̸�, ������, ������

		do {
			System.out.println("1.���� 2.�ݳ� 3.å list 0. ����");
			fn = scanner.nextInt();
			switch (fn) {
			case 1:// ���� : 1.å�̸� �Է� 2.å ��ȸ 3.å ���� Ȯ�� 4.�������Է� 5.������ �Է� 6.����żҵ� ȣ��
				System.out.println("���� �ϰ��� �ϴ� å �̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2. å��ȸ
				for (idx = 0; idx < b1.length; idx++) {
					if (bTitle.equals(b1[idx].getBookTitle())) {
						break;
					}
				}//å��ȸ for
				if(idx==b1.length) {
					System.out.println("���� �������� ���� �����Դϴ�.");
				}else {//book[idx] ������ ����ó��
					//3.å����Ȯ��
					if(b1[idx].getState() == Book.STATE_BORROWED) {//����Ұ� ����
						System.out.println("���� �������� �����Դϴ�.");
					}else {//���Ⱑ�ɻ���
						//4.������ �Է� 5. ������ �Է� 6. ����żҵ� ȣ��
						System.out.println("�����ڴ� ?");
						borrower = scanner.next();
						System.out.println("�������� ?");
						checkOutDate = scanner.next();
						b1[idx].checkOut(borrower, checkOutDate);
						
					}
				}
				break;
			case 2:
				System.out.println("�ݳ� �����ϴ� ���� �� ����");
				break;
			case 3:
				System.out.println("å ����Ʈ�� ������ �����ϴ�.");
				for (Book i : b1) {
					i.printState();
				}

				break;
			}
		} while (fn != 0);
		System.out.println("�ȳ��� ������");
//		while(true) {
//			System.out.println("1.���� 2.�ݳ� 3.å list 0. ����");
//			fn = scanner.nextInt();
//			if(fn==0) {
//				break;
//			}
//		}

	}
}
