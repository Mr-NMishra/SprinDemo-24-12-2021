package com.mishra.cltr;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mishra.entity.Faculty;

@Controller
public class FacultyCltr {
	@Autowired
	SessionFactory factoryBean;

	@RequestMapping("FacultyFormView")
	public ModelAndView viewForm() {
		ModelAndView modelAndView = new ModelAndView("FacultyForm");

		Faculty faculty = new Faculty();
		modelAndView.addObject("faculty", faculty);

		// sending this degree list to student form
		// where it can only be accessed in view when spring form
		// attribute i.e modelAttribute know for which model we are configuring
//		//this list and we can access this list by it's name directly 
//		ArrayList<String> degree= new ArrayList<>();
//		degree.add("B.E.");
//		degree.add("B.Tech");
//		degree.add("M.Tech");
//		degree.add("P.hd");
//		
//		List<String> gender= new ArrayList<String>();
//		gender.add("Male");
//		gender.add("Female");
//		gender.add("Other");

		// modelAndView.addObject("gender", gender);

		// modelAndView.addObject("degreeList", degree);
		return modelAndView;
	}

	// Here we are using BindingResult for checking errors in Model
	// and use this class has Errors method
	// once if error occur forwarded this to form again with error
	// and using spring tag we print all error
	@RequestMapping(value = "SaveFaculty", method = RequestMethod.POST)
	// Extrating our file into Multipart file seprately from view as we store this
	// into bye formate
	// and remaining object is in object form or characheter form
	public Object saveFaculty(@ModelAttribute("faculty") @Valid Faculty faculty, BindingResult result,
			@RequestParam("image") MultipartFile multipartFile) {
		if (result.hasErrors()) {
			System.out.println("error--------------");
			return "FacultyForm";
		}
		// converting our multipart file into byte
		try {
			byte[] fileTobyte = multipartFile.getBytes();

			// now converting our byte into blob with blobProxy object
			Blob blob = BlobProxy.generateProxy(fileTobyte);
			faculty.setPicture(blob);
		} catch (IOException exception) {
			System.out.println("file casting " + exception);
		}
		Session session = factoryBean.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(faculty);
		transaction.commit();
		session.close();
		System.out.println("Student saved" + faculty + " : " + multipartFile);
		return null;
	}
	
	@RequestMapping("searchFaculty")
	public String facultySearch() {
		return "FacultySearchForm";
	}
	
	@RequestMapping("Checkfaculty")
	public Object checkFaculty(@RequestParam("rno") int rno) {
		Session session= factoryBean.openSession();
		Faculty faculty= session.get(Faculty.class, rno);
		ModelAndView view= new ModelAndView("SavedFaculty");
		view.addObject("faculty", faculty);
		return view;
	}
	@RequestMapping("image")
	public MultipartFile getImage(@RequestParam("id")int rno, HttpServletResponse response) throws SQLException, IOException {
		Session session=factoryBean.openSession();
		Faculty faculty= session.get(Faculty.class, rno);
		Blob picture=faculty.getPicture();
		byte[] pictureByte=picture.getBytes(1, (int)picture.length());
		ServletOutputStream outputStream= response.getOutputStream();
		outputStream.write(pictureByte);
		outputStream.close();
		return null;
	}
}
