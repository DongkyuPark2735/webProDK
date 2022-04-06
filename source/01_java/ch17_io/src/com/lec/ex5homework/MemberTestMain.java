package com.lec.ex5homework;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> arrMem = new ArrayList<Member>();
		FileWriter fw = null;
		String chk, tempName, tempTel, tempAddress, tmepbirthDate;
		Date birthdate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM�� dd��");
		do { // ȸ�������Է�
			System.out.println("ȸ�������� �Է��Ͻÿ� (Y/N)");
			chk = sc.next();
			if (chk.equalsIgnoreCase("n")) {
				break;
			} else if (chk.equalsIgnoreCase("y")) {
				System.out.println("�̸��� �Է��ϼ��� ");
				tempName = sc.next();
				System.out.println("��ȭ��ȣ�� �Է��ϼ��� (000-0000-0000)");
				tempTel = sc.next();
				System.out.println("������� 8�ڸ��� �Է��ϼ��� ex)19950501");
				tmepbirthDate = sc.next();
				int year = Integer.parseInt(tmepbirthDate.substring(0, 4));
				int month = Integer.parseInt(tmepbirthDate.substring(4, 6));
				int day = Integer.parseInt(tmepbirthDate.substring(6));
				birthdate = new Date(year - 1900, month - 1, day);
				sc.nextLine();
				System.out.println("�ּҸ� �Է��ϼ���");
				tempAddress = sc.nextLine();
				arrMem.add(new Member(tempName, tempTel, birthdate, tempAddress));
			}
		} while (true); // ȸ�������Է³�
		
		
		// ���� �Է�
		try {
			fw = new FileWriter("txtFile/member.txt", true);
			for (int i = 0; i <= arrMem.size() - 1; i++) {// �����Է� for��
				fw.write(arrMem.get(i).toString()+"\n");
				String bth = sdf.format(new Date());
				if (sdf.format(arrMem.get(i).getDate()).equals(bth)) {
					fw.write(arrMem.get(i).getName() + "��, ���� �����̽ó׿� . ���� �����մϴ�.\n");
				}
			}
			fw.write(".....���� " + arrMem.size() + " �� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)	fw.close();
			} catch (Exception e2) {}
		}

		// ȸ������ �Է� ������ �������
		if (arrMem.isEmpty()) {
			System.out.println("���� " + arrMem.size() + " �� ����");
		} else {
			for (int i = 0; i <= arrMem.size() - 1; i++) {
				System.out.println(arrMem.get(i).toString());
				String bth = sdf.format(new Date());
				if (sdf.format(arrMem.get(i).getDate()).equals(bth)) {
					System.out.println(arrMem.get(i).getName() +" ���� �����̽ó׿� . ���� �����մϴ�.");
				}
			}
			System.out.println(".....���� " + arrMem.size() + " �� ����");
		}
	}
}



