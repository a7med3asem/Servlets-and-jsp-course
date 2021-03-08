import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;

public class FooterServlet extends HttpServlet {  			
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
			response.setContentType("Text/html");
			PrintWriter out = response.getWriter();
			String userName = request.getParameter("userName");  
			out.println("<h1> Welcome " + userName + "</h1>");
		}
}  