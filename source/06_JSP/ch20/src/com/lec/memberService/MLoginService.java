package com.lec.memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.memberDao.MemberDAO;

public class MLoginService implements Service {
	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		String mid = reqeust.getParameter("mid");
		String mpw = reqeust.getParameter("mpw");
		
		MemberDAO mdao = MemberDAO.getInstance();
		
		HttpSession session = reqeust.getSession();
		int result = mdao.loginMember(mid, mpw);
		
		if(result==MemberDAO.SUCCESS) {
			session.setAttribute("member", mdao.getMemberDTO(mid));
			//reqeust.setAttribute("mid", mid);
		}else {
			reqeust.setAttribute("loginFailMSG", "아이디와 비밀번호를 확인하세요");
		}
		
	}

}
