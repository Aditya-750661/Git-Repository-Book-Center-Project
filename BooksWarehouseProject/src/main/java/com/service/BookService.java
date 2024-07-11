package com.service;

import com.model.Book;

public interface BookService {

	public Book postBook(Book b,long userId);
	
	public void deleteBook(long bookId);
	
	public Book updateBook(long id,Book b);
	
	public Book getBookById(long id);
}
