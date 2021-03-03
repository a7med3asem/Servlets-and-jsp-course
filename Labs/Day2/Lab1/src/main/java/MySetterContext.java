import jakarta.servlet.*;
import java.io.*;
public class MySetterContext implements Servlet{
    private ServletConfig sConfig;

    public void init(ServletConfig config) throws ServletException
    {
        sConfig=config;
    }
    public void service (ServletRequest request , ServletResponse response) throws ServletException, IOException
    {
        ServletContext ServletContext = sConfig.getServletContext();
		ServletContext.setAttribute("username", "ahmed");
		ServletContext.setAttribute("password", "123");
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