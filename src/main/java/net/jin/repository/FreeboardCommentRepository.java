package net.jin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.jin.model.FreeboardComment;

@Repository
public interface FreeboardCommentRepository extends JpaRepository<FreeboardComment, Long>{
	List<FreeboardComment> findAllByFreeboardId(Long freeboardId); 
}
