package com.khan.app.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.app.h2.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
