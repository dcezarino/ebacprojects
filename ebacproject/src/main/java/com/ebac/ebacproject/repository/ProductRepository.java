package com.ebac.ebacproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebac.ebacproject.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
