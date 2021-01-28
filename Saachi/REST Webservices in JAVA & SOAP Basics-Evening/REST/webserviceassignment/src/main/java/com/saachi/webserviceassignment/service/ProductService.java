package com.saachi.webserviceassignment.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.saachi.webserviceassignment.model.Product;

@Service 
public class ProductService {

	List<Product> list;
	
	public ProductService() {
		list = new ArrayList<>();
		list.add(new Product("p101", "Laptop"));
		list.add(new Product("p102", "table"));
		list.add(new Product("p103", "chair"));
		list.add(new Product("p104", "watch"));
	}
	
	public List<Product> getProducts() {
		return list;
	}
	
	public Product getProduct(String productId)
	{
		Product product = null;
		for(Product checkProduct: list) 
		{
			String id=checkProduct.getId();
			if(id.equals(productId))
			{
				product =checkProduct ;
				break;
			}
		}
		return product;
	}
	
	public Product addProduct(Product product) {
		this.addProduct(product);
		return product;
	}

	public void deleteProduct(String productId) {
		for(Product product: list) 
		{
			if(product.getId() == productId)
			{
				this.list.remove(product);
				break;
			}
		}	
	}
	
}
