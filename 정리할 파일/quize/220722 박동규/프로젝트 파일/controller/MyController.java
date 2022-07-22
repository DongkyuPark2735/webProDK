package com.lec.my.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.my.model.Myboard;
import com.lec.my.service.MyboardService;
import com.lec.my.util.Paging;

@Controller
public class MyController {
	
	@Autowired
	private MyboardService myboardService;
	
	@ModelAttribute("ipAddress")
	public String ipAddress(HttpServletRequest request){
		return request.getRemoteAddr();
	}
	
	
	@RequestMapping(value = "boardList", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardList(Model model, String pageNum) {
		model.addAttribute("myboardList", myboardService.listMyboard(pageNum));
		model.addAttribute("paging", new Paging(myboardService.totCnt(), pageNum, 10, 5));
		return "boardList";
	}
	
	@RequestMapping(value = "boardWriteView", method = RequestMethod.GET)
	public String boardWriteView(Model model, String pageNum) {
		return "boardWrite";
	}

	@RequestMapping(value = "boardWrite", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardWrite(Myboard myboard ,Model model, @ModelAttribute("ipAddress") String ipAddress) {
		myboard.setBip(ipAddress);
		model.addAttribute("boardWriteResult", myboardService.insertMyboard(myboard));
		return "forward:boardList.do";
	}
	
	@RequestMapping(value = "boardContent", method = {RequestMethod.GET,RequestMethod.POST})
	public String boardContent(Model model, String pageNum, int bid) {
		model.addAttribute("bdto", myboardService.detailMyborad(bid));
		return "boardContent";
	}

	@RequestMapping(value = "boardModify", method = RequestMethod.GET)
	public String boardModify(Model model, String pageNum, int bid) {
		model.addAttribute("bdto", myboardService.detailMyborad(bid));
		return "boardModify";
	}
	
	@RequestMapping(value = "boardModify", method = RequestMethod.POST)
	public String boardModify(Model model, String pageNum, Myboard myboard, @ModelAttribute("ipAddress") String ipAddress) {
		myboard.setBip(ipAddress);
		model.addAttribute("modifyMyboradResult", myboardService.modifyMyborad(myboard));
		return "forward:boardContent.do";
	}
	
	@RequestMapping(value = "boardDelete", method = RequestMethod.GET)
	public String boardDelete(Model model, String pageNum, int bid) {
		model.addAttribute("boardDeleteResult", myboardService.deleteMyboard(bid));
		return "forward:boardList.do";
	}

	@RequestMapping(value = "boardReply", method = RequestMethod.GET)
	public String boardReply(Model model, String pageNum, int bid) {
		model.addAttribute("bdto", myboardService.detailMyborad(bid));
		return "boardReply";
	}

	@RequestMapping(value = "boardReply", method = RequestMethod.POST)
	public String boardReply(Model model, Myboard myboard, String pageNum, @ModelAttribute("ipAddress") String ipAddress) {
		myboard.setBip(ipAddress);
		model.addAttribute("insertReplyResult", myboardService.insertReply(myboard));
		return "forward:boardList.do";
	}
	
	
	
	
	
	
	
}
