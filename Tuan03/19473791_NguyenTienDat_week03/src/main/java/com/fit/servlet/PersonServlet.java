package com.fit.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fit.entity.Person;

/**
 * Servlet implementation class PersonServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Person person = new Person();
		 
		 person.setFname(request.getParameter("fname"));
		 person.setLname(request.getParameter("lname"));
		 person.setBirthDate(request.getParameter("birthdate"));
		 person.setEmail(request.getParameter("email"));
		 person.setPhone(request.getParameter("mobile"));
		 person.setGender(request.getParameter("gender"));
		 person.setAddress(request.getParameter("address"));
		 person.setCity(request.getParameter("city"));
		 person.setPinCode(request.getParameter("pincode"));
		 person.setState(request.getParameter("state"));
		 person.setCountry(request.getParameter("country"));
		 person.setHobbies(request.getParameterValues("hobbies"));
		 person.setCourse(request.getParameter("course"));
		 
		 request.setAttribute("person", person);
		 
		 request.getRequestDispatcher("Form_Ex01.jsp").forward(request, response);
	}

}
