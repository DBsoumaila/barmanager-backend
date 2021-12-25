package com.bar.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bar.demo.model.Admin;
import com.bar.demo.repos.AdminRepo;
import com.bar.demo.exception.UserNotFoundException;


@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminRepo repoAdmin;
	
	public List <Admin> listAll() {
		return repoAdmin.findAll();
	}
	
	public Admin save(Admin admin) {
		return repoAdmin.save(admin);
	}
	
	public Admin getAdmin(long id) {
		return repoAdmin.findById(id).orElseThrow(() -> new UserNotFoundException("L'Utilisateur avec " + id + " N'existe pas"));
	}
	
	public void delete(long id) {
		repoAdmin.deleteById(id);
	}
	 public Admin updateAdmin(Admin admin) {
	        return repoAdmin.save(admin);
	 }
	
	

}
