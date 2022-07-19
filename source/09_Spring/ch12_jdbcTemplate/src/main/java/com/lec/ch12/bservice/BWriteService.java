package com.lec.ch12.bservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;
import com.lec.ch12.vo.BoardDTO;

public class BWriteService implements Service {

	@Override
	public void execute(Model model) {
		BoardDao bdao = BoardDao.getInstance();
		Map<String, Object> map = model.asMap();
		BoardDTO bdto = (BoardDTO)map.get("bdto");
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		bdto.setBip(request.getRemoteAddr());
		
		model.addAttribute("writeResult", bdao.write(bdto));

	}
}
