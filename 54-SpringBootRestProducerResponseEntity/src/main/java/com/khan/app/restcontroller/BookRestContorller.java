package com.khan.app.restcontroller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.app.entity.BookEntity;

@RestController
@RequestMapping("/book")
public class BookRestContorller {

	
	@GetMapping("/fetch")
	public ResponseEntity<?> getBook()
	{
		//case-1
		//return new ResponseEntity<>(HttpStatus.OK);
		
		//case-2
		//return  new ResponseEntity<BookEntity>(
		//		new BookEntity(101,"Think And Grow Rich",129.93),HttpStatus.OK);
		
		//case-3
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authentication", "Authentic");
//		return new ResponseEntity<BookEntity>(headers,HttpStatus.OK);
		
		//case-4
		
		return new ResponseEntity<>(new BookEntity(101,"Think And Grow Rich",129.93),headers,HttpStatus.OK);
	}
	@GetMapping("/string")
	public String getData()
	{
		return "STRING";
	}
	@GetMapping("/getBook")
	public BookEntity getBookData()
	{
		return new BookEntity(101,"The Richest Man In Babylon",129.93);
	}
}
