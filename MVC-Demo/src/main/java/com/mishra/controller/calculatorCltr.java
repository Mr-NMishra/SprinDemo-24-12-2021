package com.mishra.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mishra.model.InterestModel;
import com.mishra.service.InterestService;

/*COnroller class for calculator*/
public class calculatorCltr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public calculatorCltr() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// reads the request
		int amount = Integer.parseInt(request.getParameter("t1"));
		int time = Integer.parseInt(request.getParameter("t2"));

		// process the request by service class.
		InterestService service = new InterestService();
		// service class process data and return in a model form
		InterestModel model = service.compute(amount, time);

		// storing model object to session
		// so view can access this model object
		HttpSession session=request.getSession();
		session.setAttribute("model", model);
		
		
		// forward request to view for presentation.
		response.sendRedirect("result.jsp");

	}

}
