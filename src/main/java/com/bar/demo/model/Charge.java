package com.bar.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="charge")
public class Charge implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idCharge",nullable = false, updatable = false)
	private Long idCharge;
	private Double fraisLocation;
	private Double Salaire;
	private Double electricite;
	private Double communication;
	private Double credit;
	
	//relation (1,1) (1,0) ou 1,1 entre charge et facture
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinTable(name ="charge_facture",
     joinColumns = { @JoinColumn(name ="charge_fk") },
     inverseJoinColumns = { @JoinColumn(name = "facture_fk") })
	 private Facture facture;
	
	public Charge(Double fraisLocation, Double salaire, Double electricite, Double communication, Double credit,
			Facture employer) {
		super();
		this.fraisLocation = fraisLocation;
		Salaire = salaire;
		this.electricite = electricite;
		this.communication = communication;
		this.credit = credit;
		this.facture = employer;
	}
	public Charge(Long idCharge, Double fraisLocation, Double salaire, Double electricite, Double communication,
			Double credit, Facture employer) {
		super();
		this.idCharge = idCharge;
		this.fraisLocation = fraisLocation;
		Salaire = salaire;
		this.electricite = electricite;
		this.communication = communication;
		this.credit = credit;
		this.facture = employer;
	}
	
	public Charge() {
		super();
	}
	public Long getIdCharge() {
		return idCharge;
	}
	public void setIdCharge(Long idCharge) {
		this.idCharge = idCharge;
	}
	public Double getFraisLocation() {
		return fraisLocation;
	}
	public void setFraisLocation(Double fraisLocation) {
		this.fraisLocation = fraisLocation;
	}
	public Double getSalaire() {
		return Salaire;
	}
	public void setSalaire(Double salaire) {
		Salaire = salaire;
	}
	public Double getElectricite() {
		return electricite;
	}
	public void setElectricite(Double electricite) {
		this.electricite = electricite;
	}
	public Double getCommunication() {
		return communication;
	}
	public void setCommunication(Double communication) {
		this.communication = communication;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Facture getFcature() {
		return facture;
	}
	public void setFacture(Facture employer) {
		this.facture = employer;
	}
	
	
	
	
}
