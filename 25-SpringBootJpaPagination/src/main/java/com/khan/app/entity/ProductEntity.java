package com.khan.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="prd_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

	@Id
	private Integer id;
	private String name;
	private Double price;
	
}
