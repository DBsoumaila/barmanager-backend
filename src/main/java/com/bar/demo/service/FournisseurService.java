package com.bar.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bar.demo.model.Fournisseur;
import com.bar.demo.repos.FournisseurRepo;
import com.bar.demo.exception.UserNotFoundException;


@Service
@Transactional
public class FournisseurService {
	@Autowired
	private FournisseurRepo repoFournisseur;
	
	public List <Fournisseur> listAll() {
		return repoFournisseur.findAll();
	}
	
	public Fournisseur save(Fournisseur fournisseur) {
		return repoFournisseur.save(fournisseur);
	}
	
	public Fournisseur getFournisseur(long id) {
		return repoFournisseur.findById(id).orElseThrow(() -> new UserNotFoundException("Le Fournisseur avec " + id + " N'existe pas"));
	}
	
	public void delete(long id) {
		repoFournisseur.deleteById(id);
	}
	 public Fournisseur updateFournisseur(Fournisseur fournisseur) {
	        return repoFournisseur.save(fournisseur);
	 }
	
	

}
