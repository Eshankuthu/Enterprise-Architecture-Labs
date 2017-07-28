package edu.mum.hw3.domain.e;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="BookE")
public class Book {

	@Id 
	private int isbn;
	private String title;
	private String author;

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
