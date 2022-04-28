package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO {
	private static CustomerDAO INSTANCE;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int SUCCESS = 1;
	public static int FAIL = 0;

	public static CustomerDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerDAO();
		}
		return INSTANCE;
	}

	public CustomerDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public int insertCustomer(String cphone, String cname, int cpoint) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = FAIL;
		String sql = "INSERT INTO CUSTOMER(CNO, CPHONE, CNAME, CPOINT) " + "VALUES(CUSTOMER_SQ.NEXTVAL, ?, ?,?)";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cphone);
			pstmt.setString(2, cname);
			pstmt.setInt(3, cpoint);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return rs;
	}

	public ArrayList<CustomerDTO> selectCustomerPhone(String cphone) {
		ArrayList<CustomerDTO> cdto = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CNO, CPHONE, CNAME, CPOINT FROM CUSTOMER WHERE CPHONE LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cphone);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cno = rs.getInt("cno");
				String tempcphone = rs.getString("cphone");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				cdto.add(new CustomerDTO(cno, tempcphone, cname, cpoint));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return cdto;
	}
	public ArrayList<CustomerDTO> selectAllCustomer() {
		ArrayList<CustomerDTO> cdto = new ArrayList<CustomerDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CNO, CPHONE, CNAME, CPOINT FROM CUSTOMER";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cno = rs.getInt("cno");
				String cphone = rs.getString("cphone");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				cdto.add(new CustomerDTO(cno, cphone, cname, cpoint));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return cdto;
	}
	

}
