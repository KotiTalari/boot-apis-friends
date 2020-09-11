package com.app.product.service;

import com.app.product.model.User;

public interface UserService {

	public int saveUser(String userObject);
	public String getUserById(long id);
	public String  deleteById(long id);
	public String updateUserById(String body, long id);
	public String getAllUsers();
	public String deleteAllUsers();
}
