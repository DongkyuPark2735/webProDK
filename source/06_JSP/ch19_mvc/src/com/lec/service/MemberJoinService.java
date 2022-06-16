package com.lec.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDAO;
import com.lec.dto.MemberDTO;

public class MemberJoinService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = MemberDAO.getInsetance();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");

		Timestamp birth = null;
		if(!request.getParameter("birth").equals("")) {
			birth = Timestamp.valueOf(request.getParameter("birth")+" 00:00:00");
		}
		MemberDTO member = new MemberDTO(id, pw, name, birth, null);
		int result = dao.joinMember(member);
		request.setAttribute("joinResult", result);
	}

}
