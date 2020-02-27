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
	
	public String signupUser(HttpServletRequest request) {
		String userId = (String) request.getAttribute("user_id"); // return Object
		String userPassword = (String) request.getAttribute("user_pw"); // return Object
		String userName = request.getParameter("user_name"); // return String
		
		  
		if(userId==null||userPassword==null||userName==null) { 
			  return "signup"; 
		}
		
		Users users = new Users();
		users.setUserid(userId);
		users.setPassword(userPassword);
		users.setUsername(userName);
		
		usersRepository.save(users);
		 

		return "index";
	}

}