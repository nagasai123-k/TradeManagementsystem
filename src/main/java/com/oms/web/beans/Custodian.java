package com.oms.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="custodian")
public class Custodian {
	@Id
	private String custodianid;
	private String custodianname;
	private String password;
	public Custodian() {
		// TODO Auto-generated constructor stub
	}
	public Custodian(String custodianid, String custodianname, String password) {
		super();
		this.custodianid = custodianid;
		this.custodianname = custodianname;
		this.password = password;
	}
	public String getCustodianid() {
		return custodianid;
	}
	public void setCustodianid(String custodianid) {
		this.custodianid = custodianid;
	}
	public String getCustodianname() {
		return custodianname;
	}
	public void setCustodianname(String custodianname) {
		this.custodianname = custodianname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "custodian [custodianid=" + custodianid + ", custodianname=" + custodianname + ", password=" + password
				+ "]";
	}
	
	
}
