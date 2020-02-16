package net.jin.model;

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
	private Long freeboardid;
	private String content;
	private String title;
	private String writer;
}
