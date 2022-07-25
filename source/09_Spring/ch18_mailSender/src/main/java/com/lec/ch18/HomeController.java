package com.lec.ch18;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SimpleAliasRegistry;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	public JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "join";
	}
	
	@RequestMapping(value = "textMail" ,method = RequestMethod.GET )
	public String textMail(String name, String email, Model model) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("qer2735@gmail.com");// 관리자 메일주소(보내는 사람 메일)
		message.setTo(email);// 받는 사람 메일
		
		message.setSubject("[TEXT 가입인사]"+name+"님 회원가입 감사합니다.");
		String content = name+"님 회원 가입 감사합니다.\n<h1>태그 안먹음</h1>";
		message.setText(content);// 매일 본문 내용
		
		mailSender.send(message);//메일 보내기
		model.addAttribute("mailSendResult", "TEXT메일이 발송되었습니다.");
		
		return "sendResult";
	}

	@RequestMapping(value = "htmlMail" ,method = RequestMethod.GET )
	public String htmlMail(final String name,final String email, Model model) {
		// name에게 email주소로 html내용 보내기
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div style=\"width:500px; margin : 0 auto; text-align: center;\" >\n" + 
					"	<h1 style=\"color:blue;\">"+name+"님 회원가입 감사합니다</h1>\n" + 
					"	<div>\n" + 
					"		<p>특정 사이트에서만 쓰실 수 있는 감사쿠폰</p>\n" + 
					"		<p>\n" + 
					"			<img alt=\"쿠폰\" src=\"http://localhost:8090/ch18/resources/coupon.jpg\">\n" + 
					"		</p>\n" + 
					"		<p>\n" + 
					"			<img alt=\"쿠폰\" src=\"https://search.pstatic.net/sunny/?src=https%3A%2F%2Fimage.utoimage.com%2Fpreview%2Fcp966899%2F2022%2F03%2F202203005884_500.jpg&type=a340\">\n" + 
					"		</p>\n" + 
					"	</div>\n" + 
					"</div>"; // 메일 내용(html)
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// 보내는 메일, 받는 메일, 메일 제목, utf-8
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));//받는 메일
				mimeMessage.setFrom(new InternetAddress("qer2735@naver.com"));
				mimeMessage.setSubject("[HTML가입인사]"+name+"님 회원가입 감사합니다.");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message);
		model.addAttribute("mailSendResult", "HTML메일이 발송되었습니다.");
		return "sendResult";
	}
}

















