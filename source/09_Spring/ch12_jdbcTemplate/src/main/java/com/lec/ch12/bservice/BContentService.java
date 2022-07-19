package com.lec.ch12.bservice;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;

public class BContentService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		int bid = (Integer)map.get("bid");
		BoardDao bdao = BoardDao.getInstance();
		model.addAttribute("bdto", bdao.contentView(bid));
		
	}

}
