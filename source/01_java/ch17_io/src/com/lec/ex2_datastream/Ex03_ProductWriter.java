package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWriter {
//n을 입력할떄까지 재고 입력(상품명, 가격, 재고량)을 입력받아 파일 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);// 같은 파일 경로에 새로운 파일 만듬
			dos = new DataOutputStream(fos);

			while (true) {
				System.out.println("입력할 재고가 더 있나요 y/n ?");
				answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				} else if (answer.equalsIgnoreCase("y")) {// 상품면, 가격 , 재고량 을 파을로 출력
					System.out.println("상품명은 ?");
					dos.writeUTF(sc.next());
					System.out.println("가격은 ?");
					dos.writeInt(sc.nextInt());
					System.out.println("재고수량은 ?");
					dos.writeInt(sc.nextInt());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					dos.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
