package com.oms.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.web.beans.ClientInstrument;
import com.oms.web.beans.Custodian;
import com.oms.web.repository.ClientInstrumentRepository;

@Service
public class ClientInstrumentService {
	@Autowired
	private ClientInstrumentRepository clientinstrumentRepository;
	
	public List<ClientInstrument> getAllClientInstrumentByID(String id) {
		List<ClientInstrument> clientInst = new ArrayList<ClientInstrument>();
		this.clientinstrumentRepository.findAll().forEach(t -> clientInst.add(t));
	        return clientInst.stream().filter(t -> t.getClient().getClientid().equals(id))
	                .collect(Collectors.toList());
	   }

}
