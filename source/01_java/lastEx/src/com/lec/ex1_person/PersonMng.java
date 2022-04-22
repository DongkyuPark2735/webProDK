package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 1.입력 2.직업별 조회 3.전체조회 4.종료
public class PersonMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null; // 1번 2번에
		Statement stmt = null; // 3번에
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String fn, sql;
//insert delete 는 닫아줘야함???		
		try {
			Class.forName(driver); // 1. 드라이버 로드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // 1.드라이버 로드
		do {
			System.out.println("1:입력 || 2: 직업별 조회 || 3: 전체조회 || 그외 : 종료");
			fn = sc.next();
			switch (fn) {
			case "1":
				sql = "INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, ?, ?, ?,?,(SELECT JNO FROM JOB WHERE JNAME = ?))";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("이름을 입력하세요");
					pstmt.setString(1, sc.next());
					System.out.println("국어 점수를 입력하세요 ");
					pstmt.setInt(2, sc.nextInt());
					System.out.println("영어 점수를 입력하세요");
					pstmt.setInt(3, sc.nextInt());
					System.out.println("수학 점수를 입력하세요 ");
					pstmt.setInt(4, sc.nextInt());
					System.out.println("직업을 입력하세요");
					pstmt.setString(5, sc.next());
					int result = pstmt.executeUpdate();
					System.out.println((result > 0) ? "입력 성공" : "입력 실패");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e) {
					}
				}
				break;
			case "2":
				sql = "SELECT ROWNUM 등수,PNAME, JNAME, KOR, ENG, MAT, TOT FROM( SELECT PNO, PNAME||'('||PNO||'번)' PNAME , JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) TOT"
						+ " FROM PERSON P, JOB J WHERE P.JNO=J.JNO AND JNAME = ? ORDER BY TOT DESC)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("직업은(배우, 가수, 엠씨)?");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("등수\t이름\t\t직업\t국어\t영어\t수학\t총점");
						do {
							int rownum = rs.getInt("등수");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int tot = rs.getInt("tot");
							System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\n", rownum, pname, jname, kor, eng, mat, tot);
						} while (rs.next());
					}else {
						System.out.println("해당 직업의 인명정보가 없습니다.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "3":
				sql = "SELECT ROWNUM 등수, PNO, PNAME, JNAME, KOR, ENG, MAT, TOT" + 
						" FROM( SELECT PNO, PNAME, JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) TOT" + 
						" FROM PERSON P, JOB J WHERE P.JNO=J.JNO ORDER BY TOT DESC)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						System.out.println("등수\t이름\t\t직업\t국어\t영어\t수학\t총점");
						do {
							int rownum = rs.getInt("등수");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int tot = rs.getInt("tot");
							System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\n", rownum, pname, jname, kor, eng, mat, tot);
						} while (rs.next());
					}else {
						System.out.println("해당 직업의 인명정보가 없습니다.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("bye");
	}
}
