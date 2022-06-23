package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.memberDAO.MemberDAO;
import com.lec.memberDTO.MemberDTO;

public class MAllViewService implements Service {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPageNum = Integer.parseInt(pageNum);
		
		final int PAGESIZE = 3, BLOCKSIZE=5;
		int startRow = (currentPageNum-1)*PAGESIZE +1;
		int endRow   = startRow + PAGESIZE -1;
		// dao의 list(startRow, endRow) 실행결과를 request.setAttribute
		MemberDAO mDao = MemberDAO.getInstance();
		ArrayList<MemberDTO> members = mDao.listMemeber(startRow, endRow);
		request.setAttribute("mAllView", members);
		// totCnt, pageCnt, startPage, endPage, BLOCKSIZE, pageNum
		//    => request.setAttribute
		int totCnt = mDao.cntMember();
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPageNum-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage   = startPage + BLOCKSIZE -1 ;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("pageNum", currentPageNum);
	}
}
