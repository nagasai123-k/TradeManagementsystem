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

import com.oms.web.beans.Client;
import com.oms.web.beans.ResponsePage;
import com.oms.web.service.ClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientRestController {
	@Autowired
	private ClientService clientService;

	@RequestMapping("/client/{id}")
	public ResponseEntity<Object> findClientById(@PathVariable String id)
	{
		try { 
			Client client = this.clientService.findClientById(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body(client);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}
}
