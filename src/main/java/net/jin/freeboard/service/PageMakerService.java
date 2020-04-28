/*
 * This is a Jin-gamma Project
 * File name : PageMakerService.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : For Paging Treatement Service
 */
package net.jin.freeboard.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.jin.model.Freeboard;
import net.jin.pageMaker.PageMaker;

public interface PageMakerService {
	public PageMaker generatePageMaker(int pageNum, int contentNum, JpaRepository<Freeboard, Long> repository);
}
