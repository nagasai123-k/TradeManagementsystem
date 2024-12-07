package com.oms.web.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instrument")
public class Instrument {
	@Id
	private String instrumentid;
	private String instrumentname;
	private int facevalue;
	private LocalDateTime expirydate;
	private int quantity;
	
	public Instrument() {
		// TODO Auto-generated constructor stub
	}

	public Instrument(String instrumentid, String instrumentname, int facevalue, LocalDateTime expirydate,
			int quantity) {
		super();
		this.instrumentid = instrumentid;
		this.instrumentname = instrumentname;
		this.facevalue = facevalue;
		this.expirydate = expirydate;
		this.quantity = quantity;
	}

	public String getInstrumentid() {
		return instrumentid;
	}

	public void setInstrumentid(String instrumentid) {
		this.instrumentid = instrumentid;
	}

	public String getInstrumentname() {
		return instrumentname;
	}

	public void setInstrumentname(String instrumentname) {
		this.instrumentname = instrumentname;
	}

	public int getFacevalue() {
		return facevalue;
	}

	public void setFacevalue(int facevalue) {
		this.facevalue = facevalue;
	}

	public LocalDateTime getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDateTime expirydate) {
		this.expirydate = expirydate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Instrument [instrumentid=" + instrumentid + ", instrumentname=" + instrumentname + ", facevalue="
				+ facevalue + ", expirydate=" + expirydate + ", quantity=" + quantity + "]";
	}
	
}
