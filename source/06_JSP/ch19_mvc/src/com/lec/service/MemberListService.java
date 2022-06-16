package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDAO;
import com.lec.dto.MemberDTO;

public class MemberListService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = MemberDAO.getInsetance();
		ArrayList<MemberDTO> member = dao.listMember();
		request.setAttribute("memberList", member);
	}
}
