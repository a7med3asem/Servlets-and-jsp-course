import com.mysql.cj.jdbc.MysqlDataSource;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class SQLToolServlet extends HttpServlet {
    private static final String search = "Select * from user where firstname like ?";
    Connection conn;

    String start = "<html lang='en'> <head> <title> SQL tool Form </title>" + "    <style>tr th{font-weight:bold;}"
            + "     tr th, tr td{padding:5px;}" + "     th{border: 5px solid #C1DAD7;}"
            + "     td{border: 5px solid #C1DAD7;}" + "     .c1{background:#4b8c74;}" + "     .c2{background:#74c476;}"
            + "     .c3{background:#a4e56d;}" + "     .c4{background:#cffc83;}</style>" + "</head><body>";
    String end = "</div>" + "</body>" + "</html>";
    String myvar = "<div>" + "    <h1 style='font-size: 70px'> SQL Tool </h1>"
            + "    <h3 > please enter the Query </h3>" + "    <form style='margin-left: 1%'>"
            + "    <textarea style='display: block' rows='8' cols='100' name='SQLQuery' required></textarea>"
            + "    <div style='margin-left: 1%'>" + "    <br>" + "    <input type='submit' value='Execute query'>"
            + "    </div>" + "    </form>" + "    </div>";

    public void init() throws ServletException {
        try {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();

            mysqlDataSource.setUser("root");
            mysqlDataSource.setPassword("ahmed");
            mysqlDataSource.setDatabaseName("webcourse");

            conn = mysqlDataSource.getConnection();

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String query = request.getParameter("SQLQuery");
        System.out.println(query);

        PrintWriter out = response.getWriter();
        out.println(start);
        out.println(myvar);

        if (query != null) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                if (preparedStatement.execute()) {
                    ResultSet resultSet = preparedStatement.getResultSet();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    out.println("<table width=\"100%\" style=\"background-color:gray;"
                            + "border-spacing: 2px;border-color: gray; border: 1px solid black;\"> <tbody>");
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        if (i > 1)
                            System.out.print(",  ");
                        out.println("<th>" + metaData.getColumnName(i) + "</th>");
                    }
                    while (resultSet.next()) {
                        out.println("<tr align='center'>");
                        for (int i = 1; i <= metaData.getColumnCount(); i++) {

                            String columnValue = resultSet.getString(i);
                            out.println("<td>" + columnValue + "</td>");
                        }

                        out.println("</tr>");
                    }
                    out.println("</tbody></table>");
                } else {
                    int numberEffected = preparedStatement.getUpdateCount();
                    System.out.println(numberEffected);
                    out.println("<h2 align='center'> affected row =" + numberEffected + "<h2>");
                }
            } catch (SQLException e) {
                out.println("<h2 align='center'>" + e.getMessage() + "<h2>");
            }
        }
        out.println(end);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void executeQuery(String query) {

    }

    public void destroy() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
