package net.jin.user.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.Users;
import net.jin.repository.UsersRepository;
import net.jin.user.service.SignupService;
import net.jin.user.service.UserPasswordHashService;

@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserPasswordHashService userPasswordHashClass;
	
	@Override
	public String signupUser(HttpServletRequest request) {
		String userId = request.getParameter("user_id"); 
		String userPassword = request.getParameter("user_pw"); 
		String userName = request.getParameter("user_name"); 
		
		  
		if(userId.equals("")||userPassword.equals("")||userName.equals("")) { 
			  return "signup"; 
		}
		
		Users users = new Users();
		String hashedPassword = userPasswordHashClass.getSHA256(userPassword);
		
		users.setUserid(userId);
		users.setPassword(hashedPassword);
		users.setUsername(userName);
		
		usersRepository.save(users);
		return "index";
	}

}
