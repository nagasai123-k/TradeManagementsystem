package com.oms.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.web.repository.ClientRepository;

import com.oms.web.beans.Client;
import com.oms.web.beans.Custodian;
import com.oms.web.beans.Instrument;
@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	private List<Client> findAllById(String id) {
		List<Client> users = new ArrayList<Client>();
		this.clientRepository.findAll().forEach(t -> users.add(t));
	        return users.stream().filter(t -> t.getClientid().equals(id))
	                .collect(Collectors.toList());
	}
	
	public List<Client> getAllClientsByCustodianId(String id) {
		return this.findAllById(id);
	}
	
	public  Client findClientById(String id)
	{
		try {
			Optional<Client> client = this.clientRepository.findById(id);

			return client.orElseThrow(()->{

				return new EntityNotFoundException("Client with "+id + " does not exist");
			});

		}catch(IllegalArgumentException e )
		{
			return null;
		}

	}

}
