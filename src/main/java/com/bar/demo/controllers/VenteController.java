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

import com.bar.demo.model.Vente;
import com.bar.demo.service.VenteService;



@RestController
@RequestMapping("/vente")
public class VenteController {
	
	@Autowired
	private VenteService venteService;

	
	   @GetMapping("/all")
	    public ResponseEntity<List<Vente>> getAllVentes () {
	        List<Vente> Ventes = venteService.listAll();
	        return new ResponseEntity<>(Ventes, HttpStatus.OK);
	    }

	    @GetMapping("/vente/find/{id}")
	    public ResponseEntity<Vente> getVenteById (@PathVariable("id") Long id) {
	        Vente vente = venteService.getVente(id);
	        return new ResponseEntity<>(vente, HttpStatus.OK);
	    }

	    @PostMapping("/vente/add")
	    public ResponseEntity<Vente> addVente(@RequestBody Vente vente) {
	        Vente newVente = venteService.save(vente);
	        return new ResponseEntity<>(newVente, HttpStatus.CREATED);
	    }

	    @PutMapping("/vente/update")
	    public ResponseEntity<Vente> updateVente(@RequestBody Vente vente) {
	        Vente updateVente = venteService.updateVente(vente);
	        return new ResponseEntity<>(updateVente, HttpStatus.OK);
	    }

	    @DeleteMapping("/vente/delete/{id}")
	    public ResponseEntity<?> deleteVente(@PathVariable("id") Long id) {
	        venteService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
	   
	

}
