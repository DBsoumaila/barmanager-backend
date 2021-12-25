package com.bar.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bar.demo.model.Stock;

@Repository
public interface StockRepo extends JpaRepository <Stock,Long>{
	

}
