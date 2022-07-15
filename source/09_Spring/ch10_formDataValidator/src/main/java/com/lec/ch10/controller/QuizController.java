package com.lec.ch10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Student2VO;
import com.lec.ch10.vo.StudentValidator;

@Controller
public class QuizController {
	
	@ModelAttribute("totCnt")
	public int totCnt() {
		return 4;
	}
	
	@RequestMapping(value = "quizInput.do")
	public String quizInput() {
		return "quiz/quizInput";
	}

	@RequestMapping(value = "quizInput.do", method = RequestMethod.GET)
	public String quizInput(Model model) {
		return "quiz/quizInput";
	}
	
	@RequestMapping(value = "quizInput.do", method = RequestMethod.POST)
	public String quizInput(Student2VO student2VO, Errors errors,Model model) {
		int qkor = student2VO.getQkor();
		int qeng = student2VO.getQeng();
		int qmat = student2VO.getQmat();
		
		StudentValidator validator = new StudentValidator();
		validator.validate(student2VO, errors);
		if(errors.hasErrors()) {
			if(errors.getFieldError("qname") != null) {
				model.addAttribute("nameError", "이름은 한글자 이상이어야합니다.");
			}
			if(errors.getFieldError("qkor") != null) {
				model.addAttribute("qkorError", "국어점수는 0점에서 100점 사이어야합니다.");
			}
			if(errors.getFieldError("qeng") != null) {
				model.addAttribute("qengError", "영어점수는 0점에서 100점 사이어야합니다.");
			}
			if(errors.getFieldError("qmat") != null) {
				model.addAttribute("qmatError", "수학점수는 0점에서 100점 사이어야합니다.");
			}
			return "quiz/quizInput";
		}
		int sum = (qeng+qkor+qmat);
		double avg = (sum / 3.0);
		
		model.addAttribute("sum", sum);
		model.addAttribute("avg", avg);
		return "quiz/quizResult";
	}
	
}



















