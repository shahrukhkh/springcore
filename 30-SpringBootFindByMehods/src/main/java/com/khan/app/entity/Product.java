package com.khan.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pro_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	@Id
	private Integer id;
	private String name;
	private Double price;
}
