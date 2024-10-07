package com.asset.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.model.ProductImage;

public interface ProductImageRepo extends JpaRepository<ProductImage, Integer>{

}
