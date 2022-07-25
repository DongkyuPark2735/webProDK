package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.model.Member;
import com.lec.ch19.service.MemberService;

@Service
@RequestMapping(value = "/member.do")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping( params = "method=loginForm", method = RequestMethod.GET)
	public String loginForm() {
		
		return "member/loginForm";
	}
	
	@RequestMapping(params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid) {
		
		return "confirm/idConfirm";
	}
	

	@RequestMapping( params = "method=join", method = RequestMethod.POST)
	public String join(Model model, Member member) {
		
		
		return "member/loginForm";
	}
	
	
	
}
