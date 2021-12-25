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

import com.bar.demo.model.Admin;
import com.bar.demo.service.AdminService;



@RestController
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private AdminService adminService;
	
	
	/*
	 * 
	 * A
	 * D
	 * M
	 * I
	 * N
	 * S
	 * 
	 */
	
	   @GetMapping("/admins")
	    public ResponseEntity<List<Admin>> getAllAdmins () {
	        List<Admin> admins = adminService.listAll();
	        return new ResponseEntity<>(admins, HttpStatus.OK);
	    }

	    @GetMapping("/find/{id}")
	    public ResponseEntity<Admin> getAdminById (@PathVariable("id") Long id) {
	        Admin admin = adminService.getAdmin(id);
	        return new ResponseEntity<>(admin, HttpStatus.OK);
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
	        Admin newAdmin = adminService.save(admin);
	        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Long id,@RequestBody Admin admin) {
	       //Creer l'admin a renvoyer
	        
	        //Find the user first
	        Admin adminExist= adminService.getAdmin(id);
	        if(adminExist.getId()==id)
	        {
	        	adminExist.setId(id);
	        	if(admin.getEmail()!=null && admin.getImageUrl()!=null && admin.getJobTitle()!=null && admin.getName()!=null &&admin.getPhone()!=null)
	        	{
	        		adminExist=admin;
	        		
	        		
	        	}
	        	if(admin.getEmail()!=null)
	        	{
	        		adminExist.setEmail(admin.getEmail());
	        	}
	        	if(admin.getImageUrl()!=null)
	        	{
	        		adminExist.setImageUrl(admin.getImageUrl());
	        	}
	        	if(admin.getJobTitle()!=null)
	        	{
	        		adminExist.setJobTitle(admin.getJobTitle());
	        	}
	        	if(admin.getName()!=null)
	        	{
	        		adminExist.setName(admin.getName());
	        	}
	        	if(admin.getPhone()!=null)
	        	{
	        		adminExist.setPhone(admin.getPhone());
	        	}
	        	
	        	adminExist=adminService.save(adminExist);
	        }else
	        {
	        	
	        }
	        
	        return new ResponseEntity<>(adminExist, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteAdmin(@PathVariable("id") Long id) {
	        adminService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
	    /*
		 * 
		 * A
		 * D
		 * M
		 * I
		 * N
		 * S
		 * 
		 */
	

}
