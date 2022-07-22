package com.lec.ch15.service;

import java.util.List;

import com.lec.ch15.model.Dept;
import com.lec.ch15.model.Emp;

public interface EmpService {
	public List<Dept> deptList();
	
	public List<Emp> empList(String pageNum);
	//컨트롤러 단에서 페이지처리하면 컨트롤러 무거워짐?
	public List<Emp> empDeptList(String pageNum);
	public int totCnt();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	
	public void dummyDataInsert50();
	
	
	
	
	
}
 