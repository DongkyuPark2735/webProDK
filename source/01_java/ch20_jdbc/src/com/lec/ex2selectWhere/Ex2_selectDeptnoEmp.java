package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//1. 사용자에게 부서번호 입력받아
// 1-1 해당부서번호가 존재할경우 : 해당부서정보와 해당부서 사원(사번, 이름, 급여, 상사명, )을 출력 
// 1-2 해당부서번호가 존재하지 않을 경우 : 없다고 출력
public class Ex2_selectDeptnoEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("원하는 부서번호는 ?");
		int deptno = scanner.nextInt();

		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME , W.SAL, M.ENAME MANAGER" + " FROM EMP W, EMP M"
				+ " WHERE W.MGR = M.EMPNO AND W.DEPTNO =" + deptno;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if (rs.next()) {// 해당 부서번호가 있음
				System.out.println("부서 번호 : " + deptno);
				System.out.println("부서 이름 : " + rs.getString("dname"));
				System.out.println("부서 위치 : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2); // empno, ename, sal, manager
				if (rs.next()) {
					System.out.println("사번 \t 이름\t 급여\t상사명");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager"); //출력
						System.out.println(empno+"\t" + ename +"\t"+ sal+"\t" + manager);
					}while(rs.next());
				}else {
					System.out.println(deptno + "번 부서 사원은 없습니다.");
				}
			} else {// 부서 없음

				System.out.println(deptno + "번 부서는 없습니다.");
			}
			rs = stmt.executeQuery(sql2);

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
