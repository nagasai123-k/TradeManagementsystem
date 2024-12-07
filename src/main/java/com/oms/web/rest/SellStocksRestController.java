package com.oms.web.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.web.beans.SellStocks;
import com.oms.web.service.SellStocksService;

import com.oms.web.beans.Instrument;
import com.oms.web.beans.ResponsePage;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/sellstocks")
public class SellStocksRestController {
	@Autowired
	private SellStocksService sellstocksService;
	
	@GetMapping
	public ResponseEntity<Object> getAllSellStocks() {
		try { 
			List<SellStocks> sellstocks = this.sellstocksService.getAllSellStocks();
			return ResponseEntity.status(HttpStatus.OK)
					.body(sellstocks);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}
	
	@GetMapping("/{clientid}")
	public ResponseEntity<Object> findSellStocksByClientId(@PathVariable String clientid)
	{
		try { 
			List<SellStocks> sellstockbyid = this.sellstocksService.findSellStocksByClientId(clientid);
			return ResponseEntity.status(HttpStatus.OK)
					.body(sellstockbyid);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> insertSellStocks(@RequestBody SellStocks sell) {
		
		if (this.sellstocksService.insertSellStocks(sell)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("Success");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("Failed","Not Successful"));
		}
	}


}
