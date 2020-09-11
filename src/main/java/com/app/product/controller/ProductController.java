package com.app.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.model.Product;
import com.app.product.service.ProductService;

@RestController
@RequestMapping("/productapi")
public class ProductController {

@Autowired
ProductService productService;
	 @RequestMapping(value="saveproduct", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
	  public String saveProduct(@RequestBody String body) { 
		 int id=productService.saveProduct(body); 
	  return id+""; 
	  }
	
	 @RequestMapping(value="getProductById",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> getByUserId(@RequestParam(value="pId") long pId) {
	         String product=productService.getProductById(pId);
			return new ResponseEntity<String>(product,HttpStatus.OK);
		}

}
