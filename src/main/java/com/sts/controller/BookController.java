package com.sts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.Book;
import com.sts.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
//	@RequestMapping(value="/books", method = RequestMethod.GET)
	@GetMapping("/books")
	public ResponseEntity<List<Book>> book() {
		
		List<Book> list = bookService.getAllBook();
		
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return  ResponseEntity.of(Optional.of(list)); 
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable int id) {
		
		Book book = bookService.getBookById(id);
		
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		try {
		Book addBook = bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//Delete Book Handler
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable int id) {
		
		bookService.deleateBook(id);
	}

	
	//Update handler
	
	@PutMapping("books/{id}")
	public Book updateBook(@RequestBody Book book ,@PathVariable int id) {
		bookService.updateBook(book, id);
		return book;
	}
}
