package com.app.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.service.UserService;
import com.google.gson.Gson;

@CrossOrigin(value="http://localhost:4200")
@RestController
@RequestMapping("/userapi")
public class UserCotroller {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="save", method=RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
	public String getUser(@RequestBody String body) {
		int id=userService.saveUser(body);
		return id+"";
	}

    @RequestMapping(value="getUser",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getByUserId(@RequestParam long id) {
         String user=userService.getUserById(id);
		return new ResponseEntity<String>(user,HttpStatus.OK);
	}
    
    @RequestMapping(value="deleteById",method=RequestMethod.DELETE)
    public String deleteById(@RequestParam long id) {
    String type=userService.deleteById(id);
    return type;
    }

    @RequestMapping(value="updateUser",method=RequestMethod.PUT,consumes =MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@RequestParam(value="id") long id,@RequestBody String body) {
    String updateid=userService.updateUserById(body, id);
    return updateid;
    }
    
    @RequestMapping(value="getAllUsers",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public String getAllUsers() {
    String allUsers=userService.getAllUsers();
    Gson gson= new Gson();
    return gson.toJson(allUsers);
    }

    
    @RequestMapping(value="deleteAllUsers",method=RequestMethod.DELETE)
    public String deleteAllUsers() {
    String success=userService.deleteAllUsers();
    return success;
    }

}
