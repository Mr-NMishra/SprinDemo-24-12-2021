package com.mishra.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Faculty {
	@Id
	private String rno;
	private String name;
	private String mobile;
	private String address;
	private String degree;
	private String gender;

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRno() {
		return rno;
	}

	public void setRno(String rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
