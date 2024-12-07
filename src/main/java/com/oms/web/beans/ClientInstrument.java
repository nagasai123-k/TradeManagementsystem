package com.oms.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientinstrument")
public class ClientInstrument {
	@Id
	private int id;
	@OneToOne
	@JoinColumn(name="clientid")
	private Client client;
	@OneToOne
	@JoinColumn(name="instrumentid")
	private Instrument instrument;
	private int quantity;
	public ClientInstrument() {
		// TODO Auto-generated constructor stub
	}
	public ClientInstrument(Client client, Instrument instrument, int quantity) {
		super();
		this.client = client;
		this.instrument = instrument;
		this.quantity = quantity;
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
	@Override
	public String toString() {
		return "ClientInstrument [client=" + client + ", instrument=" + instrument + ", quantity=" + quantity + "]";
	}
	
	

}
