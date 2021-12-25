package com.bar.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bar.demo.model.Facture;
import com.bar.demo.repos.FactureRepo;
import com.bar.demo.exception.UserNotFoundException;


@Service
@Transactional
public class FactureService {
	@Autowired
	private FactureRepo repoFacture;
	
	public List <Facture> listAll() {
		return repoFacture.findAll();
	}
	
	public Facture save(Facture facture) {
		return repoFacture.save(facture);
	}
	
	public Facture getFacture(long id) {
		return repoFacture.findById(id).orElseThrow(() -> new UserNotFoundException("La Facture avec " + id + " N'existe pas"));
	}
	
	public void delete(long id) {
		repoFacture.deleteById(id);
	}
	 public Facture updateFacture(Facture facture) {
	        return repoFacture.save(facture);
	 }
	
	

}
