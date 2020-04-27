package net.jin.user.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.Users;
import net.jin.repository.UsersRepository;
import net.jin.user.service.LoginService;
import net.jin.user.service.UserPasswordHashService;

@Service
public class LoginServiceImpl implements LoginService {
	
	
	@Autowired
	private UserPasswordHashService userPasswordHashClass;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
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

		httpSession.setAttribute("loginedUser", users);
			
		return "index";
	}

}
