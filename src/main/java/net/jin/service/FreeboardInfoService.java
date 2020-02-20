package net.jin.service;

import org.springframework.stereotype.Service;

@Service
public class FreeboardInfoService {
	
	public String getFreeboardPost(String stringFreeboardId) {
		Long freeboardId = Long.parseLong(stringFreeboardId);
		return "freeboardInfo";
	}

}
