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

@Controller
public class UsersController {

	@Autowired
	private JoinService joinService;
	

	@Autowired
	private LoginService loginService;
//	@PostMapping("/joinRequest")
//	public String joinRequest(@RequestParam Map<String, String> paraMap) {
//		String userId = paraMap.get("user_id"); 
//		String userPw = paraMap.get("user_pw"); 
//		String userName = paraMap.get("user_name");
//		 
//		joinService.joinUser(userId, userPw, userName);
//      joinService.joinUser(paraMap); MR. Choi
	
	@PostMapping("/joinRequest")
	public String joinRequest(HttpServletRequest request) {
		joinService.joinUser(request);
		return "index";
	}
	
	@PostMapping("/loginRequest")
	public String loginRequest(HttpServletRequest request) {
		loginService.loginUser(request);
		return "index";
	}
}
