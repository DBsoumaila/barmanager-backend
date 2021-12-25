package com.bar.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bar.demo.model.Produit;
import com.bar.demo.repos.ProduitRepo;
import com.bar.demo.exception.UserNotFoundException;


@Service
@Transactional
public class ProduitService {
	@Autowired
	private ProduitRepo repoProduit;
	
	public List <Produit> listAll() {
		return repoProduit.findAll();
	}
	
	public Produit save(Produit produit) {
		return repoProduit.save(produit);
	}
	
	public Produit getProduit(long id) {
		return repoProduit.findById(id).orElseThrow(() -> new UserNotFoundException("Le Produit avec " + id + " N'existe pas"));
	}
	
	public void delete(long id) {
		repoProduit.deleteById(id);
	}
	 public Produit updateProduit(Produit produit) {
	        return repoProduit.save(produit);
	 }
	
	

}
