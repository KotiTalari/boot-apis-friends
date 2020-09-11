package com.app.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.product.dao.UserDao;
import com.app.product.model.User;
import com.google.gson.Gson;

@Service
@Transactional
public class UserServiceImpl  implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public int saveUser(String userObject) {
		
	Gson gson=  new Gson();
	User user=gson.fromJson(userObject,User.class);
	User userObj=userDao.save(user);
	
	System.out.println("this is the object"+userObject);
		return 0;
	}

	@Override
	public String getUserById(long id) {
	User user=null;
        user=userDao.findById(id).orElse(new User());
        Gson gson =new Gson();
        String userInString= gson.toJson(user);
		return userInString;
	}

	@Override
	public String deleteById(long id) {
		userDao.deleteById(id);
		return "deleted Id"+id;
	}

	@Override
	public String updateUserById(String body, long id) {
		Gson gson=  new Gson();
		User givenUser=gson.fromJson(body,User.class);
		User existingUser=userDao.findById(id).orElse(new User());
		existingUser.setPass(givenUser.getPass());
		userDao.save(existingUser);
		
		return "User Updated"+id;
	}

	@Override
	public String getAllUsers() {
		Iterable<User> allUsers= new ArrayList<User>();
		allUsers=userDao.findAll();
		return allUsers.toString();
	}

	@Override
	public String deleteAllUsers() {
		userDao.deleteAll();
		return "deletedSuccess";
	} 
	
	
}
