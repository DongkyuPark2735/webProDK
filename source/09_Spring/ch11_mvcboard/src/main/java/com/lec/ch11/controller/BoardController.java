package com.lec.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.bservice.BContentService;
import com.lec.ch11.bservice.BDeleteService;
import com.lec.ch11.bservice.BModifyReplyViewService;
import com.lec.ch11.bservice.BModifyService;
import com.lec.ch11.bservice.BReplyService;
import com.lec.ch11.bservice.BWriteService;
import com.lec.ch11.bservice.BlistService;
import com.lec.ch11.bservice.Service;
import com.lec.ch11.vo.BoardDTO;

@Controller
@RequestMapping("mvcboard")
// 공통요청경로 "mvcboard" 설정 
public class BoardController {
	
	private Service bservice; 
	
	@RequestMapping(value =  "list", method = {RequestMethod.GET, RequestMethod.POST})
	//get방식으로 요청된 list.do와 post방식으로 요청된 list.do를 모두 받는다.
	public String list(String pageNum, Model model) { 
					 //매개변수 pageNum에 같은 이름의 파라미터가 붙는다.
		model.addAttribute("pageNum", pageNum); 
			// BlistService에 전달하기위해 model에 addAttribute한다
		bservice = new BlistService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	
	@RequestMapping(value =  "writeView", method = RequestMethod.GET)
	public String writeView() { 
		return "mvcboard/writeView";
	}
	
	@RequestMapping(value =  "write", method = RequestMethod.POST)
	public String write(@ModelAttribute("bdto") BoardDTO boardDTO, Model model,
						HttpServletRequest request) {
		model.addAttribute("request", request); 
	 // BWriteService에서 request.getRemoteAddr()'ip추출'을 위한 addAttribute   
		bservice = new BWriteService();
		bservice.execute(model);
		return "forward:list.do"; 
	  //forward시 해당 Controller에서 이루어지기때문에 공통요청경인 "mvcboard"를 제외해야한다.
	  
	  //return "redirect:list.do?pageNum=1 ....."
	  //redirect시에는 재요청 명령어이기 때문에 필요한 파라미터를 같이 요청해주어야한다.
	}

	@RequestMapping(value =  "content", method = RequestMethod.GET)
	public String content(int bid, Model model) {
		model.addAttribute("bid", bid); 
		//String형과 기초데이터타입의 매개변수는 model에 자동으로 바인딩 되지않는다.
		bservice = new BContentService();
		bservice.execute(model);
		return "mvcboard/content";
	}
	@RequestMapping(value =  "content", method = RequestMethod.POST)
	public String content_post(int bid, Model model) {
		model.addAttribute("bid", bid); // 조회수를 올리지않고 dto가져오기
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/content";
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modifyView(int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/modify";
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("bdto") BoardDTO boardDTO, 
		HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		bservice = new BModifyService();
		bservice.execute(model);
		return "forward:content.do"; //파라미터 넘어감 
		//redirect 하려면 파라미터 넘겨줘야함
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BDeleteService();
		bservice.execute(model);
		return "forward:list.do";
	}

	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BModifyReplyViewService();// 조회수 올리지않고 bid로 dto가져오기
		bservice.execute(model);
		return "mvcboard/reply";
	}

	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String replyView(@ModelAttribute("bdto") BoardDTO boardDTO, Model model,
			HttpServletRequest request) {
		model.addAttribute("request", request);
		bservice = new BReplyService();
		bservice.execute(model);
		return "forward:list.do";
	}
	
	
	
	
	
	
}















