package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex05_filecopyStep2 {
//1.Stream객체(입력용, 출력용) 2. 읽고 쓴다  3. 파일 닫는다(Stream객체.close())
	public static void main(String[] args) {
		InputStream is = null;
		FileOutputStream os = null;

		try {
			is = new FileInputStream("d:\\webProDK\\T.jpg");// 1
			os = new FileOutputStream("d:/webProDK/T_copyed.jpg");
			int cnt = 0;
			byte[] bs = new byte[1024];
			while (true) {
				int readByCount = is.read(bs); // 1024 byte씩 읽기
				if (readByCount == -1)
					break;
				os.write(bs, 0 , readByCount);//bs를 0번 index부터 readByCount 만큼 쓴다 os로 
				cnt++;
			}
			System.out.println(cnt + "번 while문 실행하여 힘들게 복사 성공");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(os != null)os.close();//처음 만든 객체를 나중에 클로즈
				if(is != null)is.close();
			}catch(IOException e) {
				
			}
		}

	}
}
