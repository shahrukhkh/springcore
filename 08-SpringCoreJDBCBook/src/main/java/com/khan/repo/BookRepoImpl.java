package com.khan.repo;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.khan.dto.Book;

public class BookRepoImpl implements IBookRepo{

	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void saveBook(Book book) {
				
		
		String query="INSERT INTO books (bookid, bookname, bookprice) VALUES (?, ?, ?)";
		try {
			int update = jdbcTemplate.update(query,book.getBookId(),book.getBookName(),book.getBookPrice());
			if(update>=1)
			{
				System.out.println("Book inserted into Table || book "+book);
			}
			
		}
		catch(DuplicateKeyException ex)
		{
			System.out.println("Duplicate Book Entry");
		}
	}

	@Override
	public List<Book> getAllBook() {
		String  query ="SELECT BOOKID, BOOKNAME, BOOKPRICE FROM BOOKS";
		return jdbcTemplate.query(query,(rs,rowNum)->
		new Book(rs.getInt("bookid"),rs.getString("bookname"),rs.getDouble("bookprice"))
		);
	}
}
