package com.mishra.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mishra.service.CalculatorService;

@Controller
public class ViewController {
	@Autowired(required = true)
	private CalculatorService calculatorService;
	
	
	@RequestMapping("/Calculate-Interset")
	//mapping this handler to "Calculator-Interset" url
	public String getInterestCalculator() {
		return "DataEntry.jsp";
	}
	
	@RequestMapping("/CalculatorService")
	
	//public void calculateInterest(HttpServletRequest request) {
	public void calculateInterest(@RequestParam("amount") double amount, @RequestParam("time") double time) {	
	try {
			//double amount=Double.parseDouble(request.getParameter("amount"));
			//double time=Double.parseDouble(request.getParameter("time"));
			System.out.println("amount "+amount+", time "+time);
			//CalculatorService calculatorService= new CalculatorService();
			double interest=calculatorService.GetInterest(amount,time);
			System.out.println("Interest---"+interest);
			System.out.println("Principal--"+calculatorService.getPrincpal());
		} catch (Exception e) {
			System.out.println("-------------------------"+e);		}
		
	}
}
