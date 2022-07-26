package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.model.Member;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping(value = "/member.do")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping( params = "method=loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping( params = "method=login", method = RequestMethod.POST)
	public String login(Model model, HttpSession httpsession, Member member) {
		model.addAttribute("loginResult", 
					memberService.loginCheck(member.getMid(), member.getMpw(), httpsession));
		return "forward:main.do";
		
	}
	
	@RequestMapping(params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		int result = memberService.idConfirm(mid);
		if(result != 1) {
			model.addAttribute("idConfirmResult", "사용가능한 ID입니다");
		}else {
			model.addAttribute("idConfirmResult", "중복된 ID입니다.");
		}
		return "confirm/idConfirm";
	}

	@RequestMapping( params = "method=joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}

	@RequestMapping( params = "method=join", method = RequestMethod.POST)
	public String join(@ModelAttribute("memberModel") Member member, 
						HttpSession httpsession, Model model) {
		model.addAttribute("joinResult", memberService.joinMember(member, httpsession));
		return "forward:member.do?method=loginForm";
	}
	
	
	@RequestMapping( params = "method=logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession httpsession) {
		httpsession.invalidate();
		model.addAttribute("logoutResult", "로그아웃 되었습니다.");
		return "forward:main.do";
	}

	@RequestMapping( params = "method=modifyForm", method = RequestMethod.GET)
	public String modifyForm(Model model, HttpSession httpsession) {
		model.addAttribute("memberModel",  memberService.getMember((String)httpsession.getAttribute("mid")));
		return "member/modifyForm";
	}

	@RequestMapping( params = "method=modify", method = RequestMethod.POST)
	public String modifyForm(Model model, HttpSession httpsession, Member member) {
		model.addAttribute("modifyResult", memberService.modifyMember(member));
		httpsession.setAttribute("member", memberService.getMember(member.getMid()));
		return "forward:main.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
