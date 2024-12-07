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

import com.oms.web.beans.BuyStocks;
import com.oms.web.beans.ResponsePage;
import com.oms.web.beans.SellStocks;
import com.oms.web.service.BuyStocksService;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/buystocks")
public class BuyStocksRestController {
	@Autowired
	private BuyStocksService buystocksService;
	
	@GetMapping
	public ResponseEntity<Object> getAllBuyStocks() {
		try { 
			List<BuyStocks> buystocks = this.buystocksService.getAllBuyStocks();
			return ResponseEntity.status(HttpStatus.OK)
					.body(buystocks);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}
	
	@GetMapping("/{clientid}")
	public ResponseEntity<Object> findBuyStocksByClientId(@PathVariable String clientid)
	{
		try { 
			List<BuyStocks> buystockbyid = this.buystocksService.findBuyStocksByClientId(clientid);
			return ResponseEntity.status(HttpStatus.OK)
					.body(buystockbyid);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> insertBuyStocks(@RequestBody BuyStocks buy) {
		
		if (this.buystocksService.insertBuyStocks(buy)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("Success");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("Failed","Not Successful"));
		}
	}

}
