package com.lec.ch08.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@ModelAttribute("cnt") // 모든 함수에 적용
	public int cnt() {
		return 5; // 먼저 실행되고 요청에 해당하는 다른 메소드 다음 수행
	}
	@ModelAttribute("list") 
	public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("text1");
		list.add("text2");
		return list;
	}
	
	@RequestMapping(value = "/")
	public String input() {
		
		return "member/input";
	}
	
//	@RequestMapping(value = "studentId/*")
//	public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
//		String uri = request.getRequestURI(); // /ch09/studentId/aaa
//		String id = uri.substring(uri.lastIndexOf("/")+1);
//		id = URLDecoder.decode(id, "utf-8");
//		model.addAttribute("id", id);
//				
//		return "member/studentId";
//	}
	@RequestMapping(value = "studentId/{id}")
	public String studentId1(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		return "member/studentId";
	}
}


















