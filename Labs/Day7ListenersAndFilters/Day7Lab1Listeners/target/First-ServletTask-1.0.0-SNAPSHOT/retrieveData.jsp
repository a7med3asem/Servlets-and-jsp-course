<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.utils.User" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<html>
<head>
    <title>Get Data</title>
</head>
<body>
<jsp:useBean id="users" class="com.utils.Util" scope="request"/>

<%
    String name = request.getParameter("userName");
    if (name != null) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webcourse", "root", "ahmed");
            String sql = "SELECT * FROM user WHERE first_name LIKE ? OR last_name LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + name + "%");

            ResultSet rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    User user = new User();

                    user.setFirstName(rs.getString(1));
                    user.setLastName(rs.getString(2));
                    user.setUserName(rs.getString(3));
                    user.setPassword(rs.getString(4));

                    users.getUsers().add(user);
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    RequestDispatcher rd = request.getRequestDispatcher("ShowData.jsp");
    rd.forward(request, response);
%>
</body>
</html>
