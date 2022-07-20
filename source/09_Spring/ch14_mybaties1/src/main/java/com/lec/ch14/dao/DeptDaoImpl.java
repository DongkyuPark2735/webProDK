package com.lec.ch14.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch14.dto.Dept;
// 빈 생성을 위해 @Repository 
@Repository
public class DeptDaoImpl implements DeptDao {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<Dept> deptList() {
				//SELECT 문	중 deptList ID값을 가진 것 실행 
		return sessionTemplate.selectList("deptList");
	}

}
