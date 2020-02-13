package net.jin.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public String loginUser(HttpServletRequest request) {
		return "login";
		
	}

}
