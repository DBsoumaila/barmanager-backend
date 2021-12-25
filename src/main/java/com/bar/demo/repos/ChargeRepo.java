package com.bar.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bar.demo.model.Charge;

@Repository
public interface ChargeRepo extends JpaRepository <Charge,Long>{
	

}
