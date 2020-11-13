package com.sts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorid;
	private String firstName;
	private String lastName;
	private String language;
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Author(int authorid, String firstName, String lastName, String language, Book book) {
		super();
		this.authorid = authorid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
		this.book = book;
	}

	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}



	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
				+ language + ", book=" + book + "]";
	}
	
	
	
}
