package com.bar.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bar.demo.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository <Admin,Long>{
	

}
