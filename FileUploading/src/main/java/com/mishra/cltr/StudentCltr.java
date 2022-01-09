package com.mishra.cltr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mishra.entity.Student;
import com.mishra.services.StudentService;

@Controller
public class StudentCltr {
	@Autowired
	private StudentService studentService;
	
	//deleting Student
	@RequestMapping("/delete")
	public Object deleteStudent(@RequestParam("id") String rno) {
		Boolean flag=studentService.deleteStudent(rno);
		ModelAndView modelAndView=new ModelAndView("redirect:StudentList");
		return modelAndView;
	}

	//Adding Student
	@RequestMapping("/Studentform")
	public Object addStudent(@ModelAttribute("student") Student student) {
		if(student.getRno()!=null) {
			studentService.addStudent(student);
		}
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("StudentDetails");
		return modelAndView;
	}
	
	
	//Searching Student
	@RequestMapping("/CheckStudent")
	public Object CheckStudent(@RequestParam("rno") String rno) {
		Student student= studentService.findStudent(rno);
		if(student!=null) {
			return new ModelAndView("StudentDetails").addObject("student", student);
			
		}else {
			return "StudentFound";
		}
		 
	}
	
	@RequestMapping("/StudentList")
	public Object studentList(){
		List<Object> students=studentService.studentList();
		System.out.println(students);
		if(students.isEmpty()) {
			System.out.println("No Student Found");
			return "StudentFound";	
		}else {
			return new ModelAndView("SavedStudents").addObject("students", students);
		}
		
	}
	
	@RequestMapping("/update")
	public Object updateStudent(@RequestParam("id") String rno) {
		Student student=studentService.findStudent(rno);
		
		ModelAndView modelAndView= new ModelAndView("UpdateStudentForm").addObject("updateStudent", student);
		return modelAndView;
	}
	
	@RequestMapping("UpdatingStudent")
	public Object updatedList(@ModelAttribute("Student") Student student) {
		studentService.updateStudent(student);
		return new ModelAndView("redirect:StudentList");
	}
}
