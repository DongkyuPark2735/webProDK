package com.lec.my.service;

import java.util.List;

import com.lec.my.model.Myboard;

public interface MyboardService {
	public List<Myboard> listMyboard(String pageNum);
	public int totCnt();
	public int insertMyboard(Myboard myboard);
	public void bhitUp(int bid);
	public Myboard detailMyborad(int bid);
	public void stepReply(Myboard myboard);
	public int insertReply(Myboard myboard);
	public int modifyMyborad(Myboard myboard);
	public int deleteMyboard(int bid);
}
