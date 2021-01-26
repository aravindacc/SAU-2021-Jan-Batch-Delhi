package com.saachi.soapWebServiceController;

import java.util.ArrayList;
import java.util.List;

import com.saachi.soapWebServiceModel.Product;

public class ProductController {
	
	static List<Product> list= new ArrayList<>();;
	
	public ProductController() {
		list.add(new Product("p101", "Laptop"));
		list.add(new Product("p102", "table"));
		list.add(new Product("p103", "chair"));
		list.add(new Product("p104", "watch"));
	}
	
	public static List<Product> getProducts() {
		return list;
	}

}
