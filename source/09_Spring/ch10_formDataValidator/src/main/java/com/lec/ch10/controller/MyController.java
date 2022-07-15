package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.StudentVO;
import com.lec.ch10.vo.StudentValidator;

@Controller
public class MyController {

	
	@RequestMapping(value = "inputForm.do", method = RequestMethod.GET)
	public String inputForm() {
		return "ex/inputForm";
	}
	
	
	@RequestMapping(value = "input.do", method = RequestMethod.GET )
	public String input(StudentVO studentVO, Errors errors, Model model) {
		String viewPage = "ex/inputResult";
		//검증객체를 이용해서 검증 method호출
		//검증은 객체 dto로만 가능?
		StudentValidator validator = new StudentValidator();
		validator.validate(studentVO, errors);
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 필수 입력사항");
			}
			if(errors.getFieldError("id") != null) {
				model.addAttribute("idError", "id는 자연수입니다.");
			}
			return "ex/inputForm";
		}
		/*
		 * if(에러를 잡았다.){ 
		 	  에러난 곳 점검 메세지 model에 add
		 * 	  viewPage = "ex/inputForm"
		 *
		 */		
		
		
		return "ex/inputResult";
	}
}
