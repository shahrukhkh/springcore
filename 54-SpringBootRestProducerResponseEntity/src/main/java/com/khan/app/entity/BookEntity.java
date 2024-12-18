package com.khan.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

	
	private Integer bookId;
	private String bookName;
	private Double bookPrice;
}
