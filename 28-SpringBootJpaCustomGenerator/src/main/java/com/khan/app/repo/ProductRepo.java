package com.khan.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.app.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String>{

}
