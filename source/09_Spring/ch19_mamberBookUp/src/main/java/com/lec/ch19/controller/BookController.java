package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.model.Book;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;

@Controller
@RequestMapping(value = "/book.do")
public class BookController {

	@Autowired
	private BookService bookservice;
	
	@RequestMapping(params = "method=list", method = {RequestMethod.GET, RequestMethod.POST})
	public String bookList(String pageNum, Model model) {
		Paging paging = new Paging(bookservice.totCntBook(), pageNum, 3, 3); 
		model.addAttribute("bookList", bookservice.bookList(pageNum));
		model.addAttribute("paging", paging);
		return "book/bookList";
	}
	
	@RequestMapping(params = "method=detail", method = {RequestMethod.GET,RequestMethod.POST})
	public String bookDetail(String pageNum, Model model, int bnum) {
		model.addAttribute("bookModel", bookservice.getDetailBook(bnum));
		model.addAttribute("pageNum", pageNum);
		
		return "book/bookDetail";
	}

	@RequestMapping(params = "method=modify", method = RequestMethod.GET)
	public String bookmodify(String pageNum, Model model, int bnum) {
		model.addAttribute("bookModel", bookservice.getDetailBook(bnum));
		model.addAttribute("pageNum", pageNum);
		return "book/bookModify";
	}
	
	@RequestMapping(params = "method=modify", method = RequestMethod.POST)
	public String bookmodify(Model model, Book book,MultipartHttpServletRequest mrequest){
		model.addAttribute("bookModifyResult", bookservice.modifyBook(book, mrequest));
		return "redirect:book.do?method=list";
	}

	@RequestMapping(params = "method=registerForm", method = RequestMethod.GET)
	public String registerForm(){
		return "book/registerForm";
	}

	@RequestMapping(params = "method=register", method = RequestMethod.POST)
	public String register(Book book, Model model, MultipartHttpServletRequest mrequest){
		model.addAttribute("registerResult", bookservice.registerBook(book, mrequest));
		return "redirect:book.do?method=list";
	}

	@RequestMapping(params = "method=searchList", method = RequestMethod.POST)
	public String searchList(Book book, Model model, MultipartHttpServletRequest mrequest){
//		Paging paging = new Paging(bookservice.totCntBook(), pageNum, 3, 3); 
//		model.addAttribute("bookList", bookservice.bookList(pageNum));
//		model.addAttribute("paging", paging);
//		
		model.addAttribute("registerResult", bookservice.registerBook(book, mrequest));
		return "redirect:book.do?method=list";
	}
	
	
}








