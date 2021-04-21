package listeners;

import jakarta.servlet.*;
import java.sql.*;

public class LifeCycleEventHandler implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Application initialized");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webcourse", "root", "ahmed");

            // Get the ServletContext object
            ServletContext servletContext = event.getServletContext();

            // Set a ServletContext attribute
            servletContext.setAttribute("dbUrl", "jdbc:mysql///Fred");
            servletContext.setAttribute("mycon", con);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Application shut down");
    }
}
