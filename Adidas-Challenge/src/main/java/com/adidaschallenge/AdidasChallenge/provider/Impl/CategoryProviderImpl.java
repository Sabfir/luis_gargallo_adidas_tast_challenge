package com.adidaschallenge.AdidasChallenge.provider.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidaschallenge.AdidasChallenge.dto.CategoryDto;
import com.adidaschallenge.AdidasChallenge.entity.CategoryEntity;
import com.adidaschallenge.AdidasChallenge.provider.CategoryProvider;
import com.adidaschallenge.AdidasChallenge.repository.CategoryRepository;

@Service
public class CategoryProviderImpl implements CategoryProvider {
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	//CONVERTERS --------------------------------------
	private CategoryEntity convertTo(CategoryDto ctg) {
		return modelMapper.map(ctg,CategoryEntity.class);
	}
	
	private CategoryDto convertTo(CategoryEntity ctg) {
		return modelMapper.map(ctg,CategoryDto.class);
	}
	//--------------------------------------------------
	
	@Override
	public List<CategoryDto> getAllCategories() throws Exception {
		List<CategoryDto> list = new ArrayList<>();
		try {
			for (CategoryEntity category : categoryRepository.findAll()) {
				list.add(convertTo(category));
			}
		} catch (Exception e) {
			throw new Exception("Error - getAllCategories:" + e.getMessage()); 
		}
		
		return list;
	}

	@Override
	public void saveCategory(CategoryDto category) throws Exception {
		try {
			categoryRepository.save(convertTo(category));
		} catch (Exception e) {
			throw new Exception("Error - saveCategory:" + e.getMessage()); 
		}
		
	}

	@Override
	public boolean deleteCategory(Long idCategory) throws Exception {
		try {
			categoryRepository.deleteById(idCategory);
			return true;
		} catch (Exception e) {
			throw new Exception("Error - deleteCategory:" + e.getMessage());
		}
	}

	@Override
	public CategoryDto getCategory(Long idCategory) throws Exception {
		try {
			CategoryDto ctg =  convertTo(categoryRepository.findByIdCategory(idCategory));
			return ctg;
		} catch (Exception e) {
			throw new Exception("Error - getProduct:" + e.getMessage());
		}
	}
	
	
	
	
}
