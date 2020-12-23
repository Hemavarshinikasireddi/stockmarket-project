package com.company.hema.training.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.hema.training.entity.CompanyEntity;

import com.company.hema.training.service.companyservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api/company")
public class companycontroller {

	
	@Autowired
	companyservice service;
	
	//to get all details
	@RequestMapping("/companies")
	Iterable<CompanyEntity> getAlldata(){
		return service.getAllData();
	}
//	@GetMapping(produces = "application/json")
//	@RequestMapping({ "/validateLogin" })
//	public Usermessage validateLogin() {
//		return new Usermessage("User successfully authenticated");
//	}
//	
	@RequestMapping(value="/companies/id/{id}")
	Optional<CompanyEntity> getCompanyByName(@PathVariable String name){
		
		return service.getCompanyByName(name);
	}
	@RequestMapping(value="/companies/id/{id}",method = RequestMethod.GET)
    Optional<CompanyEntity> getCompanyById(@PathVariable Long id){
	
	return service.getCompanyById(id);
}
	//@RequestMapping(value="/companies/{name}",method = RequestMethod.GET)
	//List<CompanyEntity> getCompanyByKeyName(@PathVariable String name){
		
	//	return service.getCompanyByKeyName(name);
//		return "helleo";
//	}
	
	
	//For adding a new User
	@RequestMapping(method = RequestMethod.POST, value = "/companies")
	void addCompany(@RequestBody CompanyEntity company) {
		service.addCompany(company);
	}

//	For updating a User
	@RequestMapping(method = RequestMethod.PUT, value = "/companies/{id}")
	void updateUser(@RequestBody CompanyEntity company,@PathVariable Long id) {
		service.updateCompany(company, id);
	}

	//For deleting a User
	@RequestMapping(method = RequestMethod.DELETE, value = "/companies/{id}")
	void deleteUser(@PathVariable Long id) {
		service.deleteCompany(id);
	}
	
}


