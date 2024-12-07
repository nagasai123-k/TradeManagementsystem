package com.oms.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.oms.web.beans.ClientInstrument;
import com.oms.web.beans.Instrument;

public interface ClientInstrumentRepository extends CrudRepository<ClientInstrument,Integer>{

}
