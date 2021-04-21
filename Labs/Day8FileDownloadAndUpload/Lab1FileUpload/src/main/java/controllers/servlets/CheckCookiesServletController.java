package controllers.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.Enumeration;

public class CheckCookiesServletController extends HttpServlet {
    // First method called
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get saved cookies if exists
        Cookie cookies[] = request.getCookies();
        // test if there are cookies
        if (cookies == null) {
            response.setContentType("Text/html");
            PrintWriter out = response.getWriter();
            out.println("Turn on cookies to continue");
        } else {
            response.sendRedirect("LoginPage");
        }
    }
}
