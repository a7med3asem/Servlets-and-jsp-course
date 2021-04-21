import com.utils.User;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("userName");
        if (name != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                ServletContext servletContext = getServletContext();

                // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webcourse", "root", "ahmed");
                Connection con = (Connection) servletContext.getAttribute("mycon");
                String sql = "SELECT * FROM user WHERE first_name LIKE ? OR last_name LIKE ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, "%" + name + "%");
                stmt.setString(2, "%" + name + "%");

                List<User> users = new ArrayList<>();
                ResultSet rs = stmt.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        User user = new User();

                        user.setFirstName(rs.getString(1));
                        user.setLastName(rs.getString(2));
                        user.setUserName(rs.getString(3));
                        user.setPassword(rs.getString(4));

                        users.add(user);
                    }

                    request.setAttribute("users", users);
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("ShowData.jsp");
                dispatcher.forward(request, response);

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}