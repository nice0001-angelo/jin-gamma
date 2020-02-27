/*
 * This is a Jin-gamma Project
 * File name : MainController.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : Main Controller.java
 */
package net.jin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/signupPage")
	public String signupPage() {
		return "signup";
	}
	
	@GetMapping("/loginPage")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
		
	@GetMapping("/freeboardWritePage")
	public String freeboardWritePage() {
		return "freeboardWrite";
		
	}
	
}
