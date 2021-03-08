import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.util.Enumeration;
import java.sql.*;

public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>User Information</title>\n"
				+ "   <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">\n"
				+ "</head>\n" + "<body>");
		out.println("<center><form method=\"POST\" >\n" + "  <div class=\"mb-3\">\n"
				+ "    <label for=\"user-name\" class=\"form-label\">First name</label>\n"
				+ "    <input type=\"text\" name=\"firstName\" required class=\"form-control form-control-sm \" id=\"first-name\" >\n"
				+ "    <label for=\"user-name\" class=\"form-label\">Last name</label>\n"
				+ "    <input type=\"text\" name=\"lastName\" required class=\"form-control form-control-sm \" id=\"last-name\" >\n"
				+ "    <label for=\"user-name\" class=\"form-label\">User Name </label>\n"
				+ "    <input type=\"text\" name=\"userName\" required class=\"form-control form-control-sm \" id=\"user-name\" >\n"
				+ "    <label for=\"exampleInputPassword1\" class=\"form-label mb-3\">Password</label>\n"
				+ "    <input type=\"password\" name=\"password\" required class=\"form-control form-control-sm \" id=\"exampleInputPassword1\">\n"
				+ "  </div>\n" + "  <button type=\"submit\" class=\"btn btn-primary mt-3\">Submit</button>\n"
				+ "</form>");

		// out.println("<!DOCTYPE html>\n" + "<Html><head><title>Registration
		// Page</title></head>"
		// + "<center><body bgcolor=\"Lightskyblue\"><br><br><formmethod=\"POST\" >\n
		// <div class=\"mb-3\">"
		// + "<label> Firstname </label>" + "<input type=\"text\" name=\"firstname\"
		// size=\"15\"/><br><br>"
		// + "<label> Middlename: </label>" + "<input type=\"text\" name=\"middlename\"
		// size=\"15\"/><br><br>"
		// + "<label> Lastname: </label> " + "<input type=\"text\" name=\"lastname\"
		// size=\"15\"/> <br> <br> "
		// + "Password: <input type=\"Password\" id=\"pass\" name=\"password\"><br><br>"
		// + "Re-type password: <button type=\"submit\" class=\"btn btn-primary
		// mt-3\">Submit</button><br><br>"
		// + "<input type=\"reset\" value=\"Reset\"/>" +
		// "</form></body><center></html>");

		String error = request.getParameter("error");
		if (error != null) {
			out.println("<h1 style=\"color:red;\">" + error + "</h1>");
		}
		out.println("</center></body>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webcourse", "root", "ahmed");
			String SQL_INSERT = "INSERT INTO user (`first_name`, `last_name`, `user_name`, `password`) VALUES (?, ?, ?, ?);";
			PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, userName);
			stmt.setString(4, password);

			int cnt = stmt.executeUpdate();
			if (cnt > 0) {
				response.sendRedirect("LoginPage");
			} else {
				response.sendRedirect("RegisterationForm?error=No rows entered");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("RegisterationForm?error=Invalid data");
		}
	}
}
