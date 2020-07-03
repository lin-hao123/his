package com.neuedu.entity;

import java.io.Serializable;

public class Medicine implements Serializable{
	
	private Integer id;
	private String 	mname;
	private Integer	mfee;
	private	Integer mnum;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Integer getMfee() {
		return mfee;
	}
	public void setMfee(Integer mfee) {
		this.mfee = mfee;
	}
	public Integer getMnum() {
		return mnum;
	}
	public void setMnum(Integer mnum) {
		this.mnum = mnum;
	}
}
