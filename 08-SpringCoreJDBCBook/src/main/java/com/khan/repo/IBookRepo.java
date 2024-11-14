package com.khan.repo;

import java.util.List;

import com.khan.dto.Book;

public interface IBookRepo {

	void saveBook(Book book);
	
	List<Book> getAllBook();
}
