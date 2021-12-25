package com.bar.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bar.demo.model.Charge;
import com.bar.demo.repos.ChargeRepo;
import com.bar.demo.exception.UserNotFoundException;


@Service
@Transactional
public class ChargeService {
	@Autowired
	private ChargeRepo repoCharge;
	
	public List <Charge> listAll() {
		return repoCharge.findAll();
	}
	
	public Charge save(Charge charge) {
		return repoCharge.save(charge);
	}
	
	public Charge getCharge(long id) {
		return repoCharge.findById(id).orElseThrow(() -> new UserNotFoundException("La Charge avec " + id + " N'existe pas"));
	}
	
	public void delete(long id) {
		repoCharge.deleteById(id);
	}
	 public Charge updateCharge(Charge charge) {
	        return repoCharge.save(charge);
	 }
	
	

}
