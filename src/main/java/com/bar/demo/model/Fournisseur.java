package com.bar.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="fournisseur")
public class Fournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idfacture",nullable = false, updatable = false)
	private Long idfacture;
	private String nom;
	private String email;
	private String adresse;
	private String phone;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "fournisseurs")
	private Set<Produit> produits=new HashSet<>();
	public Long getIdfacture() {
		return idfacture;
	}
	public void setIdfacture(Long idfacture) {
		this.idfacture = idfacture;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	public Fournisseur(Long idfacture, String nom, String email, String adresse, String phone, Set<Produit> produits) {
		super();
		this.idfacture = idfacture;
		this.nom = nom;
		this.email = email;
		this.adresse = adresse;
		this.phone = phone;
		this.produits = produits;
	}
	public Fournisseur() {
		super();
	}

	


}
