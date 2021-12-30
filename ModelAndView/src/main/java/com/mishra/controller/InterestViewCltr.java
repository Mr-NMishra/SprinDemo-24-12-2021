package com.mishra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterestViewCltr {
	
	@RequestMapping("/TaxCalculator")
	public String showCalculator() {
		return "TaxCalculator.jsp";
	}
}
