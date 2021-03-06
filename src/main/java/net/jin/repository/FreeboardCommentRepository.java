/*
 * This is a Jin-gamma Project
 * File name : FreeboardCommentRepository.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : Repository for FreeboardComment Class
 */
package net.jin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.jin.model.FreeboardComment;

@Repository
public interface FreeboardCommentRepository extends JpaRepository<FreeboardComment, Long>{
	List<FreeboardComment> findAllByFreeboardid(Long freeboardId); 
}
