package com.lec.ch08.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberVO;

@Controller
@RequestMapping("member")
public class MemberController {
	@ModelAttribute("cnt") 
	public int cnt() {
		return 5; 
	}
	@ModelAttribute("list") 
	public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("text1");
		list.add("text2");
		return list;
	}
	
	@RequestMapping(value = "join1", method = RequestMethod.GET)
	public String join1(HttpServletRequest request, Model model) { //member/join1
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);

		return "member/result1";
	}

	@RequestMapping(value = "join2", method = RequestMethod.GET)
	public String join2(
		//name이라는 파라미터를 membername에 넣어라
		@RequestParam("name") String membername, @RequestParam("id") String memberid,
		@RequestParam("pw") String memberpw, @RequestParam("age") int age,
		@RequestParam("email") String memberemail, @RequestParam("address") String memberaddress,
		Model model) { 
		
		model.addAttribute("name", membername);
		model.addAttribute("id", memberid);
		model.addAttribute("pw", memberpw);
		model.addAttribute("age", age);
		model.addAttribute("email", memberemail);
		model.addAttribute("address", memberaddress);
		
		return "member/result1";
	}
	
	@RequestMapping(value = "join3", method = RequestMethod.GET)
	public String join3(String name, String id, String pw, int age,
			String email, String address,Model model) { 
				//파라미터 이름이랑 같은 매개변수가 있으면 해당 파라미터가 매개변수에 저장된다.
				//없으면 null
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		
		return "member/result1";
	}

//	@RequestMapping(value = "join4", method = RequestMethod.GET)
//	public String join4(String name, String id, String pw, int age,
//			String email, String address,Model model) { 
//		MemberVO member = new MemberVO();
//		member.setName(name);
//		member.setName(name);
//		member.setName(name);
//		member.setName(name);
//		member.setName(name);
//		return "member/result1";
//	}
	
	@RequestMapping(value =  "join4")
	// 파라미터의 이름이랑 객체의 필드명이랑 같으면 붙음 
	public String join4(MemberVO memberVO, Model model) {
		
		//MemberVO memberVO 이름은 반드시 앞의 클래스 명에서 맨앞 대문자만 소문자로
		model.addAttribute("member", memberVO);
		//클래스 명으로  memberVO 로도 addAttribute됨
		return "member/result4";
	}
	
	@RequestMapping("join5")
	public String join5(MemberVO memberVO /* ,Model model */) {
		//반드시 매개변수 없는 생성자가 있어야함 set을 자동적으로 해줌 
		// model.addAttribute("memberVO", memberVO);
		return "member/result5";
	}
	
	@RequestMapping("join6")
	public String join6(@ModelAttribute("ff") MemberVO memberVO) {
		// 'ff'라는 이름으로 addAttribute한다 MemberVO memberVO로 파라미터 받아서
		return "member/result4";
	}
	
	
}











