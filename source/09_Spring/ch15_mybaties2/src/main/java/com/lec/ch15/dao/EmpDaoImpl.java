package com.lec.ch15.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lec.ch15.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<Emp> empList(Emp emp) {
		return sessionTemplate.selectList("empList", emp);
	}

	@Override
	public List<Emp> empDeptList(Emp emp) {
		return sessionTemplate.selectList("empDeptList", emp);
		// 파라미터 넣어준다 콤마로
	}

	@Override
	public int totCnt() {
		return sessionTemplate.selectOne("totCnt");
	}

	@Override
	public Emp detail(int empno) {
		return sessionTemplate.selectOne("detail", empno);
	}

	@Override
	public List<Emp> managerList() {
		return sessionTemplate.selectList("managerList");
	}

	@Override
	public int insert(Emp emp) {
		return sessionTemplate.insert("insert", emp);
	}

	@Override
	public int update(Emp emp) {
		return sessionTemplate.update("update", emp);
	}

	@Override
	public int delete(int empno) {
		return sessionTemplate.delete("delete", empno);
	}
}
