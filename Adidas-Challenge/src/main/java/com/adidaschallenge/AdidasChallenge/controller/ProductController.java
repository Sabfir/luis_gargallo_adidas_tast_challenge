package com.adidaschallenge.AdidasChallenge.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidaschallenge.AdidasChallenge.dto.ChangeCurrencyDto;
import com.adidaschallenge.AdidasChallenge.dto.ProductDto;
import com.adidaschallenge.AdidasChallenge.provider.ProductProvider;



@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductProvider productProvider;
	
	@GetMapping
	public List<ProductDto> getAllProducts(){
		return productProvider.getAllProducts();
	}
	
	@PostMapping("/create")
	public ProductDto saveProduct(@RequestBody ProductDto product) {
		boolean saved;
		try {
			productProvider.saveProduct(product);
			saved=true;
		} catch (Exception e) {
			saved=false;
		}
		
		if (saved) {
			return product;
		}else {
			return null;
		}
	}
	
	@PostMapping("/changeCurrency")
	public ProductDto changeCurrency(@RequestBody ChangeCurrencyDto changeCurrency) throws Exception {
		try {
			String newCurrency = changeCurrency.getCurrency().replace(" ", "");
			if (newCurrency.length()==3) {
				if ("EUR".equals(newCurrency.toUpperCase())) {
					ProductDto product = productProvider.getProduct(changeCurrency.getIdProduct());
					String urlChangeCurrency = "http://data.fixer.io/api/latest?access_key=280af37cf85af58cf09239274e7027dd&symbols="+product.getCurrency();
					URL url = new URL(urlChangeCurrency);
					URLConnection conex = url.openConnection();
					
					BufferedReader in = new BufferedReader(new InputStreamReader(conex.getInputStream()));
					String linea="";
					String resultJson="";
					while ((linea = in.readLine()) != null) {
				        resultJson+=linea;  
					}
					Double valorConverter;
					try {
						JSONObject jsonObj = new JSONObject(resultJson);
						JSONObject rates = (JSONObject)jsonObj.get("rates");
						valorConverter = rates.getDouble(product.getCurrency());
		
					} catch (Exception e) {
						throw new Exception("ERROR - getRatesForNewCurrency:" +e.getMessage());
					}
			
					product.setCurrency(newCurrency);
					product.setPrice(product.getPrice()/valorConverter);
					productProvider.saveProduct(product);
					return product;
				} else {
					newCurrency = newCurrency.toUpperCase();
					String urlChangeCurrency = "http://data.fixer.io/api/latest?access_key=280af37cf85af58cf09239274e7027dd&symbols="+newCurrency;
					URL url = new URL(urlChangeCurrency);
					URLConnection conex = url.openConnection();
					
					BufferedReader in = new BufferedReader(new InputStreamReader(conex.getInputStream()));
					String linea="";
					String resultJson="";
					while ((linea = in.readLine()) != null) {
				        resultJson+=linea;  
					}
					Double valorConverter;
					try {
						JSONObject jsonObj = new JSONObject(resultJson);
						JSONObject rates = (JSONObject)jsonObj.get("rates");
						valorConverter = rates.getDouble(newCurrency);
		
					} catch (Exception e) {
						throw new Exception("ERROR - getRatesForNewCurrency:" +e.getMessage());
					}
					
					ProductDto product = productProvider.getProduct(changeCurrency.getIdProduct());
					product.setCurrency(newCurrency);
					product.setPrice(product.getPrice()*valorConverter);
					productProvider.saveProduct(product);
					return product;
				}
				
			}
			
		} catch (Exception e) {
			throw new Exception("ERROR - changeCurrency:" +e.getMessage());
		}
		return null;
	} 
	
	
	
	@DeleteMapping("/delete")
	public boolean deleteProduct(@RequestBody Long idProduct) {
		try {
			productProvider.deleteProduct(idProduct);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	@GetMapping("/edit")
	public ProductDto getProduct(@RequestBody Long idProduct){
		try {
			ProductDto prd = productProvider.getProduct(idProduct);
			return prd;
		} catch (Exception e) {
			return null;
		}
	}
	
	

}
