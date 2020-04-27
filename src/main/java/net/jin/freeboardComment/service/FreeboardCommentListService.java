/*
 * This is a Jin-gamma Project
 * File name : FreeboardCommentListService.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : For Freeboard CommentList Service
 */
package net.jin.freeboardComment.service;

import java.util.List;

import net.jin.model.FreeboardComment;


public interface FreeboardCommentListService {
	public List<FreeboardComment> getList(Long freeboardId);
}
