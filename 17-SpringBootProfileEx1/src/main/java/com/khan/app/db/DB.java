package com.khan.app.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties("my.app")
@Component
public class DB {

	
	private String db;
}
