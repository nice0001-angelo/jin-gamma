/*
 * This is a Jin-gamma Project
 * File name : FreeboardWriteService.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : For Freeboard Write Service
 */
package net.jin.freeboard.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.freeboard.service.FreeboardWriteService;
import net.jin.model.Freeboard;
import net.jin.repository.FreeboardRepository;

@Service
public class FreeboardWriteServiceImpl implements FreeboardWriteService {
	
	@Autowired
	FreeboardRepository freeboardRepository;

	@Override
	public void write(HttpServletRequest request) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		Freeboard freeboard = new Freeboard();
		freeboard.setContent(content);
		freeboard.setTitle(title);
		freeboard.setWriter(writer);
		
		freeboardRepository.save(freeboard);
	}

}
