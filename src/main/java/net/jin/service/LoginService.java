/*
 * This is a Jin-gamma Project
 * File name : LoginService.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : Login Service
 */
package net.jin.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import net.jin.model.Users;
import net.jin.repository.UsersRepository;

public class LoginService {
	
	@Autowired
	private UsersRepository userRepository;
		
	@Autowired
	private UserPasswordHashClass userPasswordHashClass;
	
	public String loginUser(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		if (userId.equals("")||userPw.equals("")) {
			return "login";
		}
		
		String hashedPassword = userPasswordHashClass.getSHA256(userPw);
		Users users = userRepository.findByUser_idAndAndUser_pw(userId, hashedPassword);
		if(users == null) {
			return "login";
		}
		
		return "index";
		
	}

}
