package com.khan.app.entity;

import org.hibernate.annotations.GenericGenerator;

import com.khan.app.generator.CustomGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user_tbl")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(generator = "test")
	@GenericGenerator(name = "test",type = CustomGenerator.class)
	private String id;
	private String name;
}
