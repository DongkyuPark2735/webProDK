package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.memberDAO.MemberDAO;

public class emailChkService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		
		MemberDAO mdao = MemberDAO.getInstance();
		
		int result = mdao.emailCheckMember(memail);
		
		if(result == MemberDAO.NONEXIST) {
			request.setAttribute("emailChkResult", "사용가능한 이메일");
		}else {
			request.setAttribute("emailChkResult", "중복된 이메일");
		}
	}
}
