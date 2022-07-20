package com.lec.ch14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch14.dto.Emp;
import com.lec.ch14.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping(value = "emp", method = RequestMethod.GET)
	public String emp(@ModelAttribute("schEmp") Emp schEmp, Model model){
		model.addAttribute("empList", empService.empList(schEmp));
		model.addAttribute("deptList", empService.depList());
		//마이바티스는 서비스단에서 컨트롤러로 model넘기기 안됨? 힘듬?
		return "emp";
		
	}
	
}
