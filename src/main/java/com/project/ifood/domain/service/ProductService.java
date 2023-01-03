package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.Product;

public interface ProductService {

	Product save(Product product);
	Product update(Long id, Product product);
	Product findById(Long id);
	List<Product> findAll();
	void deleteById(Long id);
	Product checkIfProductExists(Long id);
}
