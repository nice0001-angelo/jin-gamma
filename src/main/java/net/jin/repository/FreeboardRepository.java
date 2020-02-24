/*
 * This is a Jin-gamma Project
 * File name : FreeboardRepository.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : Repository for Freeboard Class
 */
package net.jin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.jin.model.Freeboard;

@Repository
public interface FreeboardRepository extends JpaRepository<Freeboard, Long>{
	
	Freeboard findByFreeboardid(Long freeboardId);

}
