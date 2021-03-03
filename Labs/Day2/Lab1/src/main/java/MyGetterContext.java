import jakarta.servlet.*;
import java.io.*;
public class MyGetterContext implements Servlet{
    private ServletConfig sConfig;

    public void init(ServletConfig config) throws ServletException
    {
        sConfig=config;
    }
    public void service (ServletRequest request , ServletResponse response) throws ServletException, IOException
    {
        ServletContext servletContext = sConfig.getServletContext();
		PrintWriter out = response.getWriter();
		String str = (String) servletContext.getAttribute("username");
		String str2 = (String) servletContext.getAttribute("password");
		out.println("My username is " + str);
		out.println("My password is " + str2);
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