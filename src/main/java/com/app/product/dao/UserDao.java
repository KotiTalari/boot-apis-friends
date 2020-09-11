package com.app.product.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.product.model.Product;
import com.app.product.model.User;

public interface UserDao extends CrudRepository<User, Long>,UserDaoCustom {

}
