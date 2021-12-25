package com.bar.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bar.demo.model.Vente;


@Repository
public interface VenteRepo extends JpaRepository <Vente,Long>{
	

}
