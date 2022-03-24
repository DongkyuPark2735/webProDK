package com.lec.ex07_book2;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {

		BookLip[] b1 = { new BookLip("111", "java", "ȫ�浿"), new BookLip("222", "oracle", "�ű浿"), new BookLip("333", "mysql", "���浿"),
				new BookLip("444", "web", "��浿"), new BookLip("555", "jsp", "��浿") };

		Scanner scanner = new Scanner(System.in);

		int fn;// ��ɹ�ȣ 1.���� 2.�ݳ� 3.å list 0. ����
		int idx; // �����ϰų� �ݳ��Ϸ��� �Ҷ� ��ȸ�� å�� index //��� for���� �����ϱ����� ���������� ����
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
				} // å��ȸ for
				if (idx == b1.length) {// idx�� 0�� �ƴϴϱ�?
					System.out.println("���� �������� ���� �����Դϴ�.");
				} else {// book[idx] ������ ����ó��
						// 3.å����Ȯ��
					if (b1[idx].getState() == BookLip.STATE_BORROWED) {// ����Ұ� ����
						System.out.println("���� �������� �����Դϴ�.");
					} else {// ���Ⱑ�ɻ���
							// 4.������ �Է� 5. ������ �Է� 6. ����żҵ� ȣ��
						System.out.println("�����ڴ� ?");
						borrower = scanner.next();
						System.out.println("�������� ?");
						checkOutDate = scanner.next();
						b1[idx].checkOut(borrower, checkOutDate);

					}
				}
				break;
			case 2:// �ݳ� : 1.å�̸� 2.å��ȸ 3.�ݳ�
				System.out.print("�ݳ��� å �̸���?");
				bTitle = scanner.next();
				// 2.å��ȸ
				for (idx = 0; idx < b1.length; idx++) {
					if (bTitle.equals(b1[idx].getBookTitle())) {
						break;
					}
				}
				// idx�� ã�� ��ġ
				if (idx == b1.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
				} else {// idx�� ã�� ��ġ
						// 3.�ݳ�
					b1[idx].checkIn();
				}
				break;
			case 3:
				System.out.println("å ����Ʈ�� ������ �����ϴ�.");
				for (BookLip i : b1) {
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
