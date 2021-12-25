package com.bar.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bar.demo.model.Employer;


@Repository
public interface EmployeeRepo extends JpaRepository <Employer,Long>{
	

}
