package com.bar.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar.demo.model.Produit;
import com.bar.demo.service.ProduitService;



@RestController
@RequestMapping("/")
public class ProduitController {
	
	@Autowired
	private ProduitService produitService;

	
	   @GetMapping("/all")
	    public ResponseEntity<List<Produit>> getAllProduits () {
	        List<Produit> Produits = produitService.listAll();
	        return new ResponseEntity<>(Produits, HttpStatus.OK);
	    }

	    @GetMapping("/produit/find/{id}")
	    public ResponseEntity<Produit> getProduitById (@PathVariable("id") Long id) {
	        Produit produit = produitService.getProduit(id);
	        return new ResponseEntity<>(produit, HttpStatus.OK);
	    }

	    @PostMapping("/produit/add")
	    public ResponseEntity<Produit> addProduit(@RequestBody Produit produit) {
	        Produit newProduit = produitService.save(produit);
	        return new ResponseEntity<>(newProduit, HttpStatus.CREATED);
	    }

	    @PutMapping("/produit/update")
	    public ResponseEntity<Produit> updateProduit(@RequestBody Produit produit) {
	        Produit updateProduit = produitService.updateProduit(produit);
	        return new ResponseEntity<>(updateProduit, HttpStatus.OK);
	    }

	    @DeleteMapping("/produit/delete/{id}")
	    public ResponseEntity<?> deleteProduit(@PathVariable("id") Long id) {
	        produitService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
	   
	

}
