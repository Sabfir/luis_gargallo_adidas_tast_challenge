package com.adidaschallenge.AdidasChallenge.provider.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidaschallenge.AdidasChallenge.dto.ProductDto;
import com.adidaschallenge.AdidasChallenge.entity.ProductEntity;
import com.adidaschallenge.AdidasChallenge.provider.ProductProvider;
import com.adidaschallenge.AdidasChallenge.repository.ProductRepository;

@Service
public class ProductProviderImpl implements ProductProvider{
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	//CONVERTERS----------------------------------------
	private ProductEntity convertTo(ProductDto prd) {
		return modelMapper.map(prd,ProductEntity.class);
	}
	
	private ProductDto convertTo(ProductEntity prd) {
		return modelMapper.map(prd,ProductDto.class);
	}
	//-------------------------------------------------
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto> list = new ArrayList<>();
		for (ProductEntity product : productRepository.findAll()) {
			list.add(convertTo(product));
		}
		
		return list;
	}
	


	@Override
	public void saveProduct(ProductDto product) throws Exception {
		try {
			productRepository.save(convertTo(product));
		} catch (Exception e) {
			throw new Exception("Error - saveProduct:" + e.getMessage());
		}
		
	}

	@Override
	public boolean deleteProduct(Long idProduct) throws Exception {
		try {
			productRepository.deleteById(idProduct);
			return true;
		} catch (Exception e) {
			throw new Exception("Error - deleteProduct:" + e.getMessage());
		}
	}

	@Override
	public ProductDto getProduct(Long idProduct) throws Exception {
		try {
			ProductDto prd =  convertTo(productRepository.findByIdProduct(idProduct));
			return prd;
		} catch (Exception e) {
			throw new Exception("Error - getProduct:" + e.getMessage());
		}
	}

}
