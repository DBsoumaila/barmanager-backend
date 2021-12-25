package com.bar.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bar.demo.model.Stock;
import com.bar.demo.repos.StockRepo;
import com.bar.demo.exception.UserNotFoundException;


@Service
@Transactional
public class StockService {
	@Autowired
	private StockRepo repoStock;
	
	public List <Stock> listAll() {
		return repoStock.findAll();
	}
	
	public Stock save(Stock stock) {
		return repoStock.save(stock);
	}
	
	public Stock getStock(long id) {
		return repoStock.findById(id).orElseThrow(() -> new UserNotFoundException("Le Stock avec " + id + " N'existe pas"));
	}
	
	public void delete(long id) {
		repoStock.deleteById(id);
	}
	 public Stock updateStock(Stock stock) {
	        return repoStock.save(stock);
	 }
	
	

}
