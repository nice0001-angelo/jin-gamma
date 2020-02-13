package net.jin.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.repository.UsersRepository;

@Service
public class LoginService {
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private UserPasswordHashClass userPasswordHashClass;
	
	public String loginUser(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		if(userId.equals("")||userPw.equals("")) {
			return "login";
		}

		String hashedPassword = userPasswordHashClass.getSHA256(userPw);
				
		return "login";
		
	}

}
