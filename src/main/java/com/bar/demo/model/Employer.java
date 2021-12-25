package com.bar.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employer")
public class Employer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable = false, updatable = false)
	private Long id;
	private String name;
	private String email;
	private String jobTitle;
	private String phone;
	private String imageUrl;
	private String typeEmployer;
	private String role;
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "employer")
    private List<Vente> ventes =new ArrayList<>();
	
	
	
	//Contructeurs
	
	public Employer() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public String getTypeEmployer() {
		return typeEmployer;
	}



	public void setTypeEmployer(String typeEmployer) {
		this.typeEmployer = typeEmployer;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public List<Vente> getVentes() {
		return ventes;
	}



	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}



	public Employer(Long id, String name, String email, String jobTitle, String phone, String imageUrl,
			String typeEmployer, String role, List<Vente> ventes) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.typeEmployer = typeEmployer;
		this.role = role;
		this.ventes = ventes;
	}



	
	
	
}
