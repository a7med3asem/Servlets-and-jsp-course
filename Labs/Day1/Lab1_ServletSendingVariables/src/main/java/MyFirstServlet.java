import jakarta.servlet.*;
import java.io.*;
public class MyFirstServlet implements Servlet{
    private ServletConfig servletConfig;

    public void init(ServletConfig config) throws ServletException
    {
        servletConfig=config;
        System.out.println(" I'm inside the init");
    }
    public void service (ServletRequest request , ServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String dbAddress = servletConfig.getInitParameter("DatabaseAddress");
        String userName = servletConfig.getInitParameter("userName");
        String password = servletConfig.getInitParameter("password");
        out.println("User Name is:" + userName);
        out.println("Password is: " + password);
        out.println("Database Address is: " + dbAddress);

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