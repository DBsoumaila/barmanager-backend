package com.bar.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vente")
public class Vente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idvente",nullable = false, updatable = false)
	private Long idVente;
	private int qteVendue;
	private double coutUnitaireVente;
	private Date bservation;
	//mapper avec la vente
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "vente")
    private List<Facture> factures =new ArrayList<>();
	//mapper avec les produits
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "ventes")
	private Set<Produit> produits=new HashSet<>();
	//mapping avec employer
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employer_id")
	private Employer employer;
	public Long getIdVente() {
		return idVente;
	}
	public void setIdVente(Long idVente) {
		this.idVente = idVente;
	}
	public int getQteVendue() {
		return qteVendue;
	}
	public void setQteVendue(int qteVendue) {
		this.qteVendue = qteVendue;
	}
	public double getCoutUnitaireVente() {
		return coutUnitaireVente;
	}
	public void setCoutUnitaireVente(double coutUnitaireVente) {
		this.coutUnitaireVente = coutUnitaireVente;
	}
	public Date getBservation() {
		return bservation;
	}
	public void setBservation(Date bservation) {
		this.bservation = bservation;
	}
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Vente(Long idVente, int qteVendue, double coutUnitaireVente, Date bservation, List<Facture> factures,
			Set<Produit> produits, Employer employer) {
		super();
		this.idVente = idVente;
		this.qteVendue = qteVendue;
		this.coutUnitaireVente = coutUnitaireVente;
		this.bservation = bservation;
		this.factures = factures;
		this.produits = produits;
		this.employer = employer;
	}
	public Vente() {
		super();
	}
	

}
