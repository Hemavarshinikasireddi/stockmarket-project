package com.company.hema.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hema.training.entity.CompanyEntity;
import com.company.hema.training.repository.companyrepo;

@Service
public class companyservice {
	
	@Autowired
	companyrepo repo;
	
	public Iterable<CompanyEntity> getAllData() {
		return repo.findAll();
	}
	
	public Optional<CompanyEntity> getCompanyByName(String name){
		
		return repo.findByName(name);
	}
	
	public Optional<CompanyEntity> getCompanyById(Long Id){
		
		return repo.findById(Id);
	}
	public List<CompanyEntity> getCompanyByKeyName(String name){
		
		return repo.findBynameContaining(name);
	}
	
	
	public void addCompany(CompanyEntity company) {
		
		repo.save(company);
	}
	
	public void deleteCompany(Long id) {
		repo.deleteById(id);
	}
	
	public void updateCompany(CompanyEntity company,Long id) {
		
		repo.deleteById(id);
		repo.save(company);
	}
	
}
