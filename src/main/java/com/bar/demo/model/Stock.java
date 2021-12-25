package com.bar.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idstock",nullable = false, updatable = false)
	private Long idstock;
	private int  totalproduits;
	private int totalEnStock;
	private Produit listProduits[];
	public Long getIdstock() {
		return idstock;
	}
	public void setIdstock(Long idstock) {
		this.idstock = idstock;
	}
	public int getTotalproduits() {
		return totalproduits;
	}
	public void setTotalproduits(int totalproduits) {
		this.totalproduits = totalproduits;
	}
	public int getTotalEnStock() {
		return totalEnStock;
	}
	public void setTotalEnStock(int totalEnStock) {
		this.totalEnStock = totalEnStock;
	}
	public Produit[] getListProduits() {
		return listProduits;
	}
	public void setListProduits(Produit[] listProduits) {
		this.listProduits = listProduits;
	}
	public Stock(Long idstock, int totalproduits, int totalEnStock, Produit[] listProduits) {
		super();
		this.idstock = idstock;
		this.totalproduits = totalproduits;
		this.totalEnStock = totalEnStock;
		this.listProduits = listProduits;
	}
	public Stock(int totalproduits, int totalEnStock, Produit[] listProduits) {
		super();
		this.totalproduits = totalproduits;
		this.totalEnStock = totalEnStock;
		this.listProduits = listProduits;
	}
	public Stock() {
		super();
	}

	
}
