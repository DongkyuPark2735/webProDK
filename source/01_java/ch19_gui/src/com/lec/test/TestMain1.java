package com.lec.test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> arrCust = new ArrayList<Customer>();
		OutputStream os = null;
		String tempName, tempTel, tempAddr, check;

		do {
			System.out.println("회원정보를 입력하세요 (입력 : Y, 종료 : N)");
			check = sc.next();
			if (check.equalsIgnoreCase("n"))
				break;
			else if (check.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력하세요 ex)홍길동");
				tempName = sc.next();
				System.out.println("전화번호를 입력하세요 ex)000-0000-0000");
				tempTel = sc.next();
				System.out.println("주소를 입력하세요 ex)서울시 00구 00동 ");
				sc.nextLine();
				tempAddr = sc.nextLine();
				arrCust.add(new Customer(tempName, tempTel, tempAddr));
			}
		} while (true);
		sc.close();
		if (!arrCust.isEmpty()) {
			try {
				os = new FileOutputStream("customer/customer.txt", true);
				for (int i = 0; i <= arrCust.size() - 1; i++) {
					os.write(arrCust.get(i).toString().getBytes());
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (UnsupportedEncodingException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		if (os != null)
			try {
				os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		if (arrCust.isEmpty()) {
			System.out.println("가입된 회원이 없습니다.");
		} else {
			System.out.println(arrCust);
		}

	}

}
