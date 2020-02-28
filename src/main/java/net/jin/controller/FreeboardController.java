/*
 * This is a Jin-gamma Project
 * File name : FreeboardController.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : Controller.java
 */
package net.jin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.jin.repository.FreeboardRepository;
import net.jin.service.freeboard.FreeboardInfoService;
import net.jin.service.freeboard.FreeboardListService;
import net.jin.service.freeboard.FreeboardWriteService;


@Controller
public class FreeboardController {

	
	@Autowired
	private FreeboardListService freeboardListService;
	
	@Autowired
	private FreeboardWriteService freeboardWriteService; 
	
	@Autowired
	private FreeboardInfoService freeboardInfoService;
	
	private int returnintValue(String stringToint) {
		return Integer.parseInt(stringToint);
	}
	
	
	@GetMapping("/freeboardMain")
	public String freeboardMain(@RequestParam(value="pageNum",defaultValue = "1") String pageNum) {
		String page = freeboardListService.freeboardList(returnintValue(pageNum));
		return page;
	}
	
	@PostMapping("/freeboardWriteRequest")
	public String freeboardWriteRequest(HttpServletRequest request) {
		freeboardWriteService.write(request);
			return "redirect:/freeboardMain";
		
	}
	
	@GetMapping("/freeboardInfo")
	public String getPost(@RequestParam(value="freeboardId") String freeboardId) {
		String page = freeboardInfoService.getFreeboardPost(freeboardId);
		return page;
	}
	
}
