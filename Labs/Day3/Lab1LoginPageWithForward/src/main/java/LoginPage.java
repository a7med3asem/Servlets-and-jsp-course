import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;

public class LoginPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>User Information</title>\n"
				+ "   <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">\n"
				+ "</head>\n" + "<body>");
		out.println("<form method=\"POST\" >\n" + "  <div class=\"mb-3\">\n"
				+ "    <label for=\"user-name\" class=\"form-label\">User Name </label>\n"
				+ "    <input type=\"text\" name=\"userName\" required class=\"form-control form-control-sm \" id=\"user-name\" >\n"
				+

				"    <label for=\"exampleInputPassword1\" class=\"form-label mb-3\">Password</label>\n"
				+ "    <input type=\"password\" name=\"password\" required class=\"form-control form-control-sm \" id=\"exampleInputPassword1\">\n"
				+

				"  </div>\n" + "  <button type=\"submit\" class=\"btn btn-primary mt-3\">Submit</button>\n"
				+ "</form></body>");

		String error = request.getParameter("error");
		if (error != null) {
			out.println("<h1> not valid username or password</h1>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (userName.equals("ahmed") && password.equals("1234")) {
			RequestDispatcher rd = request.getRequestDispatcher("WelcomePage");
			rd.forward(request, response);
			// response.sendRedirect("WelcomePage?userName=" + userName);
		} else {
			response.sendRedirect("LoginPage?error=1");
		}
	}
}