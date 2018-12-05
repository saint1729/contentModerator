package com.target.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="OBJECTIONABLES")
public class Objectionable {

	@Id
	@GeneratedValue
	@JsonProperty("id")
	private Long Id;
	@JsonProperty("phrase")
	private String phrase;
	
	
	public Objectionable() {
		super();
	}
	
	@JsonProperty("id")
	public Long getId() {
		return Id;
	}
	@JsonProperty("id")
	public void setId(Long id) {
		Id = id;
	}
	@JsonProperty("phrase")
	public String getPhrase() {
		return phrase;
	}
	@JsonProperty("phrase")
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	
	
	
}
