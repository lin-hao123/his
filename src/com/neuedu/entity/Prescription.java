package com.neuedu.entity;

import java.io.Serializable;

public class Prescription implements Serializable{
	private Integer id;
	private Register register;
	private Medicine medicine;
	private Integer count;
	private String isdistributed;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getIsdistributed() {
		return isdistributed;
	}
	public void setIsdistributed(String isdistributed) {
		this.isdistributed = isdistributed;
	}

}
