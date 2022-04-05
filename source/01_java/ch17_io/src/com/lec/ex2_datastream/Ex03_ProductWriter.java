package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWriter {
//n�� �Է��ҋ����� ��� �Է�(��ǰ��, ����, ���)�� �Է¹޾� ���� ���
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);// ���� ���� ��ο� ���ο� ���� ����
			dos = new DataOutputStream(fos);

			while (true) {
				System.out.println("�Է��� ��� �� �ֳ��� y/n ?");
				answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				} else if (answer.equalsIgnoreCase("y")) {// ��ǰ��, ���� , ��� �� ������ ���
					System.out.println("��ǰ���� ?");
					dos.writeUTF(sc.next());
					System.out.println("������ ?");
					dos.writeInt(sc.nextInt());
					System.out.println("�������� ?");
					dos.writeInt(sc.nextInt());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					dos.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
