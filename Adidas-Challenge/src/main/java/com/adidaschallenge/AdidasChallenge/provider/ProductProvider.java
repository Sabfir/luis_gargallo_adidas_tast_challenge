package com.adidaschallenge.AdidasChallenge.provider;

import java.util.List;

import com.adidaschallenge.AdidasChallenge.dto.ProductDto;

public interface ProductProvider {
	
	List<ProductDto> getAllProducts();

	void saveProduct(ProductDto product) throws Exception;
	
	boolean deleteProduct(Long idProduct) throws Exception;
	
	ProductDto getProduct(Long idProduct)  throws Exception;
}
