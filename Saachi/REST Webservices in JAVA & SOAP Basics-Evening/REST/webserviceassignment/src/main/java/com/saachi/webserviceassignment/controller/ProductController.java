package com.saachi.webserviceassignment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saachi.webserviceassignment.model.Product;
import com.saachi.webserviceassignment.service.ProductService;


@RestController
public class ProductController {

       
        //Using Product Service
		@Autowired  
    	private ProductService productService;

        
        @GetMapping("/products") 
    	public List<Product> getProducts()
    	{
    		return this.productService.getProducts();
    	}
    	
    	@GetMapping("/products/{productId}") 
    	public Product getProduct(@PathVariable String productId)
    	{
    		return this.productService.getProduct(productId);
    	}

    	
    	// Using Product Repository
    	private static Map<String, Product> productRepo = new HashMap<>();
         static {
             Product phone = new Product();
             phone.setId("p105");
             phone.setName("phone");
             productRepo.put(phone.getId(), phone);
         }
    	@RequestMapping(value = "/products", method = RequestMethod.POST)
    	   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
    	      productRepo.put(product.getId(), product);
    	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    	}
    	
        @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Object> delete(@PathVariable("id") String id) {
            productRepo.remove(id);
            return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
        }

        @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
            return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
        }
      
}

