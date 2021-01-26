package com.saachi.soapWebService;

import java.util.List;

import com.saachi.soapWebServiceController.ProductController;
import com.saachi.soapWebServiceModel.Product;

public class ProductService {
	
	public String addProduct(Product product) {
		List<Product> productList = ProductController.getProducts();
		productList.add(product);
		return "Product added in the existing stock";
	}		
}
