package com.khan.app.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@JsonProperty("user_unq_id")
	private Integer userId;
	private String userName;
	@JsonIgnore
	private String password;
	private List<String> permissions;
	private String[] courses;
	private Map<String,String> aboutCourse;
	
}
