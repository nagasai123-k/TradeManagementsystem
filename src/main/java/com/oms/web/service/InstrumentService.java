package com.oms.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.web.repository.InstrumentRepository;

import com.oms.web.beans.Instrument;

@Service
public class InstrumentService {
	@Autowired
	private InstrumentRepository instrumentRepository;
	
	public List<Instrument> getAllInstruments() {
		List<Instrument> instruments = new ArrayList<Instrument>();
		this.instrumentRepository.findAll().forEach(inst -> instruments.add(inst));
		return instruments;
	}
	
	public  Instrument findInstrumentById(String id)
	{
		try {
			Optional<Instrument> instrument = this.instrumentRepository.findById(id);

			return instrument.orElseThrow(()->{

				return new EntityNotFoundException("Instrument with "+id + " does not exist");
			});

		}catch(IllegalArgumentException e )
		{
			return null;
		}

	}

}
