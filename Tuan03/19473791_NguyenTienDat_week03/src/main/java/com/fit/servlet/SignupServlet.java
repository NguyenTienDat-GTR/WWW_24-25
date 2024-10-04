package com.fit.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fit.entity.User;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		User user = new User();
		
		user.setFname(request.getParameter("fname"));
		user.setLname(request.getParameter("lname"));
		user.setDob(request.getParameter("dob"));
		user.setEmail(request.getParameter("email"));
		user.setReEmail(request.getParameter("re-enter email"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		
		request.setAttribute("user", user);
		
		if (user.getEmail().equals(user.getReEmail())) {
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("SignupError.jsp").forward(request, response);
		}
		
	}

}
