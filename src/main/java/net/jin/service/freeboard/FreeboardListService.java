package net.jin.service.freeboard;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.jin.model.Freeboard;
import net.jin.repository.FreeboardRepository;

@Service
public class FreeboardListService {
	
	@Autowired
	private FreeboardRepository freeboardRepository;
	
	@Autowired
	private HttpSession session;

	public String freeboardList(int pageNum){
		
		PageRequest pageRequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC , "freeboardid");
		Page<Freeboard> freeboardPage = freeboardRepository.findAll(pageRequest);
		
		if(freeboardPage.getSize() == 0) {
			List<Freeboard> freeboardList = new ArrayList<Freeboard>();
			session.setAttribute("boardList", freeboardList);
			return "freeboard";
		}
		List<Freeboard> freeboardList = freeboardPage.getContent();
		session.setAttribute("boardList", freeboardList);
		return "freeboard";
	}

}
