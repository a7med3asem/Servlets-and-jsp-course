import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.util.Enumeration;
import java.sql.*;
import javax.naming.spi.DirStateFactory.Result;

public class SearchServlet extends HttpServlet {
    ResultSet rs;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("Text/html");
        PrintWriter out = response.getWriter();
        out.println("<center><form method=\"POST\">\n" + "<h1>Search Form</h1>"
                + "    <h3>Please enter the first name, last name or part of any.</h3>"
                + "    <label for=\"user-name\" >Name : </label>\n"
                + "    <input type=\"text\" name=\"userName\"  id=\"user-name\">\n"
                + "    <button type=\"submit\">Search</button>\n" + "</form></center>");

        String name = request.getParameter("name");
        // out.println("_" + name + "_");
        if (name != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webcourse", "root", "ahmed");
                String sql = "SELECT * FROM user WHERE first_name LIKE ? OR last_name LIKE ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, "%" + name + "%");
                stmt.setString(2, "%" + name + "%");

                ResultSet rs = stmt.executeQuery();
                out.println("<div><table style=\"width: 99%; border-spacing: 15px;\">" + "<thead><tr>"
                        + "<th>First name</th>" + "<th>Last name</th>" + "<th>username</th>" + "<th>pasword</th>"
                        + "</tr></thead>" + "<tbody id=\"tbodyAdminLocation\" style=\"font-size: medium;\">");
                while (rs != null) {
                    rs.next();
                    out.println("<tr>" + "<th>" + rs.getString("first_name") + "</th>" + "<th>"
                            + rs.getString("last_name") + "</th>" + "<th>" + rs.getString("user_name") + "</th>"
                            + "<th>" + rs.getString("password") + "</th>" + "</tr>");
                }
                out.println("</tbody></table></div>");
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("Text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("userName");
        response.sendRedirect("SearchServlet?name=" + name);
    }
}