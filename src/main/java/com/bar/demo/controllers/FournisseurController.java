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

import com.bar.demo.model.Fournisseur;
import com.bar.demo.service.FournisseurService;



@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
	
	@Autowired
	private FournisseurService fournisseurService;

	
	   @GetMapping("/all")
	    public ResponseEntity<List<Fournisseur>> getAllFournisseurs () {
	        List<Fournisseur> Fournisseurs = fournisseurService.listAll();
	        return new ResponseEntity<>(Fournisseurs, HttpStatus.OK);
	    }

	    @GetMapping("/fournisseur/find/{id}")
	    public ResponseEntity<Fournisseur> getFournisseurById (@PathVariable("id") Long id) {
	        Fournisseur fournisseur = fournisseurService.getFournisseur(id);
	        return new ResponseEntity<>(fournisseur, HttpStatus.OK);
	    }

	    @PostMapping("/fournisseur/add")
	    public ResponseEntity<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur) {
	        Fournisseur newFournisseur = fournisseurService.save(fournisseur);
	        return new ResponseEntity<>(newFournisseur, HttpStatus.CREATED);
	    }

	    @PutMapping("/fournisseur/update")
	    public ResponseEntity<Fournisseur> updateFournisseur(@RequestBody Fournisseur fournisseur) {
	        Fournisseur updateFournisseur = fournisseurService.updateFournisseur(fournisseur);
	        return new ResponseEntity<>(updateFournisseur, HttpStatus.OK);
	    }

	    @DeleteMapping("/fournisseur/delete/{id}")
	    public ResponseEntity<?> deleteFournisseur(@PathVariable("id") Long id) {
	        fournisseurService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
	   
	

}
