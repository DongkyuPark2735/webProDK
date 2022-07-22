package com.lec.my.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.my.model.Myboard;

@Mapper
public interface MyboardDAO {
	public List<Myboard> listMyboard(Myboard myboard);
	public int totCnt();
	public int insertMyboard(Myboard myboard);
	public int bhitUp(int bid);
	public Myboard detailMyborad(int bid);
	public int stepReply(Myboard myboard);
	public int insertReply(Myboard myboard);
	public int modifyMyborad(Myboard myboard);
	public int deleteMyboard(int bid);
}
