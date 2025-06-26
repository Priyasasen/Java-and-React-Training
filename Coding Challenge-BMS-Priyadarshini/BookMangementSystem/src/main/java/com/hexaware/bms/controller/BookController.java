package com.hexaware.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.bms.entity.Books;
import com.hexaware.bms.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    
    @GetMapping("/getAllBooks")
    public List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @GetMapping("/{isbn}")
    public Books getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }
    
    @PostMapping("/addBooks")
    public Books addBook(@RequestBody @Valid Books book) {
        return bookService.addBook(book);
    }
    
    @PutMapping("/{isbn}")
    public Books updateBook(@PathVariable String isbn, @RequestBody @Valid Books book) {
        return bookService.updateBook(isbn, book);
    }
    
    @DeleteMapping("/{isbn}")
    public String deleteBook(@PathVariable String isbn) {
        return bookService.deleteBook(isbn);
    }

    
}
