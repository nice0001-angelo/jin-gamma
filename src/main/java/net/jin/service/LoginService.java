package net.jin.service;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.Users;
import net.jin.repository.UsersRepository;

@Service
public class LoginService {
	
	
	@Autowired
	private UserPasswordHashClass userPasswordHashClass;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private HttpSession httpSession;
		
	public String loginUser(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		String userPassword = request.getParameter("user_pw");
		
		if (userId.equals("")||userPassword.equals("")) {
			return "login";
		}
				
		String hashedPassword = userPasswordHashClass.getSHA256(userPassword);
		Users users = usersRepository.findByUseridAndPassword(userId, hashedPassword);
		
		if(users == null) {
			return "login";
		}

		httpSession.setAttribute("LoginedUser", users);
		//httpSession.setAttribute("LoginUser", users);
			
		return "index";
	}

}
