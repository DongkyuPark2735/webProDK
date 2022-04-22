package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 1.�Է� 2.������ ��ȸ 3.��ü��ȸ 4.����
public class PersonMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null; // 1�� 2����
		Statement stmt = null; // 3����
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String fn, sql;
//insert delete �� �ݾ������???		
		try {
			Class.forName(driver); // 1. ����̹� �ε�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // 1.����̹� �ε�
		do {
			System.out.println("1:�Է� || 2: ������ ��ȸ || 3: ��ü��ȸ || �׿� : ����");
			fn = sc.next();
			switch (fn) {
			case "1":
				sql = "INSERT INTO PERSON VALUES(PERSON_NO_SQ.NEXTVAL, ?, ?, ?,?,(SELECT JNO FROM JOB WHERE JNAME = ?))";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("�̸��� �Է��ϼ���");
					pstmt.setString(1, sc.next());
					System.out.println("���� ������ �Է��ϼ��� ");
					pstmt.setInt(2, sc.nextInt());
					System.out.println("���� ������ �Է��ϼ���");
					pstmt.setInt(3, sc.nextInt());
					System.out.println("���� ������ �Է��ϼ��� ");
					pstmt.setInt(4, sc.nextInt());
					System.out.println("������ �Է��ϼ���");
					pstmt.setString(5, sc.next());
					int result = pstmt.executeUpdate();
					System.out.println((result > 0) ? "�Է� ����" : "�Է� ����");
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
				sql = "SELECT ROWNUM ���,PNAME, JNAME, KOR, ENG, MAT, TOT FROM( SELECT PNO, PNAME||'('||PNO||'��)' PNAME , JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) TOT"
						+ " FROM PERSON P, JOB J WHERE P.JNO=J.JNO AND JNAME = ? ORDER BY TOT DESC)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					System.out.println("������(���, ����, ����)?");
					pstmt.setString(1, sc.next());
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("���\t�̸�\t\t����\t����\t����\t����\t����");
						do {
							int rownum = rs.getInt("���");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int tot = rs.getInt("tot");
							System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\n", rownum, pname, jname, kor, eng, mat, tot);
						} while (rs.next());
					}else {
						System.out.println("�ش� ������ �θ������� �����ϴ�.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "3":
				sql = "SELECT ROWNUM ���, PNO, PNAME, JNAME, KOR, ENG, MAT, TOT" + 
						" FROM( SELECT PNO, PNAME, JNAME, KOR, ENG, MAT, (KOR+ENG+MAT) TOT" + 
						" FROM PERSON P, JOB J WHERE P.JNO=J.JNO ORDER BY TOT DESC)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if (rs.next()) {
						System.out.println("���\t�̸�\t\t����\t����\t����\t����\t����");
						do {
							int rownum = rs.getInt("���");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int tot = rs.getInt("tot");
							System.out.printf("%d\t%s\t%s\t%d\t%d\t%d\t%d\n", rownum, pname, jname, kor, eng, mat, tot);
						} while (rs.next());
					}else {
						System.out.println("�ش� ������ �θ������� �����ϴ�.");
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
