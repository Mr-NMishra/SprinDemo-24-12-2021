package com.mishra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mishra.entity.InterestModel;
import com.mishra.service.InterestService;

@Controller
public class InterestServiceCltr {
	@Autowired(required = true)
	private InterestService interestService; 
	
	@RequestMapping("/InterestServiceCltr")
	public ModelAndView interestController(@ModelAttribute("InterestEntity") InterestModel interestModel) {
		interestService.CalculateTax(interestModel);
		System.out.println(interestModel.getTotalTax());
		System.out.println(interestModel.getRebate());
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("/FinalResult.jsp");
		//above model is internally added to request parameter we don't need to add explicitly
		//modelAndView.addObject("InterestEntity");
		return modelAndView;
	}
	
}
