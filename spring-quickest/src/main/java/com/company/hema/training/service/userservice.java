package com.company.hema.training.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hema.training.entity.UserDetails;
import com.company.hema.training.repository.userrepo;

@Service
public class userservice {
	
	@Autowired
	userrepo repo;
	
	public Iterable<UserDetails> getAllData() {
		return repo.findAll();
	}
	
	public Optional<UserDetails> getUserByName(String name){
		
		return repo.findByName(name);
	}
	
	
	public void addUser(UserDetails user) {
		
		repo.save(user);
	}
	
	public void deleteUser(String name) {
		repo.deleteByName(name);
	}
	
	public void updateUser(UserDetails user,Integer id) {
		
		repo.deleteById(id);
		repo.save(user);
	}
	
}

