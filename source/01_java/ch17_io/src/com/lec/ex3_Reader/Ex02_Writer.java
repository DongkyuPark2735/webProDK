package com.lec.ex3_Reader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {

	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt", true);
			String msg = "\n\n �߰��� �ؽ�Ʈ �����Դϴ�. �ȳ��ϼ��� ";
			writer.write(msg);
			System.out.println("������� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close(); //
			} catch (Exception e) {

			}
		}

	}

}