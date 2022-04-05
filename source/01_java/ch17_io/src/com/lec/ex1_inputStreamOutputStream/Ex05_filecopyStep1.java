package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex05_filecopyStep1 {
//1.Stream��ü(�Է¿�, ��¿�) 2. �а� ����  3. ���� �ݴ´�(Stream��ü.close())
	public static void main(String[] args) {
		InputStream is = null;
		FileOutputStream os = null;

		try {
			is = new FileInputStream("d:\\webProDK\\T.jpg");// 1
			os = new FileOutputStream("d:/webProDK/T_copyed.jpg");
			int cnt = 0;
			while (true) {
				int i = is.read(); // 1 byte�� �б�
				if (i == -1)
					break;
				os.write(i);
				cnt++;
			}
			System.out.println(cnt + "�� while�� �����Ͽ� ����� ���� ����");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(os != null)os.close();//ó�� ���� ��ü�� ���߿� Ŭ����
				if(is != null)is.close();
			}catch(IOException e) {
				
			}
		}

	}
}
