package com.sts.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import com.sts.entities.Book;

@Controller
public interface BookRepository extends CrudRepository<Book, Integer> {
	
	public Book findById(int id);

}
