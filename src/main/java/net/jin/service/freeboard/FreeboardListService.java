package net.jin.service.freeboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.Freeboard;
import net.jin.repository.FreeboardRepository;

@Service
public class FreeboardListService {
	
	@Autowired
	private FreeboardRepository freeboardRepository;

	public List<Freeboard> freeboardList(int pageNum){
		return null;
	}

}
