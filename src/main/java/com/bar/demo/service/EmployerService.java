package com.bar.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bar.demo.model.Employer;
import com.bar.demo.repos.EmployeeRepo;
import com.bar.demo.exception.UserNotFoundException;


@Service
@Transactional
public class EmployerService {
	@Autowired
	private EmployeeRepo repoEmployer;
	
	public List <Employer> listAll() {
		return repoEmployer.findAll();
	}
	
	public Employer save(Employer employer) {
		return repoEmployer.save(employer);
	}
	
	public Employer getEmployer(long id) {
		return repoEmployer.findById(id).orElseThrow(() -> new UserNotFoundException("L' Employer avec " + id + " N'existe pas"));
	}
	
	public void delete(long id) {
		repoEmployer.deleteById(id);
	}
	 public Employer updateEmployer(Employer employer) {
	        return repoEmployer.save(employer);
	 }
	
	

}
