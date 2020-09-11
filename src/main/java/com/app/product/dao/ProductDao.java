package com.app.product.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.product.model.Product;

public interface ProductDao extends CrudRepository<Product, Long>{



}
