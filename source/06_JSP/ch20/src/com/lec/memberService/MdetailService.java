package com.lec.memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.memberDao.MemberDAO;

public class MdetailService implements Service {

	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		String mid = reqeust.getParameter("mid");
		String pageNum = reqeust.getParameter("pageNum");
		
		MemberDAO mdao = MemberDAO.getInstance();
		
		reqeust.setAttribute("detailMemeber", mdao.getMemberDTO(mid));
		reqeust.setAttribute("pageNum", pageNum);
		
	}

}
