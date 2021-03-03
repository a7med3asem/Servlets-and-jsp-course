import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;

public class LoginPage extends HttpServlet {  

public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			response.setContentType("Text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<FORM method= POST>");
			out.println("<BR> Username: <INPUT TYPE=TEXT NAME=userName>");
			out.println("<BR> Password: <INPUT TYPE=PASSWORD NAME=password>");
			out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
			out.println("</FORM>");
			
			String error = request.getParameter("error");
			if(error != null) {
				out.println("<h1> not valid username or password</h1>");
			}
			}

public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
            
    String userName = request.getParameter("userName");  
    String password = request.getParameter("password");  
          
    if(userName.equals("ahmed") && password.equals("1234")){  
	response.sendRedirect("WelcomePage?userName=" + userName);
    }  
    else{  
	response.sendRedirect("LoginPage?error=1");
    }  
    }  
}  