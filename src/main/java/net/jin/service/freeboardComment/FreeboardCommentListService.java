package net.jin.service.freeboardComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jin.model.FreeboardComment;
import net.jin.repository.FreeboardCommentRepository;

@Service
public class FreeboardCommentListService {

	@Autowired
	private FreeboardCommentRepository freeboardCommentRepository;
		
	public List<FreeboardComment> getList(Long freeboardId){
		return null;
	}
}
