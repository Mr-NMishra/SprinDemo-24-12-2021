package com.mishra.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


@Entity
public class Faculty {
	@Id
	@Max(value = 500 , message = "must be less than 500")
	private int rno;
	private String name;
	
	private String mobile;
	@Email(message = "Type proper email")
	private String email;
	private String address;
	
	public String getEmail() {
		return email;
	}

	@Email(message = "type proper email", regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	public void setEmail(String email) {
		this.email = email;
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
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


}
