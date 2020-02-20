package net.jin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.jin.model.Freeboard;

@Repository
public interface FreeboardRepository extends JpaRepository<Freeboard, Long>{
	
	Freeboard findByFreeboardid(Long freeboardId);

}
