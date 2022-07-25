package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDAO;
import com.lec.ch19.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberdao;

	@Autowired
	private  JavaMailSenderImpl mailsender;

	@Override
	public int idConfirm(String mid) {
		return memberdao.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		// member.getMname()에게 메일, member insert, session에 mid attribute추가

		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div style=\"width:500px; margin : 0 auto; text-align: center;\" >\n"
					+ "	<h1 style=\"color:blue;\">" + member.getMname() + "님 회원가입 감사합니다</h1>\n" + "	<div>\n"
					+ "		<p>특정 사이트에서만 쓰실 수 있는 감사쿠폰</p>\n" + "		<p>\n"
					+ "			<img alt=\"쿠폰\" src=\"http://localhost:8090/ch19/img/coupon.jpg\">\n"
					+ "		</p>\n" + "		<p>\n"
					+ "			<img alt=\"쿠폰\" src=\"https://search.pstatic.net/sunny/?src=https%3A%2F%2Fimage.utoimage.com%2Fpreview%2Fcp966899%2F2022%2F03%2F202203005884_500.jpg&type=a340\">\n"
					+ "		</p>\n" + "	</div>\n" + "</div>";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail()));
				mimeMessage.setFrom(new InternetAddress("qer2735@gmail.com"));//보내는 메일
				mimeMessage.setSubject(member.getMname()+"님 회원가입 감사합니다.");
				mimeMessage.setText(content,"utf-8","html"); 
			}
		};
		mailsender.send(message);
		httpSession.setAttribute("mid", member.getMid());// 세션에 mid속성 추가
		return memberdao.joinMember(member); // member insert
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		Member member =memberdao.getMember(mid);
		if(member == null) {
			result = "유효하지 않은 아이디입니다.";
		}else if(! mpw.equals(member.getMpw())) {
			result = "비밀번호가 맞지 않습니다.";
		}else {
			httpSession.setAttribute("member", member);
			httpSession.setAttribute("mid", mid);
		}
		return result;
	}

	@Override
	public Member getMember(String mid) {
		return memberdao.getMember(mid);
	}

	@Override
	public int modifyMember(Member member) {
		return memberdao.modifyMember(member);
	}

}
