package com.app.product.dao;

import java.util.List;

import com.app.product.model.Product;
import com.app.product.model.User;

public interface UserDaoCustom {
	
	public List<Product> getAllProductsByName();
}
