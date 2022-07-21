package com.lec.ch15.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch15.model.Dept;

@Repository //빈 생성, 스프링에게 DAO임을 알려주는 어노테이션
public class DeptDaoImpl implements DeptDao{

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<Dept> deptList() {
								//select 문 id값
		return sessionTemplate.selectList("deptList");
	}
}
