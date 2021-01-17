package com.reactive.mongodb.demo.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.mongodb.demo.model.Product;
import com.reactive.mongodb.demo.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository; 
	
	@Autowired
	private NextSequenceService nextSequenceService;

	@Override
	public Flux<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Mono<Product> getProduct(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Mono<Product> createProduct(Product product) {
		product.setId(nextSequenceService.getNextSequence("customSequences"));
		return productRepository.save(product);
	}

	@Override
	public Mono<Product> updateProduct(final Product product) {
		return productRepository.findById(product.getId()).flatMap(existingProduct -> {
			existingProduct.setPrice(product.getPrice());
			existingProduct.setProductDesc(product.getProductDesc());
			existingProduct.setProductName(product.getProductName());
			return productRepository.save(existingProduct);
		});
	}

	@Override
	public Mono<Void> deleteProduct(Long id) {
		return productRepository.deleteById(id);
	}

}
