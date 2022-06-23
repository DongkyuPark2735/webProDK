package com.lec.memberDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.lec.memberDTO.MemberDTO;
public class MemberDAO {
	public final static int EXIST = 1;
	public final static int NONEXIST = 0;
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
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	};
	
	//로그인
	public int loginMember(String mid, String mpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC2MEMBER WHERE mID= ? and mPW= ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = SUCCESS;
			}
		} catch (SQLException e) {
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

	//mid로 dto가져오기
	public MemberDTO getMemberDTO(String mid) {
		MemberDTO mdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC2MEMBER WHERE MID= ? ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mphoto = rs.getString("mphoto");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress");
				Date mrdate = rs.getDate("mrdate");
				mdto= new MemberDTO(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
			}
		} catch (SQLException e) {
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
		return mdto;
	}
	
	
	// 회원가입시 ID중복체크
	public int idCheckMember(String mid) {
		int result = NONEXIST;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC2MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = EXIST;
			}
		} catch (SQLException e) {
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
	
	// 회원가입시 mEmail중복체크
	public int emailCheckMember(String memail) {
		int result = NONEXIST;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC2MEMBER WHERE MEMAIL = ? ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = EXIST;
			}
		} catch (SQLException e) {
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
	
	// 회원가입
	public int joinMember(MemberDTO mdto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC2MEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)" +
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
	
	//회원 정보 수정
	public int modifyMember(MemberDTO mdto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC2MEMBER SET MPW = ?," + 
										" MNAME = ?," + 
										" MEMAIL = ?," + 
										" MPHOTO = ?," + 
										" MBIRTH = TO_DATE( ?, 'YYYY/MM/DD')," + 
										" MADDRESS = ?" + 
										" WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mdto.getMpw());
			pstmt.setString(2, mdto.getMname());
			pstmt.setString(3, mdto.getMemail());
			pstmt.setString(4, mdto.getMphoto());
			pstmt.setDate(5, mdto.getMbirth());
			pstmt.setString(6, mdto.getMaddress());
			pstmt.setString(7, mdto.getMid());
			result = pstmt.executeUpdate();
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
		return result;
	}

	//회원 리스트 출력
	public ArrayList<MemberDTO> listMemeber(int startRow, int endRow){
		ArrayList<MemberDTO> mdtos = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM" + 
				" (SELECT * FROM MVC2MEMBER ORDER BY mRDATE DESC) A) " + 
				" WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mphoto = rs.getString("mphoto");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress");
				Date mrdate = rs.getDate("mrdate");
				mdtos.add(new MemberDTO(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate));
			}
		} catch (SQLException e) {
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
		return mdtos;
	}
	
	// 회원수
	public int cntMember() {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM MVC2MEMBER";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt("cnt");
		} catch (SQLException e) {
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
	
	//회원탈퇴
	public int deleteMember(String mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVC2MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
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
		return result;
	}
	
}



