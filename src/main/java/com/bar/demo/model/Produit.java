package com.bar.demo.model;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idproduit",nullable = false, updatable = false)
	private Long idProduit;
	private String nomDeLaBoisson;
	private Double quantiteEntree;
	private Double coutUnitaire;
	private Date dateEntree;
	private Integer qteRestante;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name ="produit_vente",joinColumns = { @JoinColumn(name ="produit_fk") },
            inverseJoinColumns = { @JoinColumn(name = "vente_fk") })
	
	private Set<Vente> ventes=new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name ="produit_fournisseur",joinColumns = { @JoinColumn(name ="produit_fk") },
            inverseJoinColumns = { @JoinColumn(name = "fournisseur_fk") })
	private Set<Fournisseur> fournisseurs=new HashSet<>();

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomDeLaBoisson() {
		return nomDeLaBoisson;
	}

	public void setNomDeLaBoisson(String nomDeLaBoisson) {
		this.nomDeLaBoisson = nomDeLaBoisson;
	}

	public Double getQuantiteEntree() {
		return quantiteEntree;
	}

	public void setQuantiteEntree(Double quantiteEntree) {
		this.quantiteEntree = quantiteEntree;
	}

	public Double getCoutUnitaire() {
		return coutUnitaire;
	}

	public void setCoutUnitaire(Double coutUnitaire) {
		this.coutUnitaire = coutUnitaire;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Integer getQteRestante() {
		return qteRestante;
	}

	public void setQteRestante(Integer qteRestante) {
		this.qteRestante = qteRestante;
	}

	public Set<Vente> getVentes() {
		return ventes;
	}

	public void setVentes(Set<Vente> ventes) {
		this.ventes = ventes;
	}

	public Set<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public Produit(Long idProduit, String nomDeLaBoisson, Double quantiteEntree, Double coutUnitaire, Date dateEntree,
			Integer qteRestante, Set<Vente> ventes, Set<Fournisseur> fournisseurs) {
		super();
		this.idProduit = idProduit;
		this.nomDeLaBoisson = nomDeLaBoisson;
		this.quantiteEntree = quantiteEntree;
		this.coutUnitaire = coutUnitaire;
		this.dateEntree = dateEntree;
		this.qteRestante = qteRestante;
		this.ventes = ventes;
		this.fournisseurs = fournisseurs;
	}

	public Produit() {
		super();
	}
	

}