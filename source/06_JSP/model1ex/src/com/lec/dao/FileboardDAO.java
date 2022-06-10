package com.lec.dao;

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

import com.lec.dto.CustomerDTO;
import com.lec.dto.FileboardDTO;

public class FileboardDAO {
	public static final int SUCCESS = 1;
	public static final int FAIl = 0;

	private static FileboardDAO INSTANCE = new FileboardDAO();

	public static FileboardDAO getInstance() {
		return INSTANCE;
	}

	private FileboardDAO() {
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		Context ctx;
		try {
			ctx = new InitialContext(); 
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g"); 
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
			
	//-- 1. 글목록 TOP N
	public ArrayList<FileboardDTO> listBoard(int startRow, int endRow){
		ArrayList<FileboardDTO> dtos = new ArrayList<FileboardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				" FROM(SELECT ROWNUM RN, A.*" + 
				" FROM ( SELECT F.*, CNAME, CEMAIL" + 
				" FROM FILEBOARD F, CUSTOMER C" + 
				" WHERE F.CID = C.CID ORDER BY FREF DESC, FRE_STEP)A )" + 
				" WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int fnum = rs.getInt("fnum");
				String cid = rs.getString("cid");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				String fpw = rs.getString("fpw");
				int fhit = rs.getInt("fhit");
				int fref = rs.getInt("fref");
				int fre_step = rs.getInt("fre_step");
				int fre_level = rs.getInt("fre_level");
				String fip = rs.getString("fip");
				Date frdate = rs.getDate("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				dtos.add(new FileboardDTO(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, fre_step,
																		fre_level, fip, frdate, cname, cemail));
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	
	//-- 2. 등록된 글 수
	public int getFileboardCnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM FILEBOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt("cnt");
		//	totCnt = rs.getInt(1);
			
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totCnt;
	}

	//-- 3. 원글쓰기
	public int insertBoard(FileboardDTO dto) {
		int result = FAIl;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)" + 
				"    VALUES (FILEBOARD_SQ.nextval, ?, ?, ?, ?, ?, FILEBOARD_SQ.CURRVAL, 0,0,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setString(6, dto.getFip());
//			pstmt.executeUpdate();
//			result = SUCCESS;
			result = pstmt.executeUpdate();
			System.out.println("원글 쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "원글쓰기 실패 : " + dto);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	//-- 4. 답변글 전 SETP A -- 8번글에 대한 답변글 쓰기 전작업
	private void preReplyStepA(int fref, int fre_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FRE_STEP = FRE_STEP +1 WHERE FREF= ? AND FRE_STEP > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fref);
			pstmt.setInt(2, fre_step);
			int result = pstmt.executeUpdate();
			System.out.println(result==0 ? "첫댓글" : result+"행 step 조정");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	//-- 5. 답변글 쓰기 --
	public int reply(FileboardDTO dto) {
		//fref, fre+step, fre_lever : 원글의 정보 
		// CID, FSUBJECT, FCONTENT, FFILENAME, FPW, fip : 답변글의 정보
		preReplyStepA(dto.getFref(), dto.getFre_step());
		int result = FAIl;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD(FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)" + 
					" VALUES (FILEBOARD_SQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setString(5, dto.getFpw());
			pstmt.setInt(6, dto.getFref()); // 답변글은 원글의 fref
			pstmt.setInt(7, dto.getFre_step()+1); // 답변글은 원글의 fre_step +1
			pstmt.setInt(8, dto.getFre_level()+1); // 답변글은 원글의 fre_level+1
			pstmt.setString(9, dto.getFip());
//			pstmt.executeUpdate();
//			result = SUCCESS;
			result = pstmt.executeUpdate(); //실패하면 catch절로 어떻게 빠짐?
			System.out.println("답글 쓰기 성공");
		} catch (SQLException e) {
			dto.setFre_step(dto.getFre_step()+1);
			dto.setFre_level(dto.getFre_level()+1);
			System.out.println(e.getMessage() + "답글쓰기 실패 : " + dto);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
    //-- 6. 글 상세보기/글수정(FNUM으로 DTO가져오기)
	public FileboardDTO getBoard(int fnum) {
		FileboardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FILEBOARD WHERE FNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cid = rs.getString("cid");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				String fpw = rs.getString("fpw");
				int fhit = rs.getInt("fhit");
				int fref = rs.getInt("fref");
				int fre_step = rs.getInt("fre_step");
				int fre_level = rs.getInt("fre_level");
				String fip = rs.getString("fip");
				Date frdate = rs.getDate("frdate");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				dto = new FileboardDTO(fnum, cid, fsubject, fcontent, ffilename, fpw, fhit, fref, fre_step,
																		fre_level, fip, frdate, cname, cemail);
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// 조회수 올리기
	public void hitUp(int fnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FNUM= ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	//-- 7. 글 수정하기
	public int updateBoard(FileboardDTO dto) {
		int result = FAIl;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD" + 
				" SET FSUBJECT = ?," + 
				" FCONTENT = ?," + 
				" FFILENAME = ?," + 
				" FPW = ?," + 
				" FIP = ?" + 
				" WHERE FNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFnum());
			
//			pstmt.executeUpdate();
//			result = SUCCESS;
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글 수정 성공" : "해당 글번호가 없습니다.글수정 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 수정 실패 : " + dto);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	

	//-- 8. 글 삭제하기
	public int deleteBoard(int fnum, String fpw) {
		int result = FAIl;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FNUM = ? AND FPW = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setString(2, fpw);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글 삭제 성공" : "글 삭제 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글 삭제 실패 : " );
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
		
	
	}
	
	
	
}
