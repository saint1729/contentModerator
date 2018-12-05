package com.target.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="CONTENTS")
public class Content {

	@Id
	@GeneratedValue
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("comment")
	private String comment;

	public Content() {
		super();
	}

	
	public Content(Long id, String userName, String comment) {
		this.id = id;
		this.userName = userName;
		this.comment = comment;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}
	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}
	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}
	@JsonProperty("userName")
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}
	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
	}
}
