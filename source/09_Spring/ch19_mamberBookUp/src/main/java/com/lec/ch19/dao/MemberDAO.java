package com.lec.ch19.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch19.model.Member;

@Mapper
public interface MemberDAO {
	public int idConfirm(String mid);
	public int joinMember(Member member);
	public Member getMember(String mid);
	public int modifyMember(Member member);
}


