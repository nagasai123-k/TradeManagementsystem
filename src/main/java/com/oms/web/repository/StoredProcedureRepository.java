package com.oms.web.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.oms.web.beans.BuyStocks;
@Repository
public interface StoredProcedureRepository extends JpaRepository<BuyStocks,Integer>{
	@Transactional
	@Procedure(procedureName="getbuystockid")
	int get_buystockid();
	
	@Transactional
	@Procedure(procedureName="insertBuyClient")
	void insertBuyClient(String cid, String instid, int quant);
	
	@Transactional
	@Procedure(procedureName="insertSellClient")
	void insertSellClient(String cid, String instid, int quant);
	
	@Transactional
	@Procedure(procedureName="getsellstockid")
	int get_sellstockid();
	
	@Transactional
	@Procedure(procedureName="getuniqueTransactionId")
	int getuniqueTransactionId();
	
	@Transactional
	@Procedure(procedureName="updatebuyersrecord")
	void updatebuyersrecord(int buyid,int buyquantity);
	
	@Transactional
	@Procedure(procedureName="updatesellrecord")
	void updatesellrecord(int sellid,int sellquantity);
	
	@Transactional
	@Procedure(procedureName="deletebuystockrecord")
	void deletebuystockrecord(int buyid);
}
