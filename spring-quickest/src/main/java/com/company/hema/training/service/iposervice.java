package com.company.hema.training.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hema.training.entity.CompanyEntity;
import com.company.hema.training.entity.IPODetailEntity;
import com.company.hema.training.entity.StockExchange;
import com.company.hema.training.repository.iporepo;

@Service
public class iposervice {
	@Autowired
	iporepo repo;
	
	public void updateIPO(IPODetailEntity IPO,Integer id) {
			
			
			
			repo.deleteById(id);
			repo.save(IPO);
		}
	public Iterable<IPODetailEntity> getAllData() {
		return repo.findAll();
	}
	
	public Optional<IPODetailEntity> getipoByName(String name){
		
		return repo.findByName(name);
	}
	
public Optional<IPODetailEntity> getipodetailById(int Id){
		
		return repo.findById(Id);
	}
	public void addipo(IPODetailEntity ipo) {
		
		repo.save(ipo);
	}
	
	public void deleteipo(int id) {
		repo.deleteById(id);
	}
	
	
}