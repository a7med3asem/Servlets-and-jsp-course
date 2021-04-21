package controllers.filters;

import java.io.*;
import jakarta.servlet.*;
import java.sql.*;

public class LoginFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) {
        System.out.println("Filter initialized");
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        System.out.println("doFilter");

        try {
            System.out.println("Login filter is invoked before");
            
            ServletContext servletContext = filterConfig.getServletContext();
            Connection conn = (Connection) servletContext.getAttribute("myConnection");

            Cookie cookie = new Cookie("check", "on");
			response.addCookie(cookie);

            

            if (request.getParameter("userName") != "ahmed")
                chain.doFilter(request, response);

            System.out.println("Login filter is invoked after");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
        System.out.println("Filter destroyed");
        this.filterConfig = null;
    }
}
