package servlets;

import Models.UserModel;
import helpers.FileInteract;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.sql.*;

public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserModel userModel = new UserModel();

		userModel.setUserName(userName);
		userModel.setEmail(email);
		userModel.setPassword(password);

		FileInteract.createFile(userName, email, password);

		request.setAttribute("user", userModel);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowData.jsp");
		dispatcher.forward(request, response);
	}

//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("Text/html");
//		PrintWriter out = response.getWriter();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webcourse", "root", "ahmed");
//			String SQL_INSERT = "INSERT INTO user (`first_name`, `last_name`, `user_name`, `password`) VALUES (?, ?, ?, ?);";
//			PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
//			String firstName = request.getParameter("firstName");
//			String lastName = request.getParameter("lastName");
//			String userName = request.getParameter("userName");
//			String password = request.getParameter("password");
//
//			stmt.setString(1, firstName);
//			stmt.setString(2, lastName);
//			stmt.setString(3, userName);
//			stmt.setString(4, password);
//
//			int cnt = stmt.executeUpdate();
//			if (cnt > 0) {
//				response.sendRedirect("LoginPage");
//			} else {
//				response.sendRedirect("RegisterationForm?error=No rows entered");
//			}
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e);
//			response.sendRedirect("RegisterationForm?error=Invalid data");
//		}
//	}
}
