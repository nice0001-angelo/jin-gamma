/*
 * This is a Jin-gamma Project
 * File name : UsersController.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : for the UsersController
 */
package net.jin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import net.jin.service.JoinService;
import net.jin.service.LoginService;
import net.jin.service.SignupService;

@Controller
public class UsersController {

	@Autowired
	private SignupService signupService;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/signupRequest")
	public String signupRequest(HttpServletRequest request) {
		String page = signupService.signupUser(request);
		return page;
	}
	
	@PostMapping("/loginRequest")
	public String loginRequest(HttpServletRequest request) {
		String page = loginService.loginUser(request);
		return page;
	}
	
	
	/*
	 * @PostMapping("/joinRequest") public String joinRequest(@RequestParam
	 * Map<String, String> paraMap) { String userId = paraMap.get("user_id"); String
	 * userPw = paraMap.get("user_pw"); String userName = paraMap.get("user_name");
	 * 
	 * joinService.joinUser(userId, userPw, userName);
	 * joinService.joinUser(paraMap); MR. Choi (userId, u+serPw, userName)를 서비스로 넘기지
	 * 않고 paraMap 객체 전체를 서비스로 넘기는 것.
	 */
		
}
