package com.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		response.setContentType("text/html;charset=UTF-8");
		// lay thong tin tu form
		String ten = request.getParameter("name");
		String tenDN = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String facebook = request.getParameter("fb");
		String bio = request.getParameter("sbio");
		
		// in ra thong tin
		PrintWriter out = response.getWriter();
		out.println("<html>");	
		out.println("<head>");		
		out.println("<title>Register</title>");
		out.println("</head>");		
		out.println("<body>");
		out.println("<h1>Thong tin dang ky</h1>");		
		out.println("<p>Ho ten: " + ten + "</p>");
		out.println("<p>Ten dang nhap: " + tenDN + "</p>");
		out.println("<p>Email: " + email + "</p>");	
		out.println("<p>Facebook: " + facebook + "</p>");
		out.println("<p>Bio: " + bio + "</p>");		
	}

}
