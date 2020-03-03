package com.adidaschallenge.AdidasChallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidaschallenge.AdidasChallenge.dto.CategoryDto;
import com.adidaschallenge.AdidasChallenge.dto.ProductDto;
import com.adidaschallenge.AdidasChallenge.provider.CategoryProvider;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryProvider categoryProvider;
	
	@GetMapping
	public List<CategoryDto> getAllCategories(){
		try {
			return categoryProvider.getAllCategories();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@PostMapping("/create")
	public CategoryDto saveCategory(@RequestBody CategoryDto category) {
		boolean saved;
		try {
			categoryProvider.saveCategory(category);
			saved=true;
		} catch (Exception e) {
			saved=false;
		}
		
		if (saved) {
			return category;
		}else {
			return null;
		}
	}
	
	
	@PostMapping("/delete")
	public boolean deleteCategory(@RequestBody Long idCategory) {
		try {
			categoryProvider.deleteCategory(idCategory);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	@GetMapping("/edit")
	public CategoryDto getCategory(@RequestBody Long idCategory){
		try {
			CategoryDto ctg = categoryProvider.getCategory(idCategory);
			return ctg;
		} catch (Exception e) {
			return null;
		}
	}
	

}
