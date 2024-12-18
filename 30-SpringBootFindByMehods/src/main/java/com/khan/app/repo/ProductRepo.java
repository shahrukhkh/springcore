package com.khan.app.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.app.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	
	//where name=? and price=?
	Optional<Product> findByNameAndPrice(String name,Double price);
	//where name=? and price=?
	List<Product> findByNameOrPrice(String name,Double price);
	//where p1_0.price between ? and ?
	List<Product> findByPriceBetween(Double price1,Double price2);
	//where p1_0.price<?
	List<Product> findByPriceLessThan(Double price1);
	//where p1_0.price<=?
	List<Product> findByPriceLessThanEqual(Double price1);
	//p1_0.price>?
	List<Product> findByPriceGreaterThan(Double price1);
	//p1_0.price>=?
	List<Product> findByPriceGreaterThanEqual(Double price1);
	//where p1_0.price>?
	List<Product> findByPriceAfter(Double price1);
	//where p1_0.price<?
	List<Product> findByPriceBefore(Double price1);
	//where p1_0.price is null
	List<Product> findByPriceIsNull();
	//where p1_0.price is not null
	List<Product> findByPriceNotNull();
	//where p1_0.name like ? escape '\\'
	List<Product> findByNameLike(String s);
	//where p1_0.name not like ? escape '\\'
	List<Product> findByNameNotLike(String s);
	//where p1_0.name like ? escape '\\'
	List<Product> findByNameStartingWith(String s);
	//where p1_0.name like ? escape '\\'
	List<Product> findByNameEndingWith(String s);
	//where p1_0.name like ? escape '\\'
	List<Product> findByNameContaining(String s);
	//order by p1_0.price desc
	List<Product> findByOrderByPriceDesc();
	//where p1_0.name<>?
	List<Product> findByNameNot(String s);
	//where p1_0.price in (?,?,?)
	List<Product> findByPriceIn(List<Double> p);
	//where p1_0.price not in (?,?,?)
	List<Product> findByPriceNotIn(List<Double> p);
	//where upper(p1_0.name)=upper(?)
	List<Product> findByNameIgnoreCase(String s);
	
	
	
}
