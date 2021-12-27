package com.mishra;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestCOntroller {

	@RequestMapping("/show")
	public void show() {
		System.out.println("Hello Spring");
	}
}
