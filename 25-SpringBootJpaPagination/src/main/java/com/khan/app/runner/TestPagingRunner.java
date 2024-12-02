package com.khan.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import com.khan.app.entity.ProductEntity;
import com.khan.app.repo.ProductRepo;
@Component
@Order(10)
public class TestPagingRunner implements CommandLineRunner{

	@Autowired
	private ProductRepo productRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Pageable pageable=PageRequest.of(1, 3);
		
		Page<ProductEntity> page = productRepo.findAll(pageable);
		
		page.getContent().forEach(System.out::println);
		
		System.out.println("Number of current slice: "+page.getNumber());
		System.out.println("Number of elements in this slice: "+page.getNumberOfElements());
		System.out.println("Size of current slice: "+page.getSize());
		System.out.println("Number of elements in this slice: "+page.getTotalElements());
		System.out.println("Total number of pages: "+page.getTotalPages());
		System.out.println("Current slice as pageable: "+page.getPageable());
		System.out.println("Sorting parameter for current slice: "+page.getSort());
		System.out.println("Slice has content: "+page.hasContent());
		System.out.println("Is first slice: "+page.isFirst());
		System.out.println("is last slice: "+page.isLast());
		System.out.println("has next slice: "+page.hasNext());
		System.out.println("has previous slice: "+page.hasPrevious());
		System.out.println("returns next pageable object if has: "+page.nextPageable());
		System.out.println("returns previous pageable object if has: "+page.previousPageable());
		System.out.println("Returns a new Slice with the content of the current one mapped by the given. "+page.map(c -> "product: "+c));
		page.map(c -> "product: "+c).getContent().forEach(System.out::println);
		System.out.println("returns Pageable obj(next slice or last slice if it is last): "+page.nextOrLastPageable());
		System.out.println("returns Pageable obj(pr"
				+ "evious slice or first slice if it is first): "+page.previousOrFirstPageable());
		
	}
	
	
	
}
