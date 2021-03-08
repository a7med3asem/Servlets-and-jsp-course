import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;

public class WelcomePage extends HttpServlet {  

/*public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			response.setContentType("Text/html");
			PrintWriter out = response.getWriter();
			String userName = request.getParameter("userName");  
			out.println("<h1> Welcome " + userName + "</h1>");
			}
*/

public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
			response.setContentType("Text/html");
			PrintWriter out = response.getWriter();
			RequestDispatcher rd = request.getRequestDispatcher("FooterServlet");
			rd.include(request, response);
			out.println("This is the footer");
		}
}  