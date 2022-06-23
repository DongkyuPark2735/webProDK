package com.lec.adminDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.adminDTO.AdminDTO;


public class AdminDAO {
	public static final int LOGIN_FAIL    = 0;
	public static final int LOGIN_SUCCESS = 1;
	private static AdminDAO instance = new AdminDAO();
	public static AdminDAO getInstance() {
		return instance;
	}
	private AdminDAO() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// (1) admin loginCheck
	public int loginCheckAdmin(String aId, String aPw) {
		int result = LOGIN_FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM ADMIN WHERE AID=? AND APW=?";
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, aId);
			pstmt.setString(2, aPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = LOGIN_SUCCESS;
			}			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	
	// (2) 로그인 후 세션에 넣을 용도 : admin aid로 dto 가져오기
	public AdminDTO getAdmin(String aId) {
		AdminDTO admin = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM ADMIN WHERE AID=?";
		try {
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, aId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				admin = new AdminDTO();
				admin.setAid(rs.getString("aId"));
				admin.setApw(rs.getString("aPw"));
				admin.setAname(rs.getString("aName"));
			}			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return admin;
	}
}
