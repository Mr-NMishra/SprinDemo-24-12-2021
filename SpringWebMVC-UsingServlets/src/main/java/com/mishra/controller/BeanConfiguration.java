package com.mishra.controller;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mishra.service.CalculatorService;

@Configuration
public class BeanConfiguration {
	@Bean (autowire = Autowire.BY_TYPE )
	public CalculatorService calculatorService() {
		return new CalculatorService();
	}
}
