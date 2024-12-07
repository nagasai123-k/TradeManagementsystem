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

import com.oms.web.repository.InstrumentRepository;
import com.oms.web.service.InstrumentService;

import com.oms.web.beans.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/instrument")
public class InstrumentRestController {
	@Autowired
	private InstrumentService instrumentService;
	
	@GetMapping
	public ResponseEntity<Object> getAllInstruments() {
		try { 
			List<Instrument> instruments = this.instrumentService.getAllInstruments();
			return ResponseEntity.status(HttpStatus.OK)
					.body(instruments);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}
	
	@GetMapping("/{instrumentid}")
	public ResponseEntity<Object> findInstrumentById(@PathVariable String instrumentid)
	{
		try { 
			Instrument instrument = this.instrumentService.findInstrumentById(instrumentid);
			return ResponseEntity.status(HttpStatus.OK)
					.body(instrument);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}

}
