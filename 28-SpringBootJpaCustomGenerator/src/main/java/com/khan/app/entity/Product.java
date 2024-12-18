package com.khan.app.entity;

import org.hibernate.annotations.GenericGenerator;

import com.khan.app.generator.ProductCustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Product {

	

	@Id
	@GeneratedValue(generator = "custom-id-generator")
	@GenericGenerator(name="custom-id-generator" ,type = ProductCustomIdGenerator.class)
	private String pid;
	
}
