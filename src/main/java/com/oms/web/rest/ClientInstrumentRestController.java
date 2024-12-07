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
import com.oms.web.beans.ClientInstrument;
import com.oms.web.beans.ResponsePage;
import com.oms.web.service.ClientInstrumentService;

@RestController
@CrossOrigin()
@RequestMapping("/clientinstrument")
public class ClientInstrumentRestController {
	@Autowired
	private ClientInstrumentService clientinstrumentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getAllClientInstrumentByID(@PathVariable String id)
	{
		try { 
			List<ClientInstrument> clientinstr = this.clientinstrumentService.getAllClientInstrumentByID(id);
			return ResponseEntity.status(HttpStatus.OK)
					.body(clientinstr);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}

}
