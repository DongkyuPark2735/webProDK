package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.adminDAO.AdminDAO;

public class AdminLoginService implements Service {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		
		AdminDAO adao = AdminDAO.getInstance();
		
		int result = adao.loginCheckAdmin(aid, apw);
		
		if(result==AdminDAO.LOGIN_SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", adao.getAdmin(aid));
		}else {
			request.setAttribute("adminLoginResultMSG", "아이디와 비밀번호를 확인하세요");
		}
	}
}
