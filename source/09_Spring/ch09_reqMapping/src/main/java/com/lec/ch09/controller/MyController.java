package com.lec.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping(value = "main.do") /* .do 안붙여도 무방 / 이미 걸러졌기 때문?? */
												//메소드 방식으로 구분
	public String main() {
		return "main";
	}
	
//	@RequestMapping(value = "student.do")
//	public String student(String id, Model model, HttpServletRequest request) {
//		//파라미터명 "id"로 들어온것 String id에 붙음
//		String method = request.getMethod();
//		
//		model.addAttribute("method", method);
//		model.addAttribute("id", id);
//		// 뷰단에 전달을 위한   // class이름과 변수이름이 같은 객체로 받을때만 가능
//		
//		return "studenstId";
//		//리퀘스트객체가 새로 만들어 지지않기때문에 파라미터"id"가 뷰단까지 넘어간다
//	}

	@RequestMapping(value = "student.do", method = RequestMethod.GET)
	public String student(String id, Model model) {
		//파라미터명 "id"로 들어온것 String id에 붙음
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		// 뷰단에 전달을 위한   // class이름과 변수이름이 같은 객체로 받을때만 가능
		return "studentId";
		//리퀘스트객체가 새로 만들어 지지않기때문에 파라미터"id"가 뷰단까지 넘어간다
	}
	// 405 에러  method방식 에러
	
	@RequestMapping(value = "student.do", method = RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView model) {
		model.addObject("method", "POST");
		model.addObject("id", id);
		model.setViewName("studentId");
		return model;
	}
	
	@RequestMapping(value = "idConfirm.do", method = RequestMethod.GET)
	public String idConfirm(String id, Model model ) {
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			//return "redirect:studentOk.do";
			return "forward:studentOk.do";
			//forward or redirect jps로 가지않고 새로운 요청경로로 
			//fullpath도 들어감 https://www.naver.com
		}
		return "redirect:studentNg.do?id="+id;
	}
	
	//redirect 나 forward로 받을때 메소드 방식 같게 
	@RequestMapping(value = "studentOk.do", method = RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	
	//redirct 하기전 메소드 방식 같게
	@RequestMapping(value = "studentNg.do", method = RequestMethod.GET)
	public String studentNg(String id) {
		System.out.println(id);
		return "studentNg";
	}
	
	@RequestMapping(value = "fullpath.do", method = RequestMethod.GET)
	public String fullpath() {
		return "redirect:http://naver.com";
	}
	
}















