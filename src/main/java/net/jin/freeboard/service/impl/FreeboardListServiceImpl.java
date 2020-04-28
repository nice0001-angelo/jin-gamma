/*
 * This is a Jin-gamma Project
 * File name : FreeboardListService.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : For Freeboard List Service
 */
package net.jin.freeboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.jin.freeboard.service.FreeboardListService;
import net.jin.freeboard.service.PageMakerService;
import net.jin.model.Freeboard;
import net.jin.pageMaker.PageMaker;
import net.jin.repository.FreeboardRepository;

@Service
public class FreeboardListServiceImpl implements FreeboardListService {
	
	@Autowired
	private FreeboardRepository freeboardRepository;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private PageMakerService pageMakerService;

	public String freeboardList(int pageNum){
		
		PageMaker pageMaker = pageMakerService.generatePageMaker(pageNum, 5, freeboardRepository);
		
		PageRequest pageRequest = PageRequest.of(pageNum-1, 5, Sort.Direction.DESC , "freeboardid");
		Page<Freeboard> freeboardPage = freeboardRepository.findAll(pageRequest);
		
		if(freeboardPage.getSize() == 0) {
			session.setAttribute("boardList", new ArrayList<Freeboard>());
			session.setAttribute("pageMaker", pageMaker);
			return "freeboardMain";
		}
		List<Freeboard> freeboardList = freeboardPage.getContent();
		session.setAttribute("boardList", freeboardList);
		session.setAttribute("pageMaker", pageMaker);
		return "freeboardMain";
	}

}
