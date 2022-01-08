package com.mishra.cltr;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mishra.entity.Faculty;

@Controller
public class FacultyCltr {
	@Autowired
	SessionFactory factoryBean;

	@RequestMapping("FacultyFormView")
	public ModelAndView viewForm() {
		ModelAndView modelAndView= new ModelAndView("FacultyForm");
		
		Faculty faculty= new Faculty();
		modelAndView.addObject("faculty", faculty);
		
		//sending this degree list to student form
		//where it can only be accessed in view when spring form
		//attribute i.e modelAttribute know for which model we are configuring
		//this list and we can access this list by it's name directly 
		ArrayList<String> degree= new ArrayList<>();
		degree.add("B.E.");
		degree.add("B.Tech");
		degree.add("M.Tech");
		degree.add("P.hd");
		
		List<String> gender= new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		gender.add("Other");
		
		modelAndView.addObject("gender", gender);
		
		modelAndView.addObject("degreeList", degree);
		return modelAndView;
	}
	
	
	//Here we are using BindingResult for checking errors in Model 
	//and use this class has Errors method
	//once if error occur forwarded this to form again with error
	//and using spring tag we print all error
	@RequestMapping("SaveFaculty")
	public Object saveFaculty(@ModelAttribute("facultySaving") Faculty faculty ,BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Error Found");
			return "FacultyForm";
		}
		Session session= factoryBean.openSession();
		Transaction transaction= session.beginTransaction();
		session.save(faculty);
		transaction.commit();
		session.close();
		System.out.println("Student saved");
		return null;
	}
}
