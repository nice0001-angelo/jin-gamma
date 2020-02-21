package net.jin.service;

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
		
		httpSession.setAttribute("freeboard", freeboard);
		return "freeboardInfo";
	}

}