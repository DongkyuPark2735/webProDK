package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDaoConn {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int MEMBER_EXISTENT = 0; // 중복된 id일떄 리턴값
	public static final int MEMBER_NONEXISTENT = 1; // 사용가능한 id일떄 리턴값
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공시 리턴값
	public static final int LOGIN_FAIL_ID = -1; // 로그인시 id오류일 때 리턴값
	public static final int LOGIN_FAIL_PW = 0; // 로그인시 pw오류일 때 리턴값

//	private static MemberDaoConn INSTANCE;
//
//	public static MemberDaoConn getInstance() {
//		if (INSTANCE == null) {
//			INSTANCE = new MemberDaoConn();
//		}
//		return INSTANCE;
//	}   //싱글톤 없어도됨?
//
//	private MemberDaoConn() {
//	}

	// DB연결 매소드 // conn객체 리턴하는 함수
	private Connection getConnection() throws SQLException{
		//커넥션풀의 DataSource안에 conn객체 이용
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			//javax.naming		//javax.naming.initial
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			//다른 데이터 타입으로 커넥션풀을 묶을수도 있음
			//ds안에 conn객체있음
			conn = ds.getConnection();
			//context안에 커넥션풀의 정보를 잘못 입력했을때의 오류발생
		} catch (NamingException e) {
			System.out.println("커넥션 풀 이름 오류 : " +e.getMessage());
		} 
		
		return conn;
	}

//	-- 1. 회원가입시 ID 중복체크 : public int confirmID(String id)
	public int confirmID(String id) {
		int result = MEMBER_EXISTENT;// 초기화
		// 중복인지 사용가능인지 sql로 조회 :
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
//			pstmt = getConnection().prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = MEMBER_EXISTENT; // 중복된 id 사용불가
			} else {
				result = MEMBER_NONEXISTENT; // 없는 id 사용가능
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		return result;
	}

//	-- 2. 회원가입 : public int joinMember(MemberDto dto)
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		// dto DB에 intert
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER(ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setTimestamp(9, dto.getBirth());
			pstmt.setString(10, dto.getAddress());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "회원가입성공" : "회원가입실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패 :" + dto);

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
		return result;
	}

//	-- 3. 로그인(ID/PW) : public int loginCheck(String id, String pw)
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID, PW FROM MEMBER WHERE ID=?";// 비밀번호와 id따로 입력확인 구분 받기위해
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 유효한 ID를 입력
				String pwDB = rs.getString("pw");
				if (pwDB.equals(pw)) { // pw가 맞는지 체크
					result = LOGIN_SUCCESS;
				} else {
					result = LOGIN_FAIL_PW;
				}
			} else { // 유효하지 않은 ID
				result = LOGIN_FAIL_ID;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		return result;
	}

//	-- 4. ID로 dto 가져오기 : public MemberDto getMember(String id)
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
//			pstmt = getConnection().prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				Timestamp birth = rs.getTimestamp("birth");
				Date rdate = rs.getDate("rdate");
				String address = rs.getString("address");
				dto = new MemberDto(id, pw, name, phone1, phone2, phone3, gender, email, birth, rdate, address);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "---");
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
		return dto;
	}

//	-- 5. 회원정보 수정 : public int modifyMember(MemberDto dto)
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET " + "PW = ?," 
									+ " NAME= ?," 
									+ " PHONE1 = ?,"
									+ " PHONE2 = ?," 
									+ " PHONE3 = ?,"
									+ " GENDER = ?," 
									+ " EMAIL = ?," 
									+ " BIRTH = ?," 
									+ " ADDRESS = ?" 
									+ " WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setTimestamp(8, dto.getBirth());
			pstmt.setString(9, dto.getAddress());
			pstmt.setString(10, dto.getId());
			
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "정보가 수정되었습니다." : "정보수정에 실패하였습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원수정 실패:" + dto);
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
		return result;
	}
}
