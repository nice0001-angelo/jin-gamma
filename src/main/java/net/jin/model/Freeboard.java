package net.jin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="freeboard")
public class Freeboard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="freeboardid")
	private Long freeboardid;
	
	@Column(name="content")
	private String content;
	
	@Column(name="title")
	private String title;
	
	@Column(name="writer")
	private String writer;

	public Long getFreeboardid() {
		return freeboardid;
	}

	public void setFreeboardid(Long freeboardid) {
		this.freeboardid = freeboardid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
