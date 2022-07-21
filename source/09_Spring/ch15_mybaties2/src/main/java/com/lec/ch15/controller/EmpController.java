package com.lec.ch15.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.model.Emp;
import com.lec.ch15.service.EmpService;
import com.lec.ch15.util.Paging;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value = "empList", method = RequestMethod.GET)
	public String empList(String pageNum, Model model) {
		//empList.do?pageNum2, empList.do
		model.addAttribute("empList", empService.empList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		//어디서 모델을 넘길떄 안넘어감??
		return "empList";
	}
	
	@RequestMapping(value = "dummyDataInsert", method = RequestMethod.GET)
	public String dummyDataInsert() {
		empService.dummyDataInsert50();
		return "redirect:empList.do";
	}
	
	@RequestMapping(value = "empDeptList", method = {RequestMethod.GET, RequestMethod.POST})
	public String empDeptList(String pageNum, Model model) {
		model.addAttribute("empList", empService.empDeptList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		return "empDeptList";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "detail";
	}

	@RequestMapping(value = "updateView", method = {RequestMethod.POST, RequestMethod.GET})
										/* 에러페이지 발생시 뷰페이지로 보내기 위한 리퀘스트메소드 추가*/
	public String update(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Emp emp, Model model, String temphiredate) {
		emp.setHiredate(Timestamp.valueOf(temphiredate + " 00:00:00"));	;
		try {
			model.addAttribute("updateResult",empService.update(emp));
			//다시 올수없? jsp로 걸러줘야함 
		}catch (Exception e) {
			model.addAttribute("updateResult", "필드값이 너무김");
			return "forward:updateView.do";
			//마이바티스 최신버젼은 catch절로 안떨어지고 500에러페이지로 바로가짐
		}
		return "forward:empDeptList.do";
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult",empService.delete(empno));
		return "forward:empDeptList.do";
	}
	
	@RequestMapping(value = "writeView", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeView(Model model) {
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "write";
	}

	@RequestMapping(value = "write", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeView(Model model,Emp emp, String temphiredate) {
		emp.setHiredate(Timestamp.valueOf(temphiredate + " 00:00:00"));	;
		model.addAttribute("insertResult", empService.insert(emp));
		return "forward:empDeptList.do";
	}

	@RequestMapping(value = "confirmNo", method = RequestMethod.GET)
	public String confirmNo(Model model,int empno) {
		if(empService.detail(empno) == null) {
			model.addAttribute("msg", "사용가능한 사번입니다.");
		}else {
			model.addAttribute("msg", "중복된 사번입니다.");
		}
		return "forward:writeView.do";
	}
	
	
	
	
	
	
	
	
}













