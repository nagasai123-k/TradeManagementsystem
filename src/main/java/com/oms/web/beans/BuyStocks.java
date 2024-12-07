package com.oms.web.beans;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="buystocks")
public class BuyStocks {
	@Id
	private int buystock_id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="clientid")
	private Client client;
	@OneToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrument;
	private int quantity;
	private double price;
	private LocalDateTime buy_date;
	
	public BuyStocks() {
		// TODO Auto-generated constructor stub
	}

	public BuyStocks(int buystock_id, Client client, Instrument instrument, int quantity, double price,
			LocalDateTime buy_date) {
		super();
		this.buystock_id = buystock_id;
		this.client = client;
		this.instrument = instrument;
		this.quantity = quantity;
		this.price = price;
		this.buy_date = buy_date;
	}

	public int getBuystock_id() {
		return buystock_id;
	}

	public void setBuystock_id(int buystock_id) {
		this.buystock_id = buystock_id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
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

	public LocalDateTime getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(LocalDateTime buy_date) {
		this.buy_date = buy_date;
	}

	@Override
	public String toString() {
		return "BuyStocks [buystock_id=" + buystock_id + ", client=" + client + ", instrument=" + instrument
				+ ", quantity=" + quantity + ", price=" + price + ", buy_date=" + buy_date + "]";
	}

	
	
	

}
