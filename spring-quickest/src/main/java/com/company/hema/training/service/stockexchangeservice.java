package com.company.hema.training.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hema.training.entity.StockExchange;
import com.company.hema.training.repository.stockexchangerepo;

@Service
public class stockexchangeservice {
	
	@Autowired
	stockexchangerepo repo;
	
	public Iterable<StockExchange> getAllData() {
		return repo.findAll();
	}
	
	public Optional<StockExchange> getStockExchangeByName(String name){
		
		return repo.findByName(name);
	}
	
	
	public void addStockExchange(StockExchange stockexchange) {
		
		repo.save(stockexchange);
	}
	
	public void deleteStockExchange(String name) {
		repo.deleteByName(name);
	}
	
	public void updateStockExchange(StockExchange stockexchange,Integer id) {
		
		repo.deleteById(id);
		repo.save(stockexchange);
	}
}

