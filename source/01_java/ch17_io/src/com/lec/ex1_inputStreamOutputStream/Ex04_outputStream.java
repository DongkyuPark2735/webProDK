package com.lec.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//1. ������ ���� (��¿� ��ü ����), 2 write �Ѵ� 3.������ �ݴ´�(stream��ü .close)
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile\\outTest.txt");// ���� ������ ���ܹ߻�
			String str = "Hello, Java\n�� �ñ��� ��� �ǰ��ϼ���";
			byte[] bs = str.getBytes();//String�� byte�迭�� �ٲٴ� �Լ�
			os.write(bs);//���������� bs�迭 ���
			System.out.println("���� ��� ���� ");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
