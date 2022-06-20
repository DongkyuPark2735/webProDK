package com.lec.memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MLogoutService implements Service {

	@Override
	public void excute(HttpServletRequest reqeust, HttpServletResponse response) {
		HttpSession session = reqeust.getSession();
		session.invalidate();
		reqeust.setAttribute("logOutMSG", "로그아웃 되었습니다");
		
	}

}
