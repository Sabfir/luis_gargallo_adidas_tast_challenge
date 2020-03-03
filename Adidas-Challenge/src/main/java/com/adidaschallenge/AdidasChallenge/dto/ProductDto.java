package com.adidaschallenge.AdidasChallenge.dto;

import com.adidaschallenge.AdidasChallenge.entity.CategoryEntity;

public class ProductDto {
	
	private Long idProduct;
	private String nameProduct;
	private String descProduct;
	private CategoryDto category;
	private Double price;
	private String currency;
	
	
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getDescProduct() {
		return descProduct;
	}
	public void setDescProduct(String descProduct) {
		this.descProduct = descProduct;
	}
	
	public CategoryDto getCategory() {
		return category;
	}
	public void setCategory(CategoryDto category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
	

}
