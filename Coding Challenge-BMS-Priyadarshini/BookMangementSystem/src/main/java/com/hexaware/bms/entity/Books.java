package com.hexaware.bms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Books {
	@Id
	@NotBlank(message = "ISBN is required")
	private String isbn;
	
	@NotBlank(message = "Title is required")
	private String title;
	
	 @NotBlank(message = "Author is required")
	private String author;
	 
	@NotNull(message = "Publication year must not be null")
	@Positive(message = "Publication year must be a positive number")
	private int publicationYear;
	
	public Books() {}

	public Books(String isbn, String title, String author, int publicationYear) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
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

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	@Override
	public String toString() {
		return "Books [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publicationYear="
				+ publicationYear + "]";
	}

	
	
	
}
