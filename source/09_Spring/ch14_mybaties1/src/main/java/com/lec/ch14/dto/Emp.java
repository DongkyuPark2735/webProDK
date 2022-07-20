package com.lec.ch14.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 클래스에 dto안붙임?
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
}
