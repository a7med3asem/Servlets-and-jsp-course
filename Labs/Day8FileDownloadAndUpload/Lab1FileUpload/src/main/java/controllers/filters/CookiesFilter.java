package controllers.filters;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class CookiesFilter implements Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) {
        System.out.println("Cookies filter initialized");
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        System.out.println("doFilter cookies");

        // get saved cookies if exists
        // Cookie cookies[] = request.getCookies();

        // test if there are cookies
        // if (cookies == null) {
        //     response.setContentType("Text/html");
        //     PrintWriter out = response.getWriter();
        //     out.println("Turn on cookies to continue");
        // } else {
        //     chain.doFilter(request, response);
        // }
    }

    public void destroy() {
        System.out.println("Filter destroyed");
        this.filterConfig = null;
    }

}
