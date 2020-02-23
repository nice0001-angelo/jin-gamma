/*
 * This is a Jin-gamma Project
 * File name : FreeboardComment.java
 * Created by : Jinhyun
 * Created on : Jan 2020
 * Contents : Model for FreeboardComment
 */
package net.jin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="freeboardComment")
public class FreeboardComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentid")
	private Long commentid;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "writedate")
	private Date writedate;
	
	@Column(name = "writer")
	private String writer;
	
	@ManyToOne(targetEntity = Freeboard.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "freeboardid"))
	private Long freeboardid;
	
	@Column(name = "commentoriginid")
	private Long commentOriginid;
	
	@Column(name = "commentlevel")
	private int commentLevel;

	public Long getCommentid() {
		return commentid;
	}

	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Long getFreeboardid() {
		return freeboardid;
	}

	public void setFreeboardid(Long freeboardid) {
		this.freeboardid = freeboardid;
	}

	public Long getCommentOriginid() {
		return commentOriginid;
	}

	public void setCommentOriginid(Long commentOriginid) {
		this.commentOriginid = commentOriginid;
	}

	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}
	
	
}
