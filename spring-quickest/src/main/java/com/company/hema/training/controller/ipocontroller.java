package com.company.hema.training.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.hema.training.entity.CompanyEntity;
import com.company.hema.training.entity.IPODetailEntity;
import com.company.hema.training.entity.StockExchange;
import com.company.hema.training.service.iposervice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/ipodetails")
public class ipocontroller {
	
	@Autowired
	iposervice service;
	
//	For updating a IPO
	@RequestMapping(method = RequestMethod.PUT, value = "/ipo/{id}")
	void updateUser(@RequestBody IPODetailEntity ipo,@PathVariable int id) {
		service.updateIPO(ipo,id);
	}
	//to get all details
		@RequestMapping("/ipo")
		Iterable<IPODetailEntity> getAlldata(){
			
			
			return service.getAllData();
		}
		
		
		@RequestMapping("/ipo/name/{name}")
		Optional<IPODetailEntity> getipoByName(@PathVariable String name){
			
			return service.getipoByName(name);
		}
		
		@RequestMapping(value="/ipo/id/{id}",method = RequestMethod.GET)
	    Optional<IPODetailEntity> getipodetailById(@PathVariable int id){
		
		return service.getipodetailById(id);
	}
		//For adding a new User
		@RequestMapping(method = RequestMethod.POST, value = "/ipo")
		void addipo(@RequestBody IPODetailEntity ipo) {
			service.addipo(ipo);
		}

//		
		
		//For deleting a User
		@RequestMapping(method = RequestMethod.DELETE, value = "/ipo/{id}")
		void deletestockexchange(@PathVariable int id) {
			service.deleteipo(id);
		}

	
	
}
