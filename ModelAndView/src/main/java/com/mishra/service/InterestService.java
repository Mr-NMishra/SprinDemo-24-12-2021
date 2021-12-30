package com.mishra.service;

import org.springframework.stereotype.Repository;

import com.mishra.entity.InterestModel;

@Repository
public class InterestService {
	private double rebate = 0;
	private double taxPercent = 0;
	private double income = 0;
	private int age;

	public void CalculateTax(InterestModel interestModel) {
		this.age = interestModel.getAge();
		this.income = interestModel.getIncome();
		checkDetails();
		
		interestModel.setRebate(this.rebate);
		interestModel.setTotalTax((taxPercent/100)*income);
		interestModel.setNetIncome(income-interestModel.getTotalTax()-interestModel.getRebate());
	}

	private void checkDetails() {
		if (income >= 250000 && income <= 500000) {
			this.taxPercent = 5;
			if (this.age >= 60) {
				this.rebate = 12500;
			}
		}
		if (income > 500000 && income <= 1000000) {
			this.taxPercent = 20;
		}
		if (income > 1000000) {
			this.taxPercent = 30;
		}

	}
}
