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

import net.jin.model.Users;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String index() {
		System.out.println("Request of index");
		return "index";
	}
	
	@GetMapping("/foodblog")
	public String foodblog() {
		System.out.println("Request of foodblog");
		return "foodblog";
	}
	
	@GetMapping("/contact")
	public String contact() {
		System.out.println("Request of contact");
		return "contact";
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
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "index";
	}
		
	@GetMapping("/freeboardWritePage")
	public String freeboardWritePage(HttpSession httpSession) {
		System.out.println("Can access only only User");
		Object loginedUser = httpSession.getAttribute("loginedUser");
		if(loginedUser==null) {
			return "login";
		}
		return "freeboardWrite";
	}
	
}
