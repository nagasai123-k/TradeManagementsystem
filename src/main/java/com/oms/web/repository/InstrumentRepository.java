package com.oms.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.oms.web.beans.Instrument;

public interface InstrumentRepository extends CrudRepository<Instrument,String>{

}
