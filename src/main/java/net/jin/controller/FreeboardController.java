package net.jin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.jin.model.Freeboard;
import net.jin.service.freeboard.FreeboardListService;


@Controller
public class FreeboardController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private FreeboardListService freeboardListService;
	
	private int returnintValue(String stringToint) {
		return Integer.parseInt(stringToint);
	}
	
	
	@GetMapping("/freeboard")
	public String freeboard(@RequestParam(value="pageNum",defaultValue = "1") String pageNum) {
		List<Freeboard> freeboardList=freeboardListService.freeboardList(returnintValue(pageNum));
		if (freeboardList==null) {
			return "freeboard";
		}
		
		session.setAttribute("boardList", freeboardList);
		return "freeboard";
	}
}
