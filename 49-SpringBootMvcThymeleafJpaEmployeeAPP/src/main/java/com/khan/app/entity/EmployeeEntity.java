package com.khan.app.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "emp_tbl")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	private Integer empId;
	
	@Column(name = "ename")
	private String empName;
	
	@Column(name = "egender")
	private String empGender;
	
	@Column(name = "edept")
	private String empDept;
	
	@Column(name = "edob")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date empDob;
	
	@Column(name = "esal")
	private Double empSal;
	
	
	@Column(name = "ehra")
	private Double empHra;
	
	@Column(name = "eta")
	private Double empTa;
	

	@CreationTimestamp
	@Column(name = "ecreatedon" , updatable = false)
	private String createdOn;
	
	@UpdateTimestamp
	@Column(name = "eupdatedon",insertable = false)
	private String updatedOn;
}
