package com.lec.memberDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.memberDto.MemberDTO;

public class MemberDAO {
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	private DataSource ds;
	
	private static MemberDAO INSTANCE = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return INSTANCE;
	}
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		
	};
	
	// 로그인
	public MemberDTO loginMember(String mid, String mpw) {
		MemberDTO mdto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVCMEMBER WHERE MID = ? AND MPW = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mphoto = rs.getString("mphoto");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress");
				Date mrdate = rs.getDate("mrdate");
				mdto = new MemberDTO(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return mdto;
	}
	
	// 로그인시 중복체크
	public int loginCheck(String mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVCMEMBER WHERE MID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = SUCCESS;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 회원가입
	public int joinMember(MemberDTO mdto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVCMEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)" + 
				" VALUES(?, ?, ?, ?, ?, TO_DATE(?, 'YYYY/MM/DD'), ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getMid());
			pstmt.setString(2, mdto.getMpw());
			pstmt.setString(3, mdto.getMname());
			pstmt.setString(4, mdto.getMemail());
			pstmt.setString(5, mdto.getMphoto());
			pstmt.setDate(6, mdto.getMbirth());
			pstmt.setString(7, mdto.getMaddress());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 정보수정
	// 회원리스트
	// dto회원리스트 가져오기 
	// 회원수
	
	
	
	
	
	
}
