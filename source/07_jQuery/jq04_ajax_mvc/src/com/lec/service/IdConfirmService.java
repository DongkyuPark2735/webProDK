package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.DAO.MemberDAO;

public class IdConfirmService implements Service {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		
		MemberDAO mdao = MemberDAO.getInstance();
		
		int result = mdao.loginCheck(mid);
		if(result==MemberDAO.SUCCESS) {
			request.setAttribute("idConfirmResult", "사용가능한 ID입니다");
		}else {
			request.setAttribute("idConfirmResult", "중복된 ID입니다.");
		}
	}
}
