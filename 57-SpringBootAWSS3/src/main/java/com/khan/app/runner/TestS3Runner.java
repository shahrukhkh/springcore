package com.khan.app.runner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khan.app.service.S3Service;

//@Component
public class TestS3Runner implements CommandLineRunner{

	//@Autowired
	private S3Service s3Service;
	
	//@Value("${aws.bucket.name}")
	private String bucketName;

	@Override
	public void run(String... args) throws Exception {
		
	
		
		//s3Service.uploadFile(bucketName, new Date().toString(),Paths.get("C:\\Users\\khans\\OneDrive\\Desktop\\ShahrukhKhanResumeIntern.docx") );
	}
}
