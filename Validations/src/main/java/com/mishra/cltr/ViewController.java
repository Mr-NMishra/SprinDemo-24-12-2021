package com.mishra.cltr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/ViewForm")
	public String showForm() {
		return "StudentForm";
	}
	@RequestMapping("SearchStudent")
	public String SearchStudent() {
		return "SearchForm";
	}
	
}