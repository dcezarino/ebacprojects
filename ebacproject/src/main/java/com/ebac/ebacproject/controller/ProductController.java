package com.ebac.ebacproject.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebac.ebacproject.entity.Product;
import com.ebac.ebacproject.repository.ProductRepository;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable Long id) {
		return this.productRepository.findById(id).get();
	}


	@PostMapping
	public Product create(@RequestBody Product product) {
		return this.productRepository.save(product);
	}

	@PutMapping("/{id}")
	public Product update(@PathVariable Long id, @RequestBody Product product) {
		Product productDatabase = this.productRepository.findById(id).get();
		BeanUtils.copyProperties(product, productDatabase, "id", "createdAt");
		return this.productRepository.save(productDatabase);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.productRepository.deleteById(id);
	}

}
