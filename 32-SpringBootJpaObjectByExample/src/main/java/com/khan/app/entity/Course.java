package com.khan.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course_tbl")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Course {

	@Id
	private Integer id;
	private String name;
	private Double price;
	private String batch;
	private String faculty;
}
