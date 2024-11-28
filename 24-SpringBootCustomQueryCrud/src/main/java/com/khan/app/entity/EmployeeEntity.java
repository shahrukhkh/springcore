package com.khan.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emp_tbl")
public class EmployeeEntity {

	@Id
	@Column(name = "id")
	private Integer empId;
	@Column(name = "name")
	private String empName;
	@Column(name = "dept")
	private Integer dept;
	@Column(name = "salary")
	private Double empSalary;
	
}
