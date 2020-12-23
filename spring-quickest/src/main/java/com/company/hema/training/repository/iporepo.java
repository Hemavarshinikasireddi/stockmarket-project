package com.company.hema.training.repository;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.company.hema.training.entity.IPODetailEntity;

@CrossOrigin(origins="http://localhost:4200")
@Repository
public interface iporepo extends CrudRepository<IPODetailEntity,Integer>{
	@Query(value="select * from ipodetail where companyname= :name ",nativeQuery=true)
	Optional<IPODetailEntity> findByName(@Param("name")String name);
	@Modifying
	@Transactional
	@Query(value="delete from ipodetail where companyname= :name ",nativeQuery=true)
	void deleteByName(@Param("name")String name);
	
}

