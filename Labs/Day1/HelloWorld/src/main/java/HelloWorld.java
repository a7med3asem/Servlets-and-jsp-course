import jakarta.servlet.*;
import java.io.*;

public class HelloWorld implements Servlet{
    private ServletConfig servletConfig;

    public void init(ServletConfig config) throws ServletException
    {
        servletConfig = config;
        System.out.println(" I'm inside the init");
    }

    public void service (ServletRequest request , ServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<br>Welcome to servlets and JSP course</br>");
        System.out.println("I'm inside service");
    }
    public void destroy()
    {
        System.out.println("Inside destroy");
    }
    public String getServletInfo()
    {
        return null;
    }
    public ServletConfig getServletConfig()
    {
        return null;
    }

}