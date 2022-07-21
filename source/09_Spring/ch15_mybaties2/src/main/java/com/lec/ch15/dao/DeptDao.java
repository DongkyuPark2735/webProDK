package com.lec.ch15.dao;

import java.util.List;

import com.lec.ch15.model.Dept;

public interface DeptDao {
					//mapper의 select id와 일치해야함 @MapperScan쓸때 
	public List<Dept> deptList();
}

