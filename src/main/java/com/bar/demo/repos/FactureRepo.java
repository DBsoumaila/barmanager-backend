package com.bar.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bar.demo.model.Facture;


@Repository
public interface FactureRepo extends JpaRepository <Facture,Long>{
	

}
