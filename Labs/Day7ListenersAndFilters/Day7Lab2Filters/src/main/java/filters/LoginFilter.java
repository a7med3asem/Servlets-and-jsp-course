package filters;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;

public class LoginFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) {
        System.out.println("Filter initialized");
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        System.out.println("doFilter");

        try {
            System.out.print("filter is invoked before");
            
            ServletContext servletContext = getServletContext();
            Connection conn = (Connection) servletContext.getAttribute("mycon");
            if (request.getParameter("userName"))
            chain.doFilter(request, response);

            System.out.print("filter is invoked after");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
        System.out.println("Filter destroyed");
        this.filterConfig = null;
    }
}
