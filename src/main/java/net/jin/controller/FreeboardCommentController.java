package net.jin.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FreeboardCommentController {
	
	@RequestMapping("/freeboardCommentList")
	@ResponseBody //Json 형태로 반환 하게 할 수 있다
	public Map<String, String> freeboardCommentList(){
		return null;
	}
}
