package com.mishra.cltr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mishra.entity.Faculty;

@Controller
public class FacultyCltr {

	@RequestMapping("FacultyFormView")
	public ModelAndView viewForm() {
		ModelAndView modelAndView= new ModelAndView("FacultyForm");
		
		Faculty faculty= new Faculty();
		modelAndView.addObject("faculty", faculty);
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
}
