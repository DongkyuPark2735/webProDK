package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PERSONTEST {
	public static void main(String[] args) {
		// 필드 선언
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String insertSQL = "INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, ?, ?, ?,?,"
				+ "(SELECT JNO FROM JOB WHERE JNAME = ?) )";
		String selectSQL = "SELECT ROWNUM 등수,PNAME, JNAME, KOR, ENG, MAT, TOT" + 
				" FROM( SELECT PNO, PNAME||'('||PNO||'번)' PNAME , JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) TOT" + 
				" FROM PERSON P, JOB J WHERE P.JNO=J.JNO AND JNAME = ? ORDER BY TOT DESC)";
		int result, ok;
		// 객체 생성
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			do {
				System.out.println("번호를 입력하세요  --1번 : 입력  --2번 : 정보 출력  --3:번 전체 정보 출력 -- 0 = 종료");
				ok = sc.nextInt();
				if (ok == 1) { //입력
					pstmt = conn.prepareStatement(insertSQL);
					System.out.println("이름을 입력하세요");
					String pname = sc.next();
					pstmt.setString(1, pname);
					System.out.println("국어 점수를 입력하세요 ");
					int kor = sc.nextInt();
					pstmt.setInt(2, kor);
					System.out.println("영어 점수를 입력하세요");
					int eng = sc.nextInt();
					pstmt.setInt(3, eng);
					System.out.println("수학 점수를 입력하세요 ");
					int mat = sc.nextInt();
					pstmt.setInt(4, mat);
					System.out.println("직업을 입력하세요");
					String jname = sc.next();
					pstmt.setString(5, jname);
					result = pstmt.executeUpdate();
					System.out.println((result > 0) ? "입력 성공" : "입력 실패");
				} else if (ok == 2) {
					pstmt = conn.prepareStatement(selectSQL);
					System.out.println("조회하려는 직업을 입력하세요");
					String jname = sc.next();
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					System.out.println("등수\t이름\t\t직업\t국어\t영어\t수학\t총점");
					while(rs.next()) {
						int rownum = rs.getInt("등수");
						String pname = rs.getString("pname");
						jname = rs.getString("jname");
						int kor = rs.getInt("kor");
						int eng = rs.getInt("eng");
						int mat = rs.getInt("mat");
						int tot = rs.getInt("tot");
						System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\n",
								rownum, pname, jname,kor,eng,mat,tot);
					}
				}
			} while (ok != 0);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			}
	}

}
