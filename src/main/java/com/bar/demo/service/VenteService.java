package com.bar.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bar.demo.model.Vente;
import com.bar.demo.repos.VenteRepo;
import com.bar.demo.exception.UserNotFoundException;


@Service
@Transactional
public class VenteService {
	@Autowired
	private VenteRepo repoVente;
	
	public List <Vente> listAll() {
		return repoVente.findAll();
	}
	
	public Vente save(Vente vente) {
		return repoVente.save(vente);
	}
	
	public Vente getVente(long id) {
		return repoVente.findById(id).orElseThrow(() -> new UserNotFoundException("La Vente avec " + id + " N'existe pas"));
	}
	
	public void delete(long id) {
		repoVente.deleteById(id);
	}
	 public Vente updateVente(Vente vente) {
	        return repoVente.save(vente);
	 }
	
	

}
