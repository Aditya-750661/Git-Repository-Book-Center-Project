package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Book;
import com.service.BookService;
import com.service.UserService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Book> save(@RequestBody Book book,@RequestParam("userId") long id){
	
		Book b = bookService.postBook(book,id);
		System.out.println(b);
		if (b != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(b);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b);
	}
	
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.OK).body("Book deleted");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PutMapping("/update/{id}")
	 public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
     
		System.out.println("hello");
		System.out.println(bookDetails);
		Book updatedBook = bookService.updateBook(id, bookDetails);
        
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("unable to update books details").body(updatedBook);
        }
    }
	
	
	@GetMapping("/findId/{id}")
	public ResponseEntity<String> findUserId(@PathVariable("id") long id){
		
		Book b = bookService.getBookById(id);
		if (b!=null) {
		return ResponseEntity.status(HttpStatus.OK).body("Book Found");

		}
		else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book Not Found");

		}
	}
	

}
