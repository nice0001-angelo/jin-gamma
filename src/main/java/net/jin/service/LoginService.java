package net.jin.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public String loginUser(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		String userPassword = request.getParameter("user_pw");
		
		if (userId.equals("")||userPassword.equals("")) {
			return "login";
		}
		
		
		return "";
	}

}
