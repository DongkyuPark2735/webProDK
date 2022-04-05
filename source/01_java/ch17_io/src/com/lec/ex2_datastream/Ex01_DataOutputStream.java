package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//1. stream 객체 생성 == 파일을 연다  2.데이터 쓴다  3.stream객체 닫는다 = 파일을 닫는다.
public class Ex01_DataOutputStream {

	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat", true);// 기본스트림 //추가 입력됨
			dos = new DataOutputStream(fos);// 매개변수에 아웃풋 스트림 객체 들어가야함 //보조스트림은 기본 스트림을 통해서만 생성할수있음
			// 내용 안보이게 // 이름 - 학년 - 점수 write 열어볼수없으니 순서 기억해서 불러올때도
			dos.writeUTF("홍길동");// 스트링값 저장
			dos.writeInt(2);// int값 저장
			dos.writeDouble(90.5);// double값 저장

			dos.writeUTF("신길동");// 스트링값 저장
			dos.writeInt(3);// int값 저장
			dos.writeDouble(99.5);// double값 저장
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null) //나중에 연것 먼저 닫는다 
					dos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e2) {

			}
		}

	}

}
