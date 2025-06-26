package com.hexaware.bms.services;

import java.util.List;

import com.hexaware.bms.entity.Books;

public interface BookService {
	 List<Books> getAllBooks();

	    Books getBookByIsbn(String isbn);

	    Books addBook(Books book);

	    Books updateBook(String isbn, Books book);

	    String deleteBook(String isbn);
}
