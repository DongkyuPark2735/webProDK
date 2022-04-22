package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//사용자로부터 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책 ,급여를 출력하시오
import java.util.Scanner;

public class Ex2_select {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP E, DEPT D "
				+ "WHERE E.DEPTNO = D.DEPTNO AND DNAME=UPPER( ? )";

		System.out.println("조회하려는 부서명을 입력하세요");
		String dname = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("사원 이름\t사원 명\t직 책\t\t급 여");
				do {
					int empno = rs.getInt("EMPNO");
					String ename = rs.getString("ENAME");
					String job = rs.getString("JOB");
					int sal = rs.getInt("SAL");
					if (job.length() > 7) {
						System.out.println(String.format("%d\t%s\t%s\t%d", empno, ename, job, sal));
					} else {
						System.out.println(String.format("%d\t%s\t%s\t\t%d", empno, ename, job, sal));
					}
				} while (rs.next());
			}else {
				System.out.println("해당 부서의 사원이 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
