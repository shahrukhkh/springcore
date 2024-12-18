package com.khan.app.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="product_tbl")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	private Integer id;
	private String name;
	
	@Lob
	private byte[] image;
	
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updateddate;
	
}
