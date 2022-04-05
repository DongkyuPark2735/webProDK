package com.lec.ex1_inputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_filecopyStep3 {
//1.Stream객체(입력용, 출력용) 2. 읽고 쓴다  3. 파일 닫는다(Stream객체.close())
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;

		try {
			File file = new File("d:\\webProDK\\T.jpg");
			is = new FileInputStream(file);//파일이 없을수도있음?
			os = new FileOutputStream("d:/webProDK/T_copyed.jpg");
			int cnt = 0;
			byte[] bs = new byte[(int)file.length()];//long형이라 int로 형변환 
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
