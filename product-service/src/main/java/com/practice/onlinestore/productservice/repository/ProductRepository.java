package com.practice.onlinestore.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.onlinestore.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
