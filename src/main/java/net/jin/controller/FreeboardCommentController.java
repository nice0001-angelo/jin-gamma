/*
 * This is a Jin-gamma Project
 * File name : FreeboardCommentController.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : Controller.java
 */
package net.jin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.jin.model.Freeboard;
import net.jin.model.FreeboardComment;
import net.jin.repository.FreeboardCommentRepository;
import net.jin.service.freeboardComment.FreeboardCommentListService;

@Controller
public class FreeboardCommentController {

//	@Autowired
//	private FreeboardComment freeboardComment;

	@Autowired
	private FreeboardCommentRepository freeboardCommentRepository;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private FreeboardCommentListService freeboardCommentListService;

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping(value = "/freeboardCommentList")
	public @ResponseBody String freeboardCommentList() { // JASON 타입으로 변하게 할 수 있다. Annotation을 @RestController로 적으면 //
															// @ResponseBody 가 필요 없다
		Freeboard freeboard = (Freeboard) httpSession.getAttribute("freeboard");
		List<FreeboardComment> commentList = freeboardCommentListService.getList(freeboard.getFreeboardid());
		String value = null;
		try {
			value = objectMapper.writeValueAsString(commentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	@PostMapping(value = "/freeboardCommentWrite")
	public @ResponseBody String freeboardCommentWrite(@RequestBody FreeboardComment freeboardComment) {
		//freeboardComment.setWritedate(LocalDateTime.now());
		freeboardCommentRepository.save(freeboardComment);
		return "freeboardComment inserted";
	}

}
