<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.CustomerDTO"%>
<%@page import="com.lec.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CustomerDAO cdao = CustomerDAO.getInstance();
	CustomerDTO newCustomer = new CustomerDTO();
	
	for(int i=0; i<15; i++){
		newCustomer.setCid("aa"+i);
		newCustomer.setCpw("111");
		if(i%2==0){
			newCustomer.setCname("홍길동");
			newCustomer.setCgender("m");
		}else{
			newCustomer.setCname("홍길자");
			newCustomer.setCgender("f");
		}
		newCustomer.setCtel("010-1234-127"+i);		
		newCustomer.setCemail("hong"+i+"@hong.com");
		newCustomer.setCbirth(Date.valueOf("1995-10-01"));
		int result = cdao.insertCustomer(newCustomer);
		out.print(result==CustomerDAO.SUCCESS? i+"번쨰 성공" : i+"번쨰 실패");
		out.print("<br>");
	}

%>