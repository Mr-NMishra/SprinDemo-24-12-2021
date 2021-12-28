package com.mishra.innerPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InnerController {
	@RequestMapping("/innerController")
	public void showInner() {
		System.out.println("Inner Controller");
	}
}
