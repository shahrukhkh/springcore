package com.khan.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.khan.app.entity.BookEntity;
import com.khan.app.repo.BookCrudRepo;

@Component
public class TestSortRunner implements CommandLineRunner {

	@Autowired
	private BookCrudRepo bookCrudRepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==========Sort in ascending=========");
		Sort by = Sort.by("price");
		Iterable<BookEntity> all = bookCrudRepo.findAll(by);
		all.forEach(System.out::println);
		
		System.out.println("==========Sort in descending=========");
		Sort by2 = Sort.by(Direction.DESC, "name", "price");
		Iterable<BookEntity> all2 = bookCrudRepo.findAll(by2);
		all2.forEach(System.out::println);
		
		System.out.println("==========Sort price in ascending and name in descending=========");
		Sort by3 = Sort.by(Order.asc("price"),Order.desc("name"));
		Iterable<BookEntity> all3 = bookCrudRepo.findAll(by3);
		all3.forEach(System.out::println);
		

	}

}
