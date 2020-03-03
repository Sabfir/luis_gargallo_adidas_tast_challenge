package com.adidaschallenge.AdidasChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidaschallenge.AdidasChallenge.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	ProductEntity findByIdProduct(Long idProduct);
}
