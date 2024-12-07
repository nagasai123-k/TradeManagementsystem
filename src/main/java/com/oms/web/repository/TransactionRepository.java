package com.oms.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.oms.web.beans.Transactions;

public interface TransactionRepository extends CrudRepository<Transactions,Integer>{

}
