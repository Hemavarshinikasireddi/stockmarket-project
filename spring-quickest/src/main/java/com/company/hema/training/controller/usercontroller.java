package com.company.hema.training.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.hema.training.entity.UserDetails;
import com.company.hema.training.service.userservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/user")
public class usercontroller {

	
	@Autowired
	userservice service;
	
	//to get all details
	@RequestMapping("/users")
	Iterable<UserDetails> getAlldata(){
		
		
		return service.getAllData();
	}
	
	
	@RequestMapping("/users/{name}")
	Optional<UserDetails> getCompanyByName(@PathVariable String name){
		
		return service.getUserByName(name);
	}
	
	
	//For adding a new User
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	void addUser(@RequestBody UserDetails user) {
		service.addUser(user);
	}

//	For updating a User
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	void updateUser(@RequestBody UserDetails user,@PathVariable int id) {
		service.updateUser(user, id);
	}

	//For deleting a User
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{name}")
	void deleteUser(@PathVariable String name) {
		service.deleteUser(name);
	}
	
}



