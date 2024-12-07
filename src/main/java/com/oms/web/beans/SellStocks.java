package com.oms.web.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sellstocks")
public class SellStocks {
	@Id
	private int sellstock_id;
	@OneToOne
	@JoinColumn(name="clientid")
	private Client client;
	@OneToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrument;
	private int quantity;
	private double price;
	private LocalDateTime sell_date;
	
	public SellStocks() {
		// TODO Auto-generated constructor stub
	}

	public SellStocks(int sellstock_id, Client client, Instrument instrument, int quantity, double price,
			LocalDateTime sell_date) {
		super();
		this.sellstock_id = sellstock_id;
		this.client = client;
		this.instrument = instrument;
		this.quantity = quantity;
		this.price = price;
		this.sell_date = sell_date;
	}

	public int getSellstock_id() {
		return sellstock_id;
	}

	public void setSellstock_id(int sellstock_id) {
		this.sellstock_id = sellstock_id;
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

	public LocalDateTime getSell_date() {
		return sell_date;
	}

	public void setSell_date(LocalDateTime sell_date) {
		this.sell_date = sell_date;
	}

	@Override
	public String toString() {
		return "SellStocks [sellstock_id=" + sellstock_id + ", client=" + client + ", instrument=" + instrument
				+ ", quantity=" + quantity + ", price=" + price + ", sell_date=" + sell_date + "]";
	}

	
}
