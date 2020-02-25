/*
 * This is a Jin-gamma Project
 * File name : FreeboardCommentController.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : Controller.java
 */
package net.jin.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FreeboardCommentController {
	
	@GetMapping(value = "/freeboardCommentList", produces = MediaTypes.HAL_JASON_UTF8_VALUE) 
	public @ResponseBody String freeboardCommentList(){ //JASON 타입으로 변하게 할 수 있다
		return null;
	}
}
