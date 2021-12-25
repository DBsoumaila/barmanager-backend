package com.bar.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bar.demo.model.Produit;



@Repository
public interface ProduitRepo extends JpaRepository <Produit,Long>{
	

}
