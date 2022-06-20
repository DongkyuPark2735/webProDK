package com.lec.memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.memberDao.MemberDAO;

public class MListService implements Service {
	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		String pageNum = reqeust.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 3, BLOCKSIZE = 5;
		int startRow = (currentPage-1)*PAGESIZE+1;
		int endRow = startRow + PAGESIZE - 1;
		
		MemberDAO dao = MemberDAO.getInstance();
		reqeust.setAttribute("list", dao.getListMember(startRow, endRow)); 
		
		int totalCnt = dao.getMemberCnt(); 
		int pageCnt = (int)Math.ceil((double)totalCnt/PAGESIZE); 
		int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE+1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage>pageCnt) {
			endPage = pageCnt;
		}
		
		reqeust.setAttribute("startPage", startPage);
		reqeust.setAttribute("endPage", endPage);
		reqeust.setAttribute("BLOCKSIZE", BLOCKSIZE);
		reqeust.setAttribute("pageNum", currentPage); 
		reqeust.setAttribute("pageCnt", pageCnt);
			
	}
}
