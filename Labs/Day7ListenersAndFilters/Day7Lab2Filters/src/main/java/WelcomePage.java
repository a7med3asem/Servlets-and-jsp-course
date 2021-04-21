import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;

public class WelcomePage extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();

		// String userName = request.getParameter("userName");
		Cookie cookies[] = request.getCookies();

		// if (cookies != null) {
		// for (int i = 0; i < cookies.length; i++) {
		// printing name and value of cookie
		// out.print("<br>" + cookies[i].getName() + " " + cookies[i].getValue());
		// }
		// }
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("LoginPage");
		} else {
			String userName = (String) session.getAttribute("userName");
			out.println("<h5>Welcome  " + userName + "</h5>");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html");
		PrintWriter out = response.getWriter();
		// RequestDispatcher rd = request.getRequestDispatcher("FooterServlet");
		// rd.include(request, response);
		Cookie cookies[] = request.getCookies();

		// if (cookies != null) {
		// for (int i = 0; i < cookies.length; i++) {
		// printing name and value of cookie
		// out.print("<br>" + cookies[i].getName() + " " + cookies[i].getValue());
		// }
		// }

		// String userName = request.getParameter("userName");
		// out.println("<h1> Welcome " + userName + "</h1>");
		// response.sendRedirect("SearchServlet");
	}
}