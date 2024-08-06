package com.practice.onlinestore.productservice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.onlinestore.productservice.dto.ProductRequest;
import com.practice.onlinestore.productservice.dto.ProductResponse;
import com.practice.onlinestore.productservice.model.Product;
import com.practice.onlinestore.productservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private ProductRepository productRepo;
	
	public void createProduct(ProductRequest productRequest) {
		Product product = this.modelmapper.map(productRequest, Product.class);
		
		productRepo.save(product);
		System.out.println("product"+ product.getId()+" is Saved");
	}

	public List<ProductResponse> getAllProducts() {
		
		List<Product> products = productRepo.findAll();
		
		return products.stream().map(this::mapToProductResponse).toList();
		
	}

	private ProductResponse mapToProductResponse(Product product) {
		return this.modelmapper.map(product, ProductResponse.class);
	}
	
	

}
