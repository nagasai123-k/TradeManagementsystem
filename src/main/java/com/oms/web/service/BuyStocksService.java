package com.oms.web.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import com.oms.web.beans.BuyStocks;
import com.oms.web.beans.Client;
import com.oms.web.beans.Instrument;
import com.oms.web.beans.SellStocks;
import com.oms.web.repository.BuyStocksRepository;
import com.oms.web.repository.SellStocksRepository;
import com.oms.web.repository.StoredProcedureRepository;

@Service
public class BuyStocksService {
	@Autowired
	private BuyStocksRepository buystocksRepository;
	
	@Autowired
	private StoredProcedureRepository storedprocedureRepository;
	
	@Autowired
	private SellStocksRepository sellstocksRepository;
	
	@Autowired
	private InstrumentService instrumentService;
	
	@Autowired
	private SellStocksService sellstocksService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private TransactionService transactionService;
	
	public List<BuyStocks> getAllBuyStocks() {
		List<BuyStocks> stocks = new ArrayList<BuyStocks>();
		stocks = (List<BuyStocks>) this.buystocksRepository.findAll();
		return stocks;
	}
	
	public List<BuyStocks> findBuyStocksByClientId(String clientid) {
		List<BuyStocks> buystockbyid = new ArrayList<BuyStocks>();
		this.buystocksRepository.findAll().forEach(t -> buystockbyid.add(t));
	        return buystockbyid.stream().filter(t -> t.getClient().getClientid().equals(clientid))
	                .collect(Collectors.toList());
	}
	
	public boolean insertBuyStocks(BuyStocks buy) {
		Client c = buy.getClient();
		String cid = c.getClientid();
		Client client = this.clientService.findClientById(cid);
		System.out.println(buy);
		Instrument i = buy.getInstrument();
		String id = i.getInstrumentid();
		Instrument instrument = this.instrumentService.findInstrumentById(id);
		buy.setClient(client);
		buy.setInstrument(instrument);
		buy.setQuantity(buy.getQuantity());
		buy.setPrice(buy.getPrice());
		buy.setBuy_date(LocalDateTime.now());
		this.buystocksRepository.save(buy);
		
		int idd = this.storedprocedureRepository.get_buystockid();
		System.out.println(idd);
		
		this.getMatchingBuyRecords(buy,idd);

		
		return true;
	}
	
	
	
	@Transactional
	public void getMatchingBuyRecords(BuyStocks buy, int id) {
		String instrumentid = buy.getInstrument().getInstrumentid();
		double price = buy.getPrice();
		int buyquantity = buy.getQuantity();
		List<SellStocks> sellrecords = new ArrayList<SellStocks>();
		List<SellStocks> sell = new ArrayList<SellStocks>();
		this.sellstocksRepository.findAll().forEach(i -> sellrecords.add(i));
		System.out.println("**********");
		for (SellStocks ss : sellrecords) {
			if ( (ss.getInstrument().getInstrumentid().equals(instrumentid)) &&
					(ss.getPrice() == price) && (ss.getClient().getClientid() != buy.getClient().getClientid()) ) {
				sell.add(ss);
			}
		}
		//System.out.println(sellrecords);
		sellrecords.stream().filter(i -> i.getInstrument().getInstrumentid().equals(instrumentid)) 
			.collect(Collectors.toList());
		//&& (i.getPrice()==(price))))
		
		System.out.println("price "+ price);
		
		int buy_quant = buy.getQuantity();
		for(SellStocks s : sell) {
			System.out.println("inside for");
			if(s.getQuantity() < buy_quant) {
				System.out.println("Inside 1st ifff");
				//buy.setQuantity(buyquantity-s.getQuantity());
				this.storedprocedureRepository.updatebuyersrecord(id,buy_quant-s.getQuantity());
				buy_quant = buy_quant - s.getQuantity();
				//update(buy,buy_quant);
				//this.buystocksRepository.save(buy);
				this.transactionService.addRecordInTransaction(buy,s,s.getQuantity());
				this.sellstocksRepository.deleteById(s.getSellstock_id());
				
			}
			else if (s.getQuantity() > buy_quant) {
				System.out.println("Inside 2nd ifff");
				//System.out.println(buy.getBuystock_id());
				this.storedprocedureRepository.updatesellrecord(s.getSellstock_id(),s.getQuantity()-buy_quant);
				this.transactionService.addRecordInTransaction(buy, s, buy_quant);
				//this.buystocksRepository.deleteById(id);
				this.storedprocedureRepository.deletebuystockrecord(id);
				//int sell_quant = s.getQuantity() - buy_quant;
				buy_quant = 0;
				break;
			} 
			
			else {
				System.out.println("inside 3rd iff");
				this.transactionService.addRecordInTransaction(buy, s, buy_quant);
				//this.buystocksRepository.deleteById(id);
				this.storedprocedureRepository.deletebuystockrecord(id);
				this.sellstocksRepository.deleteById(s.getSellstock_id());
				break;
			}
		}
	}

}
