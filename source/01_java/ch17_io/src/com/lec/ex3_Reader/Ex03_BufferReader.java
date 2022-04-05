package com.lec.ex3_Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex03_BufferReader {

	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");
			br = new BufferedReader(reader); // ������Ʈ�� ���� //���پ� ����
			while (true) {
				String linedate = br.readLine(); // ���پ� ������ �б�
				if(linedate ==null)break;
				System.out.println(linedate);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br != null) br.close();
				if(reader != null) reader.close();

			} catch (Exception e2) {
			}
		}
	}
}
