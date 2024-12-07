package com.oms.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.oms.web.beans.Client;
import com.oms.web.beans.Custodian;


public interface ClientRepository extends CrudRepository<Client,String>{

}
