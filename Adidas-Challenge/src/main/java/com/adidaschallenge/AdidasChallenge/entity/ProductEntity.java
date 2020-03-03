package com.adidaschallenge.AdidasChallenge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class ProductEntity {
	
	@Id
	/*
	 * @SequenceGenerator(name = "ADS_PRODUCTS_SQ_GENERATOR", sequenceName =
	 * "ADS_PRODUCTS_SQ", allocationSize = 1)
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 * "ADS_PRODUCTS_SQ_GENERATOR")
	 */
	
	@GeneratedValue
	private Long idProduct;
	@Column(nullable = false)
	private String nameProduct;
	private String descProduct;
	@ManyToOne
	private CategoryEntity category;
	@Column(nullable = false)
	private Double price;
	//Default EUR
	@Column(nullable = false,length=3)
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
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
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
