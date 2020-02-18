package net.jin.service.freeboard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.repository.FreeboardRepository;

@Service
public class FreeboardWriteService {
	
	@Autowired
	FreeboardRepository freeboardRepository;
		
	public void write(HttpServletRequest request) {
		request.getParameter("title");
		request.getParameter("content");
		request.getParameter("writer");

		
	}

}
