package com.khan.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsConfig {

	@Value("${aws.access-key}")
	private String key;
	
	@Value("${aws.secret-key}")
	private String secret;
	
	@Bean
    public S3Client s3Client() {
		
		AwsBasicCredentials credentials= AwsBasicCredentials.create(key, secret);
        return S3Client.builder().credentialsProvider(StaticCredentialsProvider.create(credentials))
        		.region(Region.AP_SOUTH_1)
                .build();
    }
}
