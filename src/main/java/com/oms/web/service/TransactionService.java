package com.oms.web.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.web.beans.BuyStocks;
import com.oms.web.beans.SellStocks;
import com.oms.web.beans.Transactions;
import com.oms.web.repository.StoredProcedureRepository;
import com.oms.web.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private EmailSenderService mailservice;
	
	@Autowired
	private StoredProcedureRepository storedprocedureRepository;
	
	
	
	public List<Transactions> getTransactionsByClientId(String clientid) {
		List<Transactions> transac = new ArrayList<Transactions>();
		List<Transactions> transactions = new ArrayList<Transactions>();
		this.transactionRepository.findAll().forEach(t -> transac.add(t));
		for (Transactions t : transac) {
			if ( (t.getBuyerClient().getClientid().equals(clientid)) ||
					(t.getSellerClient().getClientid().equals(clientid)) ) {
				transactions.add(t);
			}
		}
	        return transactions;
	}


	public void addRecordInTransaction(BuyStocks buy, SellStocks s, int quantity) {
		
		Transactions transaction = new Transactions();
		int tid = this.storedprocedureRepository.getuniqueTransactionId()+1;
		transaction.setTransactionid(tid);
		
		
		String sub = "Congratulations!! You made it :)";
		String sellerbody = "Dear "+ s.getClient().getClientname() + 
				",\n\nHurray!! Your instruments " + s.getInstrument().getInstrumentname()+
				" with quantity : " +s.getQuantity()+" are sold succesfully with each instrument price at " + s.getPrice() + " INR to buyer "
			 + buy.getClient().getClientname() + ".\n\nYour total transaction value is : " + quantity*buy.getPrice() +
				" INR\nPlease note your Transaction Id : " +tid + " for future reference."  
				 + "\n\nA copy is sent to your custodian - " + s.getClient().getCustodian().getCustodianname() 
			 + "\n\nRegards,\nTEAM TRADE BUDDY";
		
		String buyerbody = "Dear "+ buy.getClient().getClientname() + 
				",\n\nHurray!! Your instruments " + s.getInstrument().getInstrumentname()
				+" with quantity : " +buy.getQuantity()+" are purchased succesfully with each instrument price at " + buy.getPrice() + " INR from seller "
			 + s.getClient().getClientname() +".\n\nYour total transaction value is : " + quantity*buy.getPrice() +
						" INR\nPlease note your Transaction Id : " +tid + " for future reference." +
			  "\n\nA copy is sent to your custodian - " + buy.getClient().getCustodian().getCustodianname() 
			 + "\n\nRegards,\nTEAM TRADE BUDDY";
		
		System.out.println("inside transaction");
		mailservice.sendExampleEmail("patibandlasaipranithedu@gmail.com",buyerbody,sub);
		mailservice.sendExampleEmail("patibandlasaipranith@gmail.com",sellerbody,sub);
		
		
		transaction.setBuyerClient(buy.getClient());
		
		transaction.setBuyerCustodian(buy.getClient().getCustodian());
		
		transaction.setSellerClient(s.getClient());
		
		transaction.setSellerCustodian(s.getClient().getCustodian());
		
		transaction.setInstrument(s.getInstrument());
		
		transaction.setTransfer_date(LocalDateTime.now());
		
		transaction.setQuantity(quantity);
		
		transaction.setPrice(s.getPrice());
		
		transaction.setTotal_amount(quantity*s.getPrice());
		
		this.transactionRepository.save(transaction);
		
		this.storedprocedureRepository.insertBuyClient(buy.getClient().getClientid(),
				buy.getInstrument().getInstrumentid(), quantity);
	this.storedprocedureRepository.insertSellClient(s.getClient().getClientid(),
				s.getInstrument().getInstrumentid(), quantity);

	}

}
