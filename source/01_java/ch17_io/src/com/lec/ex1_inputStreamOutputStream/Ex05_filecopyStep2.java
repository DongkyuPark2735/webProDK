package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex05_filecopyStep2 {
//1.Stream��ü(�Է¿�, ��¿�) 2. �а� ����  3. ���� �ݴ´�(Stream��ü.close())
	public static void main(String[] args) {
		InputStream is = null;
		FileOutputStream os = null;

		try {
			is = new FileInputStream("d:\\webProDK\\T.jpg");// 1
			os = new FileOutputStream("d:/webProDK/T_copyed.jpg");
			int cnt = 0;
			byte[] bs = new byte[1024];
			while (true) {
				int readByCount = is.read(bs); // 1024 byte�� �б�
				if (readByCount == -1)
					break;
				os.write(bs, 0 , readByCount);//bs�� 0�� index���� readByCount ��ŭ ���� os�� 
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
