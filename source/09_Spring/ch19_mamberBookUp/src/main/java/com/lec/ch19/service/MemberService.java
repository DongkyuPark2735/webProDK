package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.model.Member;

public interface MemberService {
	public int idConfirm(String mid);
	public int joinMember(Member member, HttpSession httpSession); 
	/* session에 값넣고, 메일 보내야함  */
	public String loginCheck(String mid, String mpw, HttpSession httpSession);
	public Member getMember(String mid);
	public int modifyMember(Member member);
	
}
