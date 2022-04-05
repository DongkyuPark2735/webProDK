package com.lec.ex1_inputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//1. 파일을 연다 (출력용 객체 생성), 2 write 한다 3.파일을 닫는다(stream객체 .close)
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile\\outTest.txt");// 폴더 없을때 예외발생
			String str = "Hello, Java\n이 시국에 모두 건강하세요";
			byte[] bs = str.getBytes();//String을 byte계열로 바꾸는 함수
			os.write(bs);//내부적으로 bs배열 출력
			System.out.println("파일 출력 성공 ");
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
