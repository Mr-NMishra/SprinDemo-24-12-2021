package com.mishra.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
public class Faculty {
	@Id
	@Max(value = 500, message = "must be less than 500")
	private int rno;
	private String name;
	@Size(max = 10, min = 0, message = "number must be 10 digits")
	private String mobile;
	@Email(message = "Type proper email")
	private String email;
	private String address;
	private Blob picture;

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getEmail() {
		return email;
	}

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

	@Override
	public String toString() {
		return "Faculty [rno=" + rno + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", address="
				+ address + ", picture=" + picture + "]";
	}

}
