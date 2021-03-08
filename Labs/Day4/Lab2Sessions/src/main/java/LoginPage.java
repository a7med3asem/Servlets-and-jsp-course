import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.Enumeration;

public class LoginPage extends HttpServlet {
	// First method called
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		// get saved cookies if exists
		Cookie cookies[] = request.getCookies();
		// test if there are cookies
		if (cookies == null) {
			// Create a dumy one
			Cookie cookie = new Cookie("check", "on");
			response.addCookie(cookie);
			// Send it to be checked
			response.sendRedirect("CheckCookiesServlet");
		} else {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("userName") && cookies[i].getValue().equals("ahmedasem")) 
				response.sendRedirect("WelcomePage");
			}
		}

		out.println("<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>User Information</title>\n"
				+ "   <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">\n"
				+ "</head>\n" + "<body>");
		out.println("<center><form method=\"POST\" >\n" + "  <div class=\"mb-3\">\n"
				+ "    <label for=\"user-name\" class=\"form-label\">User Name </label>\n"
				+ "    <input type=\"text\" name=\"userName\" required class=\"form-control form-control-sm \" id=\"user-name\" >\n"
				+ "    <label for=\"exampleInputPassword1\" class=\"form-label mb-3\">Password</label>\n"
				+ "    <input type=\"password\" name=\"password\" required class=\"form-control form-control-sm \" id=\"exampleInputPassword1\">\n"
				+ "  </div>\n" + "  <button type=\"submit\" class=\"btn btn-primary mt-3\">Submit</button>\n"
				+ "</form>");

		String error = request.getParameter("error");
		if (error != null) {
			out.println("<h1 style=\"color:red;\">not valid username or password</h1>");
		}
		out.println("</center></body>");

	}

	public

	void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webcourse", "root", "ahmed");
			String sql = "select * from user where user_name = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			stmt.setString(1, userName);

			ResultSet rs = stmt.executeQuery();
			if (rs != null) {
				rs.next();
				if (userName.equals(rs.getString("user_name")) && password.equals(rs.getString("password"))) {
					// Cookies
					Cookie cookie = new Cookie("userName", userName);
					// cookie.setMaxAge(60 * 60 * 24 * 7);
					response.addCookie(cookie);
					HttpSession session =request.getSession(true);
					session.setAttribute("userName",new String(userName));
		
					response.sendRedirect("WelcomePage");
					// RequestDispatcher rd = request.getRequestDispatcher("WelcomePage");
					// rd.forward(request, response);
				} else {

					response.sendRedirect("LoginPage?error=1");
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
