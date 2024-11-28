package com.khan.app.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.khan.app.db.Mydb;

@Configuration
public class AppConfig {


    @Bean
    @Profile("dev")
    Mydb m1()
	{
		return new Mydb();
	}
}
