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

import com.bar.demo.model.Employer;
import com.bar.demo.service.EmployerService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployerService employeeService;

	
	   @GetMapping("/all")
	    public ResponseEntity<List<Employer>> getAllEmployees () {
	        List<Employer> employees = employeeService.listAll();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }

	    @GetMapping("/employee/find/{id}")
	    public ResponseEntity<Employer> getEmployeeById (@PathVariable("id") Long id) {
	        Employer employee = employeeService.getEmployer(id);
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    }

	    @PostMapping("/employee/add")
	    public ResponseEntity<Employer> addEmployee(@RequestBody Employer employee) {
	        Employer newEmployee = employeeService.save(employee);
	        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	    }

	    @PutMapping("/employee/update")
	    public ResponseEntity<Employer> updateEmployee(@RequestBody Employer employee) {
	        Employer updateEmployee = employeeService.updateEmployer(employee);
	        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	    }

	    @DeleteMapping("/employee/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        employeeService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
	   
	

}
