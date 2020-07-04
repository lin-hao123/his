package com.neuedu.entity;

import java.io.Serializable;

public class Register implements Serializable{
	private Integer id;
	private Integer number;
	private String date;
	private Doctor doctor;
	private Integer ispaid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Integer getIspaid() {
		return ispaid;
	}
	public void setIspaid(Integer ispaid) {
		this.ispaid = ispaid;
	}

}
