package com.oms.web.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.web.beans.BuyStocks;
import com.oms.web.beans.Client;
import com.oms.web.beans.Instrument;
import com.oms.web.beans.SellStocks;
import com.oms.web.repository.BuyStocksRepository;
import com.oms.web.repository.SellStocksRepository;
import com.oms.web.repository.StoredProcedureRepository;


@Service
public class SellStocksService {
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private InstrumentService instrumentService;
	
	
	@Autowired
	private BuyStocksRepository buystocksRepository;
	
	@Autowired
	private SellStocksRepository sellstocksRepository;
	
	@Autowired
	private StoredProcedureRepository storedprocedureRepository;

	@Autowired
	private TransactionService transactionService;
	
	public boolean insertSellStocks(SellStocks sell) {
		Client c = sell.getClient();
		String cid = c.getClientid();
		Client client = this.clientService.findClientById(cid);
		//System.out.println(sell);
		Instrument i = sell.getInstrument();
		String id = i.getInstrumentid();
		Instrument instrument = this.instrumentService.findInstrumentById(id);
		
		sell.setClient(client);
		sell.setInstrument(instrument);
		sell.setQuantity(sell.getQuantity());
		sell.setPrice(sell.getPrice());
		sell.setSell_date(LocalDateTime.now());
		this.sellstocksRepository.save(sell);
		
		int idd = this.storedprocedureRepository.get_sellstockid();
		System.out.println(idd);
		
		this.getMatchingSellRecords(sell,idd);
		return true;
	}

	private void getMatchingSellRecords(SellStocks sell, int id) {
		String instrumentid = sell.getInstrument().getInstrumentid();
		double price = sell.getPrice();
		int sellquantity = sell.getQuantity();
		List<BuyStocks> buyrecords = new ArrayList<BuyStocks>();
		List<BuyStocks> buy = new ArrayList<BuyStocks>();
		this.buystocksRepository.findAll().forEach(i -> buyrecords.add(i));
		System.out.println("*****");
		for (BuyStocks bs : buyrecords) {
			if ( (bs.getInstrument().getInstrumentid().equals(instrumentid)) &&
					(bs.getPrice() == price) && (bs.getClient().getClientid() != sell.getClient().getClientid()) ) {
				buy.add(bs);
			}
		}
		System.out.println("BUY " + buy);
		
		System.out.println("price : " + price);
		
		int sell_quant = sell.getQuantity();
		for(BuyStocks b : buy) {
			//System.out.println(b);
			System.out.println("inside for");
			if(b.getQuantity() < sell_quant) {
				System.out.println("Inside 1st ifff");
				//buy.setQuantity(buyquantity-s.getQuantity());
				this.storedprocedureRepository.updatesellrecord(id,sell_quant-b.getQuantity());
				sell_quant = sell_quant - b.getQuantity();
				//update(buy,buy_quant);
				//this.sellstocksRepository.save(sell);
				this.transactionService.addRecordInTransaction(b,sell,b.getQuantity());
				System.out.println(b.getBuystock_id());
				//this.buystocksRepository.deleteById(b.getBuystock_id());
				this.storedprocedureRepository.deletebuystockrecord(b.getBuystock_id());
			}
			else if (b.getQuantity() > sell_quant) {
				System.out.println("Inside 2nd ifff");
				//System.out.println(buy.getBuystock_id());
				this.storedprocedureRepository.updatebuyersrecord(b.getBuystock_id(),b.getQuantity()-sell_quant);
				this.transactionService.addRecordInTransaction(b, sell, sell_quant);
				this.sellstocksRepository.deleteById(id);
				//int buy_quant = b.getQuantity() - sell_quant;
				sell_quant = 0;
				break;
			} 
			
			else {
				System.out.println("inside 3rd iff");
				this.transactionService.addRecordInTransaction(b, sell, sell_quant);
				this.sellstocksRepository.deleteById(id);
				this.storedprocedureRepository.deletebuystockrecord(b.getBuystock_id());
				//this.buystocksRepository.deleteById(b.getBuystock_id());
				
				break;
			}
		}
		
	}

	public List<SellStocks> getAllSellStocks() {
		List<SellStocks> stocks = new ArrayList<SellStocks>();
		stocks = (List<SellStocks>) this.sellstocksRepository.findAll();
		return stocks;
	}
	
	public List<SellStocks> findSellStocksByClientId(String id) {
		List<SellStocks> sellstockbyid = new ArrayList<SellStocks>();
		this.sellstocksRepository.findAll().forEach(t -> sellstockbyid.add(t));
	        return sellstockbyid.stream().filter(t -> t.getClient().getClientid().equals(id))
	                .collect(Collectors.toList());
	   }
	
}
