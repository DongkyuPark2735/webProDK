package com.lec.ex5homework;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> arrMem = new ArrayList<Member>();
		FileWriter fw = null;
		String chk, tempName, tempTel, tempAddress, tmepbirthDate;
		Date birthdate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd생");
		do { // 회원정보입력
			System.out.println("회원정보를 입력하시오 (Y/N)");
			chk = sc.next();
			if (chk.equalsIgnoreCase("n")) {
				break;
			} else if (chk.equalsIgnoreCase("y")) {
				System.out.println("이름을 입력하세요 ");
				tempName = sc.next();
				System.out.println("전화번호를 입력하세요 (000-0000-0000)");
				tempTel = sc.next();
				System.out.println("생년월일 8자리를 입력하세요 ex)19950501");
				tmepbirthDate = sc.next();
				int year = Integer.parseInt(tmepbirthDate.substring(0, 4));
				int month = Integer.parseInt(tmepbirthDate.substring(4, 6));
				int day = Integer.parseInt(tmepbirthDate.substring(6));
				birthdate = new Date(year - 1900, month - 1, day);
				sc.nextLine();
				System.out.println("주소를 입력하세요");
				tempAddress = sc.nextLine();
				arrMem.add(new Member(tempName, tempTel, birthdate, tempAddress));
			}
		} while (true); // 회원정보입력끝
		
		
		// 파일 입력
		try {
			fw = new FileWriter("txtFile/member.txt", true);
			for (int i = 0; i <= arrMem.size() - 1; i++) {// 파일입력 for문
				fw.write(arrMem.get(i).toString()+"\n");
				String bth = sdf.format(new Date());
				if (sdf.format(arrMem.get(i).getDate()).equals(bth)) {
					fw.write(arrMem.get(i).getName() + "님, 오늘 생일이시네요 . 생일 축하합니다.\n");
				}
			}
			fw.write(".....이하 " + arrMem.size() + " 명 가입");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)	fw.close();
			} catch (Exception e2) {}
		}

		// 회원정보 입력 끝나고 정보출력
		if (arrMem.isEmpty()) {
			System.out.println("이하 " + arrMem.size() + " 명 가입");
		} else {
			for (int i = 0; i <= arrMem.size() - 1; i++) {
				System.out.println(arrMem.get(i).toString());
				String bth = sdf.format(new Date());
				if (sdf.format(arrMem.get(i).getDate()).equals(bth)) {
					System.out.println(arrMem.get(i).getName() +" 오늘 생일이시네요 . 생일 축하합니다.");
				}
			}
			System.out.println(".....이하 " + arrMem.size() + " 명 가입");
		}
	}
}



