/*
 * This is a Jin-gamma Project
 * File name : JoinService.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : Join Service
 */
package net.jin.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.Users;
import net.jin.repository.UsersRepository;

@Service
public class JoinService {
	
	@Autowired
	private UsersRepository usersRepository;
	
//	public String joinUser(String userId, String userPw, String userName) {
//		
//		if(userId.equals("")||userPw.equals("")||userName.equals("")) {
//			return "join";
//		}
	public String joinUser(HttpServletRequest request) {
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String userName = request.getParameter("user_name");
		
		if(userId.equals("")||userPw.equals("")||userName.equals("")) {
			return "join";
		}
		
		Users users = new Users();
		users.setUser_id(userId);
		users.setUser_pw(userPw);
		users.setUser_name(userName);
		
		usersRepository.save(users);
		return "index";
		
	}
	
	
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
}
