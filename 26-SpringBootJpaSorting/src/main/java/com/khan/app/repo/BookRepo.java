package com.khan.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.khan.app.entity.BookEntity;

public interface BookRepo extends CrudRepository<BookEntity, Integer> {

}
