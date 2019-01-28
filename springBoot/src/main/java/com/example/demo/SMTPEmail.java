package com.example.demo;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class SMTPEmail {

	@Autowired
	private JavaMailSender email;
	
	
	public String sendmail(UserModel user) throws MessagingException {
		MimeMessage message = email.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setSubject("Access Granted as a "+user.roll);
		helper.setTo(user.getEmail());
		String s1 = "Hello ";
		String s2 = " you are added as a user and granted permissions for ";
		helper.setText( s1+user.getFirstname()+s2+user.getRoll(), true);
					
		email.send(message);
		
		return "Email sent Successfully";
		
	}
}


