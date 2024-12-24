package com.khan.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.app.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
	Optional<User> findByUserEmail(String email);
}
