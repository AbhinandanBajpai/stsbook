package com.sts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sts.DAO.BookRepository;
import com.sts.entities.Book;

@Controller
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		
//		list.add(new Book(1,"Half Girlfriend","Chetan Bhagat"));
//		list.add(new Book(2,"Meluha","XYZ"));
//		list.add(new Book(3,"Rang Bhoomi","Prem Chand"));
//	}
//	
	
	//getting all books
	
	public List<Book> getAllBook(){
		
//		return book list;
		
		List<Book> book =(List<Book>)bookRepository.findAll(); //
		return book;
	}
	
	//Getting Single Book By Id
	
	public Book getBookById(int id){
		
		Book book = null;
		
		try {
			
//			book = list.stream().filter(e->e.getId()==id).findFirst().get();
		      book = bookRepository.findById(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		 
		 
		 return book;
	}
	
	
	//adding a book
	
	public Book addBook(Book b) {
//		list.add(b);
//		return b;	
		
		Book save = bookRepository.save(b);
		return save;
	}
	
	
	//deleting a book
	
	public void deleateBook(int bid) {
		
//		list = list.stream().filter(e->e.getId()!=bid).collect(Collectors.toList());
		
		bookRepository.deleteById(bid);
	}
	
	//updating Book
	
	public void updateBook(Book book, int id) {
		
//		list=list.stream().map(b->{
//			if(b.getId()==id) {
//			    b.setAuthor(book.getAuthor());
//			    b.setTitle(book.getTitle());
//			}
//			return b;
//			
//		}).collect(Collectors.toList());
		book.setId(id);
		bookRepository.save(book);
		
	}
	
}
