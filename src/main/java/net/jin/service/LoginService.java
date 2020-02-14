package net.jin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.Users;
import net.jin.repository.UsersRepository;

@Service
public class LoginService {
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private UserPasswordHashClass userPasswordHashClass;
	
	@Autowired
	private HttpSession session;
	
	public String loginUser(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		if (userId.equals("")||userPw.equals("")) {
			return "login";
		}

		String hashedPassword = userPasswordHashClass.getSHA256(userPw);
		Users users = userRepository.findByUseridAndPassword(userId, hashedPassword);
		if (users == null) {
			return "login";
		}
		
		session.setAttribute("loginUser", users);
		
		return "index";
		
	}

}
