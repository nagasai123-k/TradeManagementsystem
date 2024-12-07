package com.oms.web.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oms.web.beans.ResponsePage;
import com.oms.web.beans.Transactions;
import com.oms.web.service.TransactionService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/transaction")
public class TransactionRestController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/client/{clientid}")
	public ResponseEntity<Object> getTransactionsByClientId(@PathVariable String clientid)
	{
		try { 
			System.out.println("before call");
			List<Transactions> transaction = this.transactionService.getTransactionsByClientId(clientid);
			System.out.println("after call");
			return ResponseEntity.status(HttpStatus.OK)
					.body(transaction);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}
	
	@GetMapping("/{clientid}")
	public ResponseEntity<Object> getTransactionsByCustodianId(@PathVariable String clientid)
	{
		try { 
			List<Transactions> transaction = this.transactionService.getTransactionsByClientId(clientid);
			return ResponseEntity.status(HttpStatus.OK)
					.body(transaction);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}    
}