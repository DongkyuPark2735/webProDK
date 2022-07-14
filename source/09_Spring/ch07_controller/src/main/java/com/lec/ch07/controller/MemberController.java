package com.lec.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member") // 공통 요청 경로
public class MemberController {
	
	@RequestMapping(params = "method=join", method = RequestMethod.GET)
	//해당 파라미터 있으면 아래 실행 
	public String join(Model model) {
		model.addAttribute("king", "회원");
		return "member/join";
	}
	// /member?method=login&id=aaa&pw=111
	@RequestMapping(params = "method=login")
	//method 안쓰면 두가지 방식 다 유효?
	public String login(Model model) {
		model.addAttribute("result", "login");
		return "member/result";
	}
	//param.id 가능?
	@RequestMapping(params = "method=logout")
	public String logout(Model model) {
		model.addAttribute("result", "logout");
		return "member/result";
	}

	@RequestMapping(params = "method=infoModify")
	public String infoModify(Model model) {
		model.addAttribute("result", "infoModify");
		return "member/result";
	}
	
}
