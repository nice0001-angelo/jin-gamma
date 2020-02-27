package net.jin.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
	
	public String signupUser(HttpServletRequest request) {
		String userId = (String) request.getAttribute("user_id"); // return Object
		String userPassword = (String) request.getAttribute("user_pw"); //return Object
		String userName = request.getParameter("user_name"); //return String
		
		if(userId.isBlank()||userPassword.isBlank()||userName.isBlank()) {
			return "signup";
		}
		
		return "index";
	}

}
