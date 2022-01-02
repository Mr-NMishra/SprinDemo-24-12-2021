package com.mishra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mishra.entity.Student;
import com.mishra.service.StudentService;

@Controller
public class StudentController {
	@Autowired(required = true)
	private StudentService studentService;
	
	@RequestMapping("/Studentform")
	public Object StudentForm(@ModelAttribute("student") Student student) {
		boolean flag=studentService.addStudent(student);
		
		if(!flag) {
			return "StudentFound";
			
		}else
			return new ModelAndView("StudentDetails");
		
	}
}
