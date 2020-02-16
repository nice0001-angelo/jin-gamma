package net.jin.service.freeboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.jin.model.Freeboard;
import net.jin.repository.FreeboardRepository;

@Service
public class FreeboardListService {
	
	@Autowired
	private FreeboardRepository freeboardRepository;

	public List<Freeboard> freeboardList(int pageNum){
		
		PageRequest pageRequest = PageRequest.of(pageNum-1, 10, Sort.Direction.DESC , "freeboardid");
		
		freeboardRepository.findAll(pageRequest);
		
		return null;
	}

}
