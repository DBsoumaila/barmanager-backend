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

import com.bar.demo.model.Facture;
import com.bar.demo.service.FactureService;



@RestController
@RequestMapping("/facture")
public class FactureController {
	
	@Autowired
	private FactureService factureService;

	
	   @GetMapping("/all")
	    public ResponseEntity<List<Facture>> getAllFactures () {
	        List<Facture> factures = factureService.listAll();
	        return new ResponseEntity<>(factures, HttpStatus.OK);
	    }

	    @GetMapping("/facture/find/{id}")
	    public ResponseEntity<Facture> getFactureById (@PathVariable("id") Long id) {
	        Facture facture = factureService.getFacture(id);
	        return new ResponseEntity<>(facture, HttpStatus.OK);
	    }

	    @PostMapping("/facture/add")
	    public ResponseEntity<Facture> addFacture(@RequestBody Facture facture) {
	        Facture newFacture = factureService.save(facture);
	        return new ResponseEntity<>(newFacture, HttpStatus.CREATED);
	    }

	    @PutMapping("/facture/update")
	    public ResponseEntity<Facture> updateFacture(@RequestBody Facture facture) {
	        Facture updateFacture = factureService.updateFacture(facture);
	        return new ResponseEntity<>(updateFacture, HttpStatus.OK);
	    }

	    @DeleteMapping("/facture/delete/{id}")
	    public ResponseEntity<?> deleteFacture(@PathVariable("id") Long id) {
	        factureService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
	   
	

}
