package com.hexaware.bms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.bms.entity.Books;
import com.hexaware.bms.exceptions.BookAlreadyExistsException;
import com.hexaware.bms.exceptions.BookNotFoundException;
import com.hexaware.bms.exceptions.InvalidBookDataException;
import com.hexaware.bms.repository.BookRepository;
@Service
public class BookServiceImplementation implements BookService {
	
	@Autowired
	
	private BookRepository bookrepository;
	@Override
	public List<Books> getAllBooks(){
		return bookrepository.findAll();
	}
	
	 @Override
	    public Books getBookByIsbn(String isbn) {
	        return bookrepository.findById(isbn).orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));
	    }
	    @Override
	    public Books addBook(Books book) {
	        if (bookrepository.existsById(book.getIsbn())) {
	            throw new BookAlreadyExistsException("Book already exists with ISBN: " + book.getIsbn());
	        }
	    	
	        return bookrepository.save(book);
	    }
	    @Override
	    public Books updateBook(String isbn, Books updatedBook) {
	        Books book = bookrepository.findById(isbn)
	                .orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));
	        if (updatedBook.getTitle().length() < 2) {
	            throw new InvalidBookDataException("Title must be at least 2 characters long");
	        }
	        book.setTitle(updatedBook.getTitle());
	        book.setAuthor(updatedBook.getAuthor());
	        book.setPublicationYear(updatedBook.getPublicationYear());

	        return bookrepository.save(book);
	    }
	    
	    @Override
	    public String deleteBook(String isbn) {
	        Books book = bookrepository.findById(isbn)
	                .orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));

	        bookrepository.delete(book);
	        return "Book deleted with ISBN: " + isbn;
	    }

}
