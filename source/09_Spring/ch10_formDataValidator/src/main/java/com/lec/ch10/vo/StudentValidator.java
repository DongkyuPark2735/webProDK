package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Student2VO.class.isAssignableFrom(clazz); //검증할 객체의 클래스 타입 명시
	}

//	@Override
//	public void validate(Object target, Errors errors) {
//		//컨트롤러에서 호출 : validate(student, errors)호출
//		StudentVO student = (StudentVO)target;
//		String name = student.getName();
//		int id = student.getId();
////		if(name == null || name.trim().isEmpty()) {
////			//name 에러
////			errors.rejectValue("name", "no"); //name 에러 등록
////		}
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no");//name 에러등록
//		
//		if(id<=0) {
//			errors.rejectValue("id", "no");// id에러 등록
//		}
//	}
	@Override
	public void validate(Object target, Errors errors) {
		//컨트롤러에서 호출 : validate(student, errors)호출
		Student2VO student = (Student2VO)target;
		String qname = student.getQname();
		int qkor = student.getQkor();
		int qeng = student.getQeng();
		int qmat = student.getQmat();
		if(qname.length()==1 || qname==null) {
		  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qname", "no");//name 에러등록
		}
		if(qkor==0 || qkor >100) {
			errors.rejectValue("qkor", "no");// id에러 등록
		}
		if(qeng==0 || qeng >100) {
			errors.rejectValue("qeng", "no");// id에러 등록
		}
		if(qmat==0 || qmat >100) {
			errors.rejectValue("qmat", "no");// id에러 등록
		}
	}
	
	
	
}

























