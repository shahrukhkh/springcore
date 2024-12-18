package com.khan.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stdId;
	@NotBlank(message = "NAME CAN NOT BE EMPTY")
	@Pattern(regexp = "^[A-Za-z]{3,12}$", message = "NAME MUST BE BETWEEN 3 AND 12 CHARACTERS AND CONTAIN ONLY LETTERS")
	private String stdName;
	@NotBlank(message = "ADDRESS CAN NOT BE EMPTY")
	private String address;
	@NotBlank(message = "EMAIL CAN NOT BE EMPTY")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Invalid Gmail address")
	private String email;
	//@NotBlank(message = "PHONE NUMBER CAN NOT BE EMPTY")
	//@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	private Long phno;
	

}
