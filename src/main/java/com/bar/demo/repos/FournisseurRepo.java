package com.bar.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bar.demo.model.Fournisseur;

@Repository
public interface FournisseurRepo extends JpaRepository <Fournisseur,Long>{
	

}
