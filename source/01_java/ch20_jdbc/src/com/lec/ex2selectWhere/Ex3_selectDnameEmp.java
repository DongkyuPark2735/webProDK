package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//1. 사용자에게 부서명을 입력받아
//	1-1 부서 존재하는 경우 : 부서정보와 사원정보(사번, 이름, 급여, 급여등급)를 출력
//	1-2 부서 존재하지 않는 경우 : 없다고 출력 

public class Ex3_selectDnameEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 부서명은 ?");
		String dname = sc.next();
//		String sql1 = "SELECT * FROM DEPT WHERE DNAME = UPPER('" + dname + "')"; // '' 살려줘야함 
		String sql1 = String.format("SELECT * FROM DEPT WHERE DNAME = UPPER('%s')", dname);
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE FROM EMP E, SALGRADE, DEPT D"
				+ " WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER('%s') AND SAL BETWEEN LOSAL AND HISAL", dname);
		// oracle에서 가져올떄 oracle에서 중복된 타이틀이나 특수문자 체크
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if (rs.next()) {
				System.out.println("부서 번호 : " + rs.getInt("deptno"));
				System.out.println("부서 이름 : " + dname);
				System.out.println("부서 위치 : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2);
				if (rs.next()) {// 해당 부서명의 사원이 있는경우
					System.out.println("부서번호\t사원이름\t급여\t급여등급");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + grade + "등급");
					} while (rs.next());
				} else {
					System.out.println("해당부서의 사원이 없습니다.");
				}

			} else {
				System.out.println(dname + "해당 부서가 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
