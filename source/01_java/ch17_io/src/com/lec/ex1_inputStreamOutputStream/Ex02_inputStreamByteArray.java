package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1.파일 연다 
// 2.데이터를 읽는다 : read() 1byte씩 읽는다. 속도가 느림 / read(byte[]) byte[]배열 만큼 읽는다
// 3.파일을 닫는다.
public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");// 1.파일 연다
			byte[] bs = new byte[10];
			while (true) { // 2.파일 읽는다
				int readByteCount = is.read(bs); // 10 byte씩 읽기
				if (readByteCount == -1)//Hi가 10개가 안됨 전에 읽은 남은 배열 byte가져옴    
					break; // 파일 끝인지 여부
//				for(byte b : bs) { //다나옴?
//					System.out.print((char)b);//아스키 코드를 문자로 변환 
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
			try {//파일 닫기 
				if(is != null)is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
