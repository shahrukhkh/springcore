package com.khan.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.app.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findByFileName(String fileName);


}
