package com.khan.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.khan.app.entity.ProductEntity;

public interface ProductCrudRepo extends CrudRepository<ProductEntity, Integer> {

}
