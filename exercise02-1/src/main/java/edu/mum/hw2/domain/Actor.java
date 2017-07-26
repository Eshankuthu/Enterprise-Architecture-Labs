package edu.mum.hw2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Actor {

	@Column(name = "actorName")
	private String name;
	
	@Column(name = "actorRating")
	private int rating;
	
	@Column(name = "role")
	private String character;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	
	
}
