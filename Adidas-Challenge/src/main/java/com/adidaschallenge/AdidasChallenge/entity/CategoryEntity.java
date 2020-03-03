package com.adidaschallenge.AdidasChallenge.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
public class CategoryEntity {
	
	@Id
//	@SequenceGenerator(name = "ADS_CATEGORY_SQ_GENERATOR", sequenceName = "ADS_CATEGORY_SQ", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADS_CATEGORY_SQ_GENERATOR")
	@GeneratedValue
	private Long idCategory;
	@Column(nullable = false, length = 3)
	private String codeCategory;
	@Column(nullable = false)
	private String nameCategory;
	@OneToMany(mappedBy="category")
	private List<ProductEntity> products;
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public String getCodeCategory() {
		return codeCategory;
	}
	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	
	

}
