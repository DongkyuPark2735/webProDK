package com.lec.ch12.bservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;
import com.lec.ch12.vo.BoardDTO;

public class BModifyService implements Service {
	@Override
	public void execute(Model model) {
		//model에 담긴 객체 정보를 받기 위해 
		//model.getAttribute가 존재하지않는다. 
		Map<String, Object> map = model.asMap();
		// model을 맵화 리턴값 String Object
		//어트리뷰트 했던 속성값 	
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		BoardDTO bdto = (BoardDTO)map.get("bdto");
		bdto.setBip(request.getRemoteAddr());
		
		BoardDao bdao = BoardDao.getInstance();
		
		model.addAttribute("bdtoModifyResult", bdao.modify(bdto));
	}
}
