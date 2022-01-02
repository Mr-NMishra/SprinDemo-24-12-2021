package com.mishra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mishra.entity.Student;
import com.mishra.service.StudentDAO;

@Controller
public class StudentController {
	@Autowired(required = true)
	private StudentDAO studentDAO;
	
	@RequestMapping("/Studentform")
	public Object StudentCltr(@ModelAttribute("student")Student student) {
		boolean flag=studentDAO.saveStudent(student);
		if(flag) {
			return new ModelAndView("StudentDetails");
		}else {
			
		}
		return "StudentFound";
		
		
	}
}
