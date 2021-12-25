package com.bar.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idfacture",nullable = false, updatable = false)
	private Long idfacture;
	private Double montanTotaltAchat;
	private Double montantTotalVente;
	private Double montantAverserCaise;
	private String beneficeMensuel;	
	//les clées etrangères relation one to many
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vente_id")
	private Vente vente;
	public Long getIdfacture() {
		return idfacture;
	}
	public void setIdfacture(Long idfacture) {
		this.idfacture = idfacture;
	}
	public Double getMontanTotaltAchat() {
		return montanTotaltAchat;
	}
	public void setMontanTotaltAchat(Double montanTotaltAchat) {
		this.montanTotaltAchat = montanTotaltAchat;
	}
	public Double getMontantTotalVente() {
		return montantTotalVente;
	}
	public void setMontantTotalVente(Double montantTotalVente) {
		this.montantTotalVente = montantTotalVente;
	}
	public Double getMontantAverserCaise() {
		return montantAverserCaise;
	}
	public void setMontantAverserCaise(Double montantAverserCaise) {
		this.montantAverserCaise = montantAverserCaise;
	}
	public String getBeneficeMensuel() {
		return beneficeMensuel;
	}
	public void setBeneficeMensuel(String beneficeMensuel) {
		this.beneficeMensuel = beneficeMensuel;
	}
	public Vente getVente() {
		return vente;
	}
	public void setVente(Vente vente) {
		this.vente = vente;
	}
	public Facture(Long idfacture, Double montanTotaltAchat, Double montantTotalVente, Double montantAverserCaise,
			String beneficeMensuel, Vente vente) {
		super();
		this.idfacture = idfacture;
		this.montanTotaltAchat = montanTotaltAchat;
		this.montantTotalVente = montantTotalVente;
		this.montantAverserCaise = montantAverserCaise;
		this.beneficeMensuel = beneficeMensuel;
		this.vente = vente;
	}
	public Facture() {
		super();
	}
	
}