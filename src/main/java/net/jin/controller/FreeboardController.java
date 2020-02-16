package net.jin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreeboardController {

	@GetMapping("/freeboard")
	public String freeboard() {
		return "freeboard";
	}
}
