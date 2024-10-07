package com.asset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
