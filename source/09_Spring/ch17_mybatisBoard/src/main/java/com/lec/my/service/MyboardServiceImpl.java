package com.lec.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.my.dao.MyboardDAO;
import com.lec.my.model.Myboard;
import com.lec.my.util.Paging;

@Service
public class MyboardServiceImpl implements MyboardService {

	@Autowired
	private MyboardDAO myboardDAO; 
	
	@Override
	public List<Myboard> listMyboard(String pageNum) {
		Paging paging = new Paging(myboardDAO.totCnt(), pageNum, 10, 5);
		Myboard myboard = new Myboard();
		myboard.setStartRow(paging.getStartRow());
		myboard.setEndRow(paging.getEndRow());
		return myboardDAO.listMyboard(myboard);
	}

	@Override
	public int totCnt() {
		return myboardDAO.totCnt();
	}

	@Override
	public int insertMyboard(Myboard myboard) {
		return myboardDAO.insertMyboard(myboard);
	}

	@Override
	public void bhitUp(int bid) {
		myboardDAO.bhitUp(bid);
	}

	@Override
	public Myboard detailMyborad(int bid) {
		bhitUp(bid);
		return myboardDAO.detailMyborad(bid);
	}

	@Override
	public void stepReply(Myboard myboard) {
		myboardDAO.stepReply(myboard);
	}

	@Override
	public int insertReply(Myboard myboard) {
		stepReply(myboard);
		return myboardDAO.insertReply(myboard);
	}

	@Override
	public int modifyMyborad(Myboard myboard) {
		return myboardDAO.modifyMyborad(myboard);
	}

	@Override
	public int deleteMyboard(int bid) {
		return myboardDAO.deleteMyboard(bid);
	}

}
