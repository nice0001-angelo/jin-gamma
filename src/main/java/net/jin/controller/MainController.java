/*
 * This is a Jin-gamma Project
 * File name : MainController.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : Main Controller.java
 */
package net.jin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/joinPage")
	public String joinPage() {
		return "join";
	}
}
