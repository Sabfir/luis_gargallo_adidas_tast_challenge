package com.adidaschallenge.AdidasChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidaschallenge.AdidasChallenge.dto.CategoryDto;
import com.adidaschallenge.AdidasChallenge.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	CategoryEntity findByIdCategory(Long idCategory);

}
