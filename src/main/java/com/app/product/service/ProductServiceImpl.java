package com.app.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.product.dao.ProductDao;
import com.app.product.model.Product;
import com.google.gson.Gson;

@Service
public class ProductServiceImpl  implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public int saveProduct(String body) {
		Gson gson= new Gson();
		Product product=gson.fromJson(body, Product.class);
		
		Product no=productDao.save(product);
		return no.getpId();
	}

	@Override
	public String  getProductById(long id) {
		Product product=null;
		int pId=Integer.parseInt(String.valueOf(id));
	    product=productDao.findById((long)pId).orElse(new Product());
		Gson gson= new Gson();
		String json=gson.toJson(product);
		return json;
	}



	

}
