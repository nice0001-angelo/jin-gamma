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
}
