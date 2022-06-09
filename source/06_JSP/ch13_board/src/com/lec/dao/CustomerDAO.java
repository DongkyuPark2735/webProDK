package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lec.dto.CustomerDTO;

public class CustomerDAO {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private static CustomerDAO INSTANCE;
	
	public static CustomerDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new CustomerDAO();
		}
		return INSTANCE;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctext = new InitialContext();
			DataSource ds = (DataSource)ctext.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection(); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	//정보가져오기
	public CustomerDTO getCustomerInfo(String cid) {
		CustomerDTO cdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cpw = rs.getString("cpw");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				String cemail = rs.getString("cemail");
				String caddress = rs.getString("caddress");
				String cgender = rs.getString("cgender");
				Date cbirth = rs.getDate("cbirth");
				Date crdate = rs.getDate("crdate");
				cdto = new CustomerDTO(cid, cpw, cname, ctel, cemail, caddress, cgender, cbirth, crdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return cdto;
	}
	// 회원가입
	public int joinCustomer(CustomerDTO dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER(CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE)" + 
				" VALUES(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setString(7, dto.getCgender());
			pstmt.setDate(8, dto.getCbirth());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//회원 정보 수정
	public int modifyCustomer(CustomerDTO dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET" + 
						" CPW = ?," + 
						" CNAME = ?," + 
						" CTEL = ?," + 
						" CEMAIL = ?," + 
						" CADDRESS = ?," + 
						" CGENDER = ?," + 
						" CBIRTH = ?" + 
						" WHERE CID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setString(6, dto.getCgender());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCid());
			
			result = pstmt.executeUpdate();
		
			if(result == SUCCESS) {
				result = SUCCESS;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	//로그인 확인
	public int checkLoginCustomer(String cid, String cpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID = ? AND CPW = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = SUCCESS;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
		  try {
			  if(rs!=null)rs.close();
			  if(pstmt!=null)pstmt.close();
			  if(conn!=null)conn.close();
		  } catch (SQLException e) {
			  System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//id 중복확인
		public int checkIDCustomer(String cid) {
			int result = SUCCESS;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = FAIL;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}finally {
			  try {
				  if(rs!=null)rs.close();
				  if(pstmt!=null)pstmt.close();
				  if(conn!=null)conn.close();
			  } catch (SQLException e) {
				  System.out.println(e.getMessage());
				}
			}
			return result;
		}	
}





















