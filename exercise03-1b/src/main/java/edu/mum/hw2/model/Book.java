package edu.mum.hw2.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	private int isbn;
	
	private String title;
	
	private String author;
    
	@ManyToOne
	@JoinTable(name="Book_Publisher", joinColumns=@JoinColumn(name="Book_id", unique=true), inverseJoinColumns=@JoinColumn(name="Publisher_id", unique=true))
	private Publisher publisher;
	

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	

}
