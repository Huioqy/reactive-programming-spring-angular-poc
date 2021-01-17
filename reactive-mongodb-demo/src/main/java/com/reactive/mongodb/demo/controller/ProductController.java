package com.reactive.mongodb.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.mongodb.demo.model.Product;
import com.reactive.mongodb.demo.serivce.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	Flux<Product> getProducts() {
		return productService.getProducts();
	}
	
	@PostMapping("/products")
	Mono<Product> createProduct(@Valid @RequestBody Product product) {
		
		return productService.createProduct(product);
	}

	@GetMapping("/products/{id}")
	Mono<Product> getProductById(@PathVariable(value="id") Long productId) {
		return productService.getProduct(productId);
	}
	
	@PutMapping("/products")
	Mono<Product> updateProduct(@Valid @RequestBody Product product){
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/products/{id}") 
	Mono<Void> deleteProduct(@PathVariable(value="id") Long productId) {
		return productService.deleteProduct(productId);
	}
		
}
