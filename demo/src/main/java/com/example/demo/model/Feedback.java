package com.example.demo.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Feedback {

	@Id
    private String id;
	
	@NotNull
	private String message;
	
    private String author;
    
    private int  helpfulCount;
    
    public Feedback(String message, String author) {
		this.id = UUID.randomUUID().toString();
		this.message = message;
		this.author = author;
		this.helpfulCount = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getHelpfulCount() {
		return helpfulCount;
	}

	public void increaseHelpfulCount() {
		this.helpfulCount++;
	}

}
