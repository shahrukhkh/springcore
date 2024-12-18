package com.khan.app.restcontroller;

import java.util.Enumeration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/path")
public class UserRestController {

	@GetMapping("/dataa")
	public ResponseEntity<String> getDataA(
			@RequestParam("id") Integer id ,@RequestParam("name") String name)
	{
		System.out.println("id: "+id + " name: "+name);
		return new ResponseEntity<String>("Check Console",HttpStatus.OK);
	}
	@GetMapping("/datab/{id}/{name}")
	public ResponseEntity<String> getDataB(
			@PathVariable("id") Integer id ,@PathVariable("name") String name)
	{
		System.out.println("id: "+id + " name: "+name);
		return new ResponseEntity<String>("Check Console",HttpStatus.OK);
	}
	@GetMapping("/details")
	public ResponseEntity<String> getHeaderData(
			@RequestHeader("Authentication") Integer id ,@RequestHeader("name") String name, HttpServletRequest req)
	{
		Enumeration<String> names = req.getHeaderNames();
		while(names.hasMoreElements())
		{
			System.out.println(names.nextElement());
		}
		System.out.println("id: "+id + " name: "+name);
		return new ResponseEntity<String>("Check Console",HttpStatus.OK);
	}
}
