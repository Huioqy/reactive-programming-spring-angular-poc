package com.reactive.mongodb.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.mongodb.demo.model.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, Long> {

}
