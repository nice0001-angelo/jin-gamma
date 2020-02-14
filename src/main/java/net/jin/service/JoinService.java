/*
 * This is a Jin-gamma Project
 * File name : JoinService.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : Join Service
 */
package net.jin.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.Users;
import net.jin.repository.UsersRepository;

@Service
public class JoinService {
//	public String joinUser(String userId, String userPw, String userName) {
//	
//	if(userId.equals("")||userPw.equals("")||userName.equals("")) {
//		return "join";
//	}
	
//MR. Choi
//	public String joinUser(Map<String, String> paraMap) {
//		
//		Users users = new Users();
//		
//		for (String key : paraMap.keySet()) {
//			if (null != paraMap.get(key) || "".equals((String)paraMap.get(key))) {
//				return "join";	
//			}
//		}
//		
//		usersRepository.save(users);
//		return "index";
//	}
	
	
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserPasswordHashClass userPasswordHashClass;

	public String joinUser(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String userName = request.getParameter("user_name");
		
		if(userId.equals("")||userPw.equals("")||userName.equals("")) {
			return "join";
		}
		
		Users users = new Users();
		users.setUserid(userId);
		//sha256 encryption method call
		String hashedPassword = userPasswordHashClass.getSHA256(userPw);
		users.setPassword(hashedPassword);
		users.setUsername(userName);
		
		usersRepository.save(users);
		return "index";
		
	}
}
