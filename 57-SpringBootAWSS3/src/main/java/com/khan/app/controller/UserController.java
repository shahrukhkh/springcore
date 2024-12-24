package com.khan.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khan.app.entity.User;
import com.khan.app.pojo.UserPojo;
import com.khan.app.service.S3Service;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private S3Service s3Service;
    
    @GetMapping({"","/"})
    public String getWelcome(Model model)
    {
    	model.addAttribute("listObj", s3Service.getAll());
    	return "Welcome";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserPojo user, Model model) {
        try {
            Optional<User> saveFile = s3Service.saveFile(user);
            if (saveFile.isPresent()) {
                User savedUser = saveFile.get();
                model.addAttribute("msgSuccess", "User saved successfully! Name of file is " 
                    + savedUser.getFileName() + " and file URL: " + savedUser.getS3url());
            } else {
                model.addAttribute("msgFail", "Error saving user");
            }
        } catch (Exception e) {
            model.addAttribute("msgErr", "An error occurred while saving the user: " + e.getMessage());
        
        }
        return "Index"; 
        }

    @GetMapping("/userForm")
    public String getUserForm(Model model) {
        model.addAttribute("userPojo", new UserPojo());
        return "Index"; 
    }
    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] fileContent = s3Service.downloadFile(fileName);

        if (fileContent == null) {
            return ResponseEntity.notFound().build(); 
        }

        ByteArrayResource resource = new ByteArrayResource(fileContent);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM) 
                .body(resource);
    }
    
    @GetMapping("/delete/{fileName}")
    public String deleteFile(@PathVariable String fileName ,Model model)
    {
    	boolean deleteFile = s3Service.deleteFile(fileName);
    	System.out.println(deleteFile);
    	if(deleteFile)
    	{
    		model.addAttribute("msg", fileName+" : File Deleted!");
    		System.out.println(fileName+" File is deleted!");
    	}
    	else {
    		model.addAttribute("msgErr", fileName+" : failed to delete!");
    	}
    	
    	model.addAttribute("listObj", s3Service.getAll());
    	return "Welcome";

    }

}
