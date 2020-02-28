/*
 * This is a Jin-gamma Project
 * File name : FreeboardInfoService.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : For Freeboard Information Service
 */
package net.jin.service.freeboard;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.Freeboard;
import net.jin.repository.FreeboardRepository;

@Service
public class FreeboardInfoService {
	
	@Autowired
	private FreeboardRepository freeboardRepository;
	
	@Autowired
	private HttpSession httpSession;
	
	public String getFreeboardPost(String stringFreeboardId) {
		Long freeboardId = Long.parseLong(stringFreeboardId);
		Freeboard freeboard = freeboardRepository.findByFreeboardid(freeboardId);
		if(freeboard == null) {
			return "freeboard";
		}
		
		httpSession.setAttribute("freeboardInfo", freeboard);
		return "freeboardInfo";
	}

}