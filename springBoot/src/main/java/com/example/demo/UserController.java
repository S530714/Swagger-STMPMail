package com.example.demo;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
//	@Autowired
	private UserDAO UserDAO;
	
	@Autowired
	public UserController(UserDAO userDAO) {
		this.UserDAO=userDAO;
	}
	
	@Autowired
	private SMTPEmail SmtpEmail;

	@RequestMapping("/user")
	public List<UserModel> getAllUsers() {
		return UserDAO.getAllUsers();
	}
	@RequestMapping("/user/{id}")
	public UserModel getUserById(@PathVariable("id") int userId) {
		return UserDAO.getUserById(userId); 
	
	}
	@RequestMapping(method=RequestMethod.POST,value = "/user")
	public boolean addUser(@RequestBody UserModel newUser) throws MessagingException {
		 UserDAO.addUser(newUser);
		 try {
			    SmtpEmail.sendmail(newUser);
			    }
			    catch(MailException e) {
			    	System.out.println(e.getMessage());
			    }
		 return true;
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value = "/user/{id}")
	public boolean updateUser(@RequestBody UserModel user,@PathVariable("userId") int userId) {
		return UserDAO.updateUser(user);
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value = "/user/{id}")
	public boolean deleteUser(@PathVariable("userId") int userId) {
		return UserDAO.deleteUser(userId);
		
	}
}
