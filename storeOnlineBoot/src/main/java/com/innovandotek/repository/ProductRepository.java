package com.innovandotek.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.innovandotek.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByNameContaining(String name);
	
}
