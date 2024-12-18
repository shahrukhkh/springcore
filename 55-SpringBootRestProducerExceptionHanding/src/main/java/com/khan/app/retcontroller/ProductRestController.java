package com.khan.app.retcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khan.app.customexception.ProductNotFoundException;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@GetMapping("/fetch/{id}")
	public ResponseEntity<String> getProduct(@PathVariable("id") Integer id)
	{
		
		if(id>1000)
		{
			throw new ProductNotFoundException("Product is not found for given id: "+id);
		}
		return new ResponseEntity<String>("Found the product",HttpStatus.OK);
	}
}
