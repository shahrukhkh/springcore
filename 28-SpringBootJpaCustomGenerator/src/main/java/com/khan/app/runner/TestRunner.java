package com.khan.app.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.entity.UserEntity;
import com.khan.app.repo.UserRepo;
@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;
	@Override
	public void run(String... args) throws Exception {
		UserEntity userEntity = new UserEntity();
		userEntity.setName("Shahrukh");
		UserEntity userEntity2 = new UserEntity();
		userEntity2.setName("Manish");
		UserEntity userEntity3 = new UserEntity();
		userEntity3.setName("Ram");
		
		userRepo.saveAll(Arrays.asList(userEntity,userEntity2,userEntity3));
		
			}

}
