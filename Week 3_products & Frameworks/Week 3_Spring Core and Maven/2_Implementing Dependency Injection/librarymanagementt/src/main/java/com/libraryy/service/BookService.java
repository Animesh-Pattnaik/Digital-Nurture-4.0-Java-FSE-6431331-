package com.libraryy.service;

import com.libraryy.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("BookService: delegating to repository...");
        bookRepository.getBooks();
    }
}
