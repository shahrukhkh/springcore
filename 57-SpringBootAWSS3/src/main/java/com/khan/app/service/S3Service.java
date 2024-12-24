package com.khan.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khan.app.entity.User;
import com.khan.app.pojo.UserPojo;
import com.khan.app.repo.UserRepo;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Utilities;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class S3Service {

	@Autowired
	private S3Client s3Client;
	@Value("${aws.bucket.name}")
	private String bucketName;
	@Autowired
	private UserRepo userRepo;

	public Optional<User> saveFile(UserPojo userPojo) {

		File file = convertMultipartfileToFile(userPojo.getFile());
		try {
			String fileName = UUID.randomUUID()
								  .toString()
								  .substring(0, 6) 
								  + "-"+ 
								  userPojo.getFile()
								  		  .getOriginalFilename();
			
			s3Client.putObject(PutObjectRequest
										.builder()
										.bucket(bucketName)
										.key(fileName)
										.acl(ObjectCannedACL.PUBLIC_READ)
										.build()
								, file.toPath());
			
			System.out.println("File uploaded successfully! " + fileName);

			S3Utilities s3Utilities = s3Client.utilities();

			String fileUrl = s3Utilities
								.getUrl(b -> b.bucket(bucketName)
											  .key(fileName))
								.toString();
			System.out.println(fileUrl);

			User user = User.builder()
							.name(userPojo.getName())
							.email(userPojo.getEmail())
							.s3url(fileUrl)
							.fileName(fileName)
							.build();

			User save = userRepo.save(user);
			System.out.println(save);
			return Optional.of(save);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File Failed to upload ! ");
			return Optional.of(null);
		} finally {
			if (file.exists()) {
				file.delete();
			}
			
		}

	}

	public byte[] downloadFile(String fileName) {
		ResponseInputStream<GetObjectResponse> object = s3Client
				.getObject(GetObjectRequest.builder().bucket(bucketName).key(fileName).build());

		try {
			byte[] content = object.readAllBytes();
			return content;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean deleteFile(String fileName) {

		try {
			s3Client.deleteObject(DeleteObjectRequest.builder().bucket(bucketName).key(fileName).build());
			User user = userRepo.findByFileName(fileName);
			if(user!=null)
			{
				userRepo.delete(user);
			}
			return true;
		} catch (S3Exception e) {

			System.out.println("Error deleting file: " + e.awsErrorDetails().errorMessage());
			e.printStackTrace();
			return false;
		}

	}

	public List<User> getAll() {
		return userRepo.findAll();
	}

	private File convertMultipartfileToFile(MultipartFile file) {

		File convertedFile = new File(file.getOriginalFilename());
		try (FileOutputStream fio = new FileOutputStream(convertedFile)) {
			fio.write(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return convertedFile;
	}

//	 public void uploadFile(String bucketName, String key, Path filePath) {
//	        s3Client.putObject(
//	                PutObjectRequest.builder()
//	                        .bucket(bucketName)
//	                        .key(key)
//	                        .build(),
//	                filePath
//	        );
//	        System.out.println("File uploaded successfully!");
//	    }

}
