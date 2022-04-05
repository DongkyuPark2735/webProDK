package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1.���� ���� 
// 2.�����͸� �д´� : read() 1byte�� �д´�. �ӵ��� ���� / read(byte[]) byte[]�迭 ��ŭ �д´�
// 3.������ �ݴ´�.
public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");// 1.���� ����
			byte[] bs = new byte[10];
			while (true) { // 2.���� �д´�
				int readByteCount = is.read(bs); // 10 byte�� �б�
				if (readByteCount == -1)//Hi�� 10���� �ȵ� ���� ���� ���� �迭 byte������    
					break; // ���� ������ ����
//				for(byte b : bs) { //�ٳ���?
//					System.out.print((char)b);//�ƽ�Ű �ڵ带 ���ڷ� ��ȯ 
//				}
				for (int i = 0; i < readByteCount; i++) {
					System.out.print((char) bs[i]);
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {//���� �ݱ� 
				if(is != null)is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
