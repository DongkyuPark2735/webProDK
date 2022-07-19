package com.lec.ch12.bservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lec.ch12.dao.BoardDao;
import com.lec.ch12.vo.BoardDTO;

public class BReplyService implements Service {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		BoardDTO bdto = (BoardDTO)map.get("bdto");
		bdto.setBip(request.getRemoteAddr());
		// bgroup, bstep, bindent 원글정보
		// bname, btitle, bcontent 답변글정보
		BoardDao bdao = BoardDao.getInstance();
		model.addAttribute("replyResult", bdao.reply(bdto));
		
	}
}
