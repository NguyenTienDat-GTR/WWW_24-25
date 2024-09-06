package com.fit.se;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class FileUploadDBServlet
 */
@WebServlet("/FileUploadDB")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class FileUploadDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadDBServlet() {
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		InputStream inputStream = null; // input stream of the upload file

		// get information from form include text and file
		Part filePart = request.getPart("photo");
		String fileUploadName = "";
		if (filePart != null) {
			fileUploadName = filePart.getSubmittedFileName();
			inputStream = filePart.getInputStream();
		}
		String filePath = "D:\\HOC\\www\\2024\\" + fileUploadName;
		Connection conn = null;
		String message = null;

		ServletContext context = request.getServletContext();
		String dburl = context.getInitParameter("DBUrl");
		String dbuser = context.getInitParameter("DBUser");
		String dbpassword = context.getInitParameter("DBPassword");

		// connect to database sqlserver
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
			if (conn != null) {
				System.out.println("Connected to the database");
			}

			String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);

			if (inputStream != null) {
				statement.setBlob(3, inputStream);
			}

			int row = statement.executeUpdate();
			if (row > 0) {
				message = "File uploaded and saved into database";
			}

			// read database save file
			String readFileSql = "SELECT photo FROM contacts WHERE first_name = ? And last_name = ?";
			PreparedStatement readStatement = conn.prepareStatement(readFileSql);
			readStatement.setString(1, firstName);
			readStatement.setString(2, lastName);

			ResultSet result = readStatement.executeQuery();
			if (result.next()) {
				Blob blob = result.getBlob("photo");
				inputStream = blob.getBinaryStream();
				try (OutputStream outputStream = new FileOutputStream(filePath)) {
					byte[] buffer = new byte[4096];
					int bytesRead;
					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
				}
			}
		} catch (Exception e) {
			message = "ERROR: " + e.getMessage();
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			   response.setContentType("text/plain");
		        response.getWriter().write(message);
		}
	}

}
