package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch14.dto.Dept;

@Mapper
public interface DeptDao {
	//함수이름을 맵의 쿼리 id값과 같게
	public List<Dept> deptList();
	//list를 리턴하기때문에 
}
