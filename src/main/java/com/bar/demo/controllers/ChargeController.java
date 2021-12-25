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

import com.bar.demo.model.Charge;
import com.bar.demo.service.ChargeService;



@RestController
@RequestMapping("/charge")
public class ChargeController {
	
	@Autowired
	private ChargeService chargeService;

	
	   @GetMapping("/all")
	    public ResponseEntity<List<Charge>> getAllCharges () {
	        List<Charge> Charges = chargeService.listAll();
	        return new ResponseEntity<>(Charges, HttpStatus.OK);
	    }

	    @GetMapping("/charge/find/{id}")
	    public ResponseEntity<Charge> getChargeById (@PathVariable("id") Long id) {
	        Charge charge = chargeService.getCharge(id);
	        return new ResponseEntity<>(charge, HttpStatus.OK);
	    }

	    @PostMapping("/charge/add")
	    public ResponseEntity<Charge> addCharge(@RequestBody Charge charge) {
	        Charge newCharge = chargeService.save(charge);
	        return new ResponseEntity<>(newCharge, HttpStatus.CREATED);
	    }

	    @PutMapping("/charge/update")
	    public ResponseEntity<Charge> updateCharge(@RequestBody Charge charge) {
	        Charge updateCharge = chargeService.updateCharge(charge);
	        return new ResponseEntity<>(updateCharge, HttpStatus.OK);
	    }

	    @DeleteMapping("/charge/delete/{id}")
	    public ResponseEntity<?> deleteCharge(@PathVariable("id") Long id) {
	        chargeService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
	   
	

}
