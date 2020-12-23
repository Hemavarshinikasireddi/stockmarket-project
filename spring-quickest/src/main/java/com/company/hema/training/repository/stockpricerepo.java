package com.company.hema.training.repository;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.company.hema.training.entity.CompanyEntity;
import com.company.hema.training.entity.StockPrice;


@CrossOrigin(origins="http://localhost:4200")
@Repository
public interface stockpricerepo extends JpaRepository<StockPrice,Long>{
	

	@Query(value="select * from stockprice where companycode= :name ",nativeQuery=true)
	List<StockPrice> findByName(@Param("name")String name);
//	
	@Modifying
	@Transactional
	@Query(value="delete  from stockprice where companycode= :name ",nativeQuery=true)
	void deleteByName(@Param("name")String name);
}
