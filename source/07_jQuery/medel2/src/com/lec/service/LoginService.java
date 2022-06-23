package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.memberDAO.MemberDAO;

public class LoginService implements Service {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDAO mdao = MemberDAO.getInstance();
		
		int result = mdao.loginMember(mid, mpw);
		
		if(result == MemberDAO.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("member", mdao.getMemberDTO(mid));
		}else if(result == MemberDAO.FAIL){
			request.setAttribute("loginResultMSG", "아이디와 비밀번호를 확인하세요");
		}
	}
}
