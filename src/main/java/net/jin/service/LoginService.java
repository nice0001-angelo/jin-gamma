package net.jin.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	
	@Autowired
	private UserPasswordHashClass userPasswordHashClass;
	
	public String loginUser(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		String userPassword = request.getParameter("user_pw");
		
		if (userId.equals("")||userPassword.equals("")) {
			return "login";
		}
				
		String hashedPassword = userPasswordHashClass.getSHA256(userPassword);
		
		
		return "";
	}

}
