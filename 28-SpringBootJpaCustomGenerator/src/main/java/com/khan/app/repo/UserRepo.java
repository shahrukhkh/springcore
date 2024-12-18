package com.khan.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khan.app.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, String> {

}
