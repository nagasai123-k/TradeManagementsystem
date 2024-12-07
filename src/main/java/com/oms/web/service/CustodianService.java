package com.oms.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.web.beans.Custodian;
import com.oms.web.repository.CustodianRepository;



@Service
public class CustodianService {
	@Autowired
	private CustodianRepository custodianRepository;
	
	public List<Custodian> getAllByID(String id) {
		List<Custodian> user = new ArrayList<Custodian>();
		this.custodianRepository.findAll().forEach(t -> user.add(t));
	        return user.stream().filter(t -> t.getCustodianid().equals(id))
	                .collect(Collectors.toList());
	   }
	
	public Custodian checkUser(Custodian c) {
		String id = c.getCustodianid();
		String pass = c.getPassword();
		try {
			List<Custodian> u = this.getAllByID(id);
			Custodian test = u.get(0);
			if (pass.equals(test.getPassword())) {
				return test;
			}
		} catch(IndexOutOfBoundsException e) {
			return null;
		}
		return null;
		
	}

}
