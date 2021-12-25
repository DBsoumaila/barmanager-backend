package com.bar.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar.demo.model.Stock;
import com.bar.demo.service.StockService;



@RestController
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;

	
	   @GetMapping("/all")
	    public ResponseEntity<List<Stock>> getAllStocks () {
	        List<Stock> stocks = stockService.listAll();
	        return new ResponseEntity<>(stocks, HttpStatus.OK);
	    }

	    @GetMapping("/stock/find/{id}")
	    public ResponseEntity<Stock> getStockById (@PathVariable("id") Long id) {
	        Stock stock = stockService.getStock(id);
	        return new ResponseEntity<>(stock, HttpStatus.OK);
	    }

	    @PostMapping("/stock/add")
	    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
	        Stock newStock = stockService.save(stock);
	        return new ResponseEntity<>(newStock, HttpStatus.CREATED);
	    }

	    @PutMapping("/stock/update")
	    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
	        Stock updateStock = stockService.updateStock(stock);
	        return new ResponseEntity<>(updateStock, HttpStatus.OK);
	    }

	    @DeleteMapping("/stock/delete/{id}")
	    public ResponseEntity<?> deleteStock(@PathVariable("id") Long id) {
	        stockService.delete(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
	   
	

}
