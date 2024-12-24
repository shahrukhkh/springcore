package com.khan.app.service;

import java.util.Optional;

import com.khan.app.entity.User;

public interface UserService {

	
	
	public Integer saveUser(User user);
	Optional<User> getOneUser(Integer id);
}
