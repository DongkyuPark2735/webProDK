package com.lec.ex4_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		try {
//			os = new FileOutputStream("txtFile/outTest.txt", true);//기본스트림
//			printWriter = new PrintWriter(os);//보조 스트림
//			writer = new FileWriter("txtFile/outTest.txt", true);// 기본스트림
//			printWriter = new PrintWriter(writer);// 보조 스트림
			printWriter = new PrintWriter("txtFile/inTest.txt"); // 파일 append(내용추가) 불가
			System.out.println("안녕하세요\n반갑습니다.");
			printWriter.println("안녕하세요\n반갑습니다.");

			System.out.print("print는 자동 개행이 안돼서 개행추가\n");
			printWriter.print("print는 자동 개행이 안돼서 개행추가\n");

			System.out.printf("%s \t %d \t %3d \t %.5f\n", "홍길동", 90, 91, 90.5);
			printWriter.printf("%s \t %d \t %3d \t %.5f\n", "홍길동", 90, 91, 90.5);

			System.out.printf("%s \t %d \t %3d \t %.5f\n", "신길동", 100, 100, 100.0);
			printWriter.printf("%s \t %d \t %3d \t %.5f\n", "신길동", 100, 100, 100.0);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (printWriter != null)
				printWriter.close();
			try {
			} catch (Exception e2) {
			}
		}

	}
}
