package net.jin.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.Users;
import net.jin.repository.UsersRepository;

@Service
public class SignupService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserPasswordHashClass userPasswordHashClass;
	
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
