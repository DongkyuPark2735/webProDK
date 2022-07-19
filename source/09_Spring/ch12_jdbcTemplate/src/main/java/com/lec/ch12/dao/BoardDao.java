package com.lec.ch12.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.ch12.utill.Constant;
import com.lec.ch12.vo.BoardDTO;
public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private static BoardDao instance = new BoardDao();
	public JdbcTemplate template;
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	private BoardDao() {
		template = Constant.template;				
	}
	
	// 글목록
	public ArrayList<BoardDTO> boardList(){
		String sql = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP";
		
		ArrayList<BoardDTO> dtos = 
				(ArrayList<BoardDTO>)template.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class)); //query는 배열을 리턴할때 
					// 리턴타입										
		return dtos;
	}

	public ArrayList<BoardDTO> boardList(final int startRow,final int endRow){
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* " + 
				"           FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		return (ArrayList<BoardDTO>) template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, startRow); // anonimus로 할때 final이어야함?
				ps.setInt(2, endRow);
			}
		}, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
		
	// 글 갯수 
	public int getBoardTotCnt() {
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		return template.queryForObject(sql, Integer.class);
	}
	
	//원글쓰기
	public int write(final BoardDTO bDto) {
		String sql = "INSERT INTO MVC_BOARD "
				+ "(bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)" + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, " + 
				"            MVC_BOARD_SEQ.CURRVAL, 0,0, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setString(4, bDto.getBip());
			}
		}, Integer.class);
		// inert update delete는 변수 자료형 설정 안해도됨
	}
	
	// hit수 올리기
	private void hitUp(int bid) {
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID="+bid;
		template.update(sql);	
	}
	
	// 글 상세보기(글 상세볼 때 조회수도 올림)
	public BoardDTO contentView(int bid) {
		hitUp(bid);
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	// bid로 dto 가져오기 (답글쓰기 + 수정)
	public BoardDTO modifyView_replyView(int bid) {
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}

	// 글 수정하기
	public int modify(final BoardDTO bDto) {
		String sql = "UPDATE MVC_BOARD SET BNAME=?, " + 
				"                    BTITLE = ?, " + 
				"                    BCONTENT = ?, " + 
				"                    BIP = ?" + 
				"        WHERE BID=?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setString(4, bDto.getBip());
				pstmt.setInt(5, bDto.getBid());
			}
		});
	}
	
	
	// 글 삭제
	public int delete(int bid) {
		String sql = "DELETE FROM MVC_BOARD WHERE BID="+bid;
		return template.update(sql);
	}
	// 답변글 쓰기 전 작업 : stepA
	private void preReplyStepA(final int bgroup,final int bstep) {

		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 WHERE BGROUP=? AND BSTEP>?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bgroup);
				pstmt.setInt(2, bstep);
			}
		});
	}
	// 답변글 쓰기
	public int reply(final BoardDTO bDto) { // bname, btitle, bcontent, bip : 답변글에 대한 정보
		                             // bgroup, bstep, bindent : 원글에 대한 정보
		preReplyStepA(bDto.getBgroup(), bDto.getBstep());
		String sql = "INSERT INTO MVC_BOARD" + 
				" (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
				"    VALUES (MVC_BOARD_SEQ.NEXTVAL, ?,?,?, ?, ?, ?, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bDto.getBname());
				pstmt.setString(2, bDto.getBtitle());
				pstmt.setString(3, bDto.getBcontent());
				pstmt.setInt(4, bDto.getBgroup());
				pstmt.setInt(5, bDto.getBstep()+1);
				pstmt.setInt(6, bDto.getBindent()+1);
				pstmt.setString(7, bDto.getBip());
			}
		});
	}
}