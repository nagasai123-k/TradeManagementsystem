package com.oms.web.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
	private String clientid;
	private String clientname;
	private double transactionlimit;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="custodianid")
	private Custodian custodian;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String clientid, String clientname, double transactionlimit, Custodian custodian) {
		super();
		this.clientid = clientid;
		this.clientname = clientname;
		this.transactionlimit = transactionlimit;
		this.custodian = custodian;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public double getTransactionlimit() {
		return transactionlimit;
	}

	public void setTransactionlimit(double transactionlimit) {
		this.transactionlimit = transactionlimit;
	}

	public Custodian getCustodian() {
		return custodian;
	}

	public void setCustodian(Custodian custodian) {
		this.custodian = custodian;
	}

	@Override
	public String toString() {
		return "Client [clientid=" + clientid + ", clientname=" + clientname + ", transactionlimit=" + transactionlimit
				+ ", custodian=" + custodian + "]";
	}
	
	

}
