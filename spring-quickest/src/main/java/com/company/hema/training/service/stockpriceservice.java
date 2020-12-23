package com.company.hema.training.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hema.training.entity.CompanyEntity;
import com.company.hema.training.entity.StockPrice;
import com.company.hema.training.repository.companyrepo;
import com.company.hema.training.repository.stockpricerepo;

@Service
public class stockpriceservice {
	@Autowired
	stockpricerepo repo;
	
	public Iterable<StockPrice> getAllData() {
		return repo.findAll();
	}
	
	public List<StockPrice> getstockpriceByName(String name){
		
		return repo.findByName(name);
	}
	
	public Optional<StockPrice> getstockpriceById(Long Id){
		
		return repo.findById(Id);
	}
	
	
	
	public void addstockprice(StockPrice stockprice) {
		
		repo.save(stockprice);
	}
	
	public void deletestockprice(String name) {
		repo.deleteByName(name);
	}
	
	
}
