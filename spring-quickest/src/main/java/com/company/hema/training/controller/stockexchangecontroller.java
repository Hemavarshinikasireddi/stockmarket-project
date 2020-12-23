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
import com.company.hema.training.entity.StockExchange;
import com.company.hema.training.service.stockexchangeservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class stockexchangecontroller {
	
	
	@Autowired
	stockexchangeservice service;
	
	//to get all details
	@RequestMapping("/stockexchanges")
	Iterable<StockExchange> getAlldata(){
		
		
		return service.getAllData();
	}
	
	
	@RequestMapping("/stockexchanges/name/{name}")
	Optional<StockExchange> getstockexchangeByName(@PathVariable String name){
		
		return service.getStockExchangeByName(name);
	}
	
	
	//For adding a new User
	@RequestMapping(method = RequestMethod.POST, value = "/stockexchanges")
	void addstockexchange(@RequestBody StockExchange stockexchange) {
		service.addStockExchange(stockexchange);
	}

//	For updating a User
	@RequestMapping(method = RequestMethod.PUT, value = "/stockexchanges/{id}")
	void updatestockexchange(@RequestBody  StockExchange stockexchange,@PathVariable int id) {
		service.updateStockExchange(stockexchange, id);
	}

	
	//For deleting a User
	@RequestMapping(method = RequestMethod.DELETE, value = "/stockexchanges/{name}")
	void deletestockexchange(@PathVariable String name) {
		service.deleteStockExchange(name);
	}

}
