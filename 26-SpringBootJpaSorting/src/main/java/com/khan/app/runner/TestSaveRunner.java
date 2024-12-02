package com.khan.app.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.khan.app.entity.BookEntity;
import com.khan.app.repo.BookRepo;
@Component
@Order(1)
public class TestSaveRunner implements CommandLineRunner {

	@Autowired
	private BookRepo bookRepo;
	@Override
	public void run(String... args) throws Exception {

		 List<BookEntity> books = new ArrayList<>();

	        books.add(new BookEntity(101, "Think And Grow Rich", 8733.00));
	        books.add(new BookEntity(102, "The Power of Now", 699.00));
	        books.add(new BookEntity(103, "Atomic Habits", 1199.00));
	        books.add(new BookEntity(104, "The Subtle Art of Not Giving a F*ck", 850.00));
	        books.add(new BookEntity(105, "Deep Work", 950.00));
	        books.add(new BookEntity(106, "The Alchemist", 450.00));
	        books.add(new BookEntity(107, "Sapiens: A Brief History of Humankind", 1999.00));
	        books.add(new BookEntity(108, "Meditations", 599.00));
	        books.add(new BookEntity(109, "Rich Dad Poor Dad", 699.00));
	        books.add(new BookEntity(110, "How to Win Friends and Influence People", 550.00));
	        books.add(new BookEntity(111, "Man's Search for Meaning", 799.00));
	        books.add(new BookEntity(112, "The 7 Habits of Highly Effective People", 1099.00));
	        books.add(new BookEntity(113, "Can't Hurt Me", 899.00));
	        books.add(new BookEntity(114, "Start with Why", 750.00));
	        books.add(new BookEntity(115, "The 4-Hour Workweek", 850.00));
	        books.add(new BookEntity(116, "Ego is the Enemy", 650.00));
	        books.add(new BookEntity(117, "Drive", 500.00));
	        books.add(new BookEntity(118, "Grit", 899.00));
	        books.add(new BookEntity(119, "The Lean Startup", 1199.00));
	        books.add(new BookEntity(120, "Good to Great", 999.00));

		
		bookRepo.saveAll(books);
		
	}

}
