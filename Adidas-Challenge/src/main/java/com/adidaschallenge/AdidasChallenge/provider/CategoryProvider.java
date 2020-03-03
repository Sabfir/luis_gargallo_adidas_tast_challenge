package com.adidaschallenge.AdidasChallenge.provider;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adidaschallenge.AdidasChallenge.dto.CategoryDto;

public interface CategoryProvider {
	
	List<CategoryDto> getAllCategories() throws Exception;
	
	void saveCategory(CategoryDto category) throws Exception;
	
	boolean deleteCategory(Long idCategory) throws Exception;
	
	CategoryDto getCategory(Long idCategory) throws Exception;
}
