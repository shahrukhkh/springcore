package com.khan.app.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.khan.app.entity.ProductEntity;

public interface ProductRepo extends PagingAndSortingRepository<ProductEntity, Integer> {

}
