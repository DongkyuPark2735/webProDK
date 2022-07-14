package com.lec.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	//http://localhost:8090/ch07/ 요청처리
	
	@RequestMapping(value =  "/" )
	public String home(Model model ) {
					//전달하려는 객체는 모델에 
		model.addAttribute("greeting", "안녕하세요, 스프링");
		//model 범위 requestscope
		return "main"; //뷰이름 리턴해야함 // view : /WEB-INF/views/main.jsp
	}
}
