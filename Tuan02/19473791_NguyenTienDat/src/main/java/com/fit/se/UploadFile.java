package com.fit.se;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile") // upload multipart file using Servlet
@MultipartConfig(location = "T:\\WWW_Tuan02\\upload", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 10)
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String uploadPath = "T:\\WWW_Tuan02\\upload";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Get all the parts from request and write it to the file on server
			for (Part filePart : request.getParts()) {
				if (filePart == null || filePart.getSubmittedFileName() == null
						|| filePart.getSubmittedFileName().isEmpty()) {
					continue;
				}
				String fileName = filePart.getSubmittedFileName();

				// Get the file name
				fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
				filePart.write(fileName);
				
				//Save the file to the server
				InputStream input = filePart.getInputStream();
				Files.copy(input, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
				
				//print out the file name
				System.out.println("file uploaded: " + uploadPath + File.separator + fileName);
			}
			
			response.getWriter().append("File uploaded");
		} catch (IOException e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		}
	}

}
