package com.lec.ch07.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;

// board/write, board/content, board/list, board/reply
@Controller
@RequestMapping("/board")// 공통요청경로 
public class BoardController {
	@RequestMapping("/write")//조합된 요청경로    슬래시'/'넣어도 무관 
	public String write() {
		return "board/write"; // 뷰 : /WEB-INF/views/board/write.jsp
	}

	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String content(Model model) {
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "111");
		Member member = new Member("bbb", "222");
		model.addAttribute("member", member);
		
		return "board/content"; 
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		//ModelAndView 모델이랑 뷰 같이들어있음?
		Member member = new Member("ccc", "111");
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(member);
		
		mav.addObject("list", list); //model.addAttribute() 
		mav.setViewName("board/list");// 뷰
		
		return mav; 
	}
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public ModelAndView reply(ModelAndView mav) {
		//매개변수의 ModelAndView 객체가 없으면 알아서 생성해서 매개변수로 넣어줌
		Member member = new Member("fff", "111");
		mav.addObject("member", member);
		mav.setViewName("board/reply");

		return mav; 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
