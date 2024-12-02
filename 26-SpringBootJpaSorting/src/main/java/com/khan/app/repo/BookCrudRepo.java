package com.khan.app.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.khan.app.entity.BookEntity;

public interface BookCrudRepo extends PagingAndSortingRepository<BookEntity, Integer> {

}
