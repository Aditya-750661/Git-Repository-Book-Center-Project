package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookRepository;
import com.dao.OrderRepository;
import com.dao.UserRepository;
import com.model.Book;
import com.model.User;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepo; 
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Book postBook(Book b,long userId) {
		
		Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
        	
            User user = userOptional.get();
           
            System.out.println(user);
            
            b.setBookOwner(user);
               
            return bookRepo.save(b);
            		
        } else {
            return null;
	}
	}


	@Override
	public Book updateBook(long id,Book b) {
		
		Optional<Book> optionalBook = bookRepo.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setBookTitle(b.getBookTitle());
            book.setBookAuthor(b.getBookAuthor());
            book.setBookIsbn(b.getBookIsbn());
            book.setBookPrice(b.getBookPrice());
            book.setForRent(b.getForRent());
        
            return bookRepo.save(book);
        } else 
         
            return null;
	}
	
	@Override
	  public void deleteBook(long id) {
	        Optional<Book> bookOptional = bookRepo.findById(id);
	        if (bookOptional.isPresent()) {
	            Book book = bookOptional.get();
	            book.setDeleted(true);
	            bookRepo.save(book);
	        } else {
	            throw new IllegalArgumentException("Book with id " + id + " not found");
	        }
	    }


	@Override
	public Book getBookById(long id) {
		return bookRepo.findById(id).orElse(null);
	}

}
