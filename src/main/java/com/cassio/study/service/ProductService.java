package com.cassio.study.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cassio.study.model.Product;
import com.google.common.collect.Lists;

@RestController
public class ProductService {
	
	Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	private List<Product> products = Lists.newArrayList();
	
	public ProductService() {
		reset();
	}
	
	@RequestMapping(path="/product", method=RequestMethod.GET, produces = "application/json")
    public List<Product> findAll() {
		logger.info("Returning all the products");
        return products;
    }
	
	@RequestMapping(path="/product/{id}", method=RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Product findById(@PathVariable("id") Integer id) {
		logger.info("Getting a product by id");
        return products.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
    }
	
	
    private void reset() {
		logger.info("Reseting the list of products");
        products = Lists.newArrayList();
        products.add(new Product(1, "Xperia E1", "Sony", 50.00));
        products.add(new Product(2, "Xperia Z1 Mini", "Sony", 200.00));
    }
	
}
