package com.mishra.service;


public class CalculatorService {
	private double princpal;
	private double rate;
	private double time;

	public double getPrincpal() {
		return princpal;
	}

	public void setPrincpal(double princpal) {
		this.princpal = princpal;
	}
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double GetInterest(double amount,double time) {
		return (amount*5*time)/100;
	}
}
