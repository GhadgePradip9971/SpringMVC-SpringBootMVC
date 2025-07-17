package com.nt.service;

import java.util.List;

import com.nt.model.Book;

public interface IBookService {
	
	List<Book> getAllBooks();
    void saveBook(Book book);
    Book getBookById(Long id);
    void deleteBook(Long id);

}
