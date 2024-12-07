package com.oms.web.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions {
	@Id
	private int transactionid;
	@OneToOne
	@JoinColumn(name="buyer_client")
	
	private Client buyerClient;
	@OneToOne
	@JoinColumn(name="seller_client")
	private Client sellerClient;
	
	@OneToOne
	@JoinColumn(name="buyer_custodian")
	private Custodian buyerCustodian;
	
	@OneToOne
	@JoinColumn(name="seller_custodian")
	private Custodian sellerCustodian;
	
	@OneToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrument;
	
	private LocalDateTime transfer_date;
	private int quantity;
	private double price;
	private double total_amount;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(int transactionid, Client buyerClient, Client sellerClient, Custodian buyerCustodian,
			Custodian sellerCustodian, Instrument instrument, LocalDateTime transfer_date, int quantity, double price,
			double total_amount) {
		super();
		this.transactionid = transactionid;
		this.buyerClient = buyerClient;
		this.sellerClient = sellerClient;
		this.buyerCustodian = buyerCustodian;
		this.sellerCustodian = sellerCustodian;
		this.instrument = instrument;
		this.transfer_date = transfer_date;
		this.quantity = quantity;
		this.price = price;
		this.total_amount = total_amount;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public Client getBuyerClient() {
		return buyerClient;
	}

	public void setBuyerClient(Client buyerClient) {
		this.buyerClient = buyerClient;
	}

	public Client getSellerClient() {
		return sellerClient;
	}

	public void setSellerClient(Client sellerClient) {
		this.sellerClient = sellerClient;
	}

	public Custodian getBuyerCustodian() {
		return buyerCustodian;
	}

	public void setBuyerCustodian(Custodian buyerCustodian) {
		this.buyerCustodian = buyerCustodian;
	}

	public Custodian getSellerCustodian() {
		return sellerCustodian;
	}

	public void setSellerCustodian(Custodian sellerCustodian) {
		this.sellerCustodian = sellerCustodian;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public LocalDateTime getTransfer_date() {
		return transfer_date;
	}

	public void setTransfer_date(LocalDateTime transfer_date) {
		this.transfer_date = transfer_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "Transactions [transactionid=" + transactionid + ", buyerClient=" + buyerClient + ", sellerClient="
				+ sellerClient + ", buyerCustodian=" + buyerCustodian + ", sellerCustodian=" + sellerCustodian
				+ ", instrument=" + instrument + ", transfer_date=" + transfer_date + ", quantity=" + quantity
				+ ", price=" + price + ", total_amount=" + total_amount + "]";
	}
	
	
	
}
