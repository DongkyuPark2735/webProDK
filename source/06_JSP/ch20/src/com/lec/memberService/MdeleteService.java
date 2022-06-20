package com.lec.memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.memberDao.MemberDAO;

public class MdeleteService implements Service {

	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		String mid = reqeust.getParameter("mid");
		String mpw = reqeust.getParameter("mpw");
		HttpSession session = reqeust.getSession();
		
		MemberDAO mdao = MemberDAO.getInstance();
		
		int result = mdao.deleteMember(mid, mpw);
		
		if(result==MemberDAO.FAIL) {
			reqeust.setAttribute("deleteFailMSG", "탈퇴 실패, 비밀번호 오류");
		}else if(result==MemberDAO.SUCCESS) {
			reqeust.setAttribute("deleteSuccessMSG", "탈퇴 성공");
			session.invalidate();
		}
	}
}
