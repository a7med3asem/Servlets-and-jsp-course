<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.utils.User" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 

<html>
<head>
    <title>Get Data</title>
    <style>
        tr th {
          font-weight: bold;
        }
        tr th,
        tr td {
          padding: 5px;
        }
        th {
          border: 5px solid #c1dad7;
        }
        td {
          border: 5px solid #c1dad7;
        }
        .c1 {
          background: #4b8c74;
        }
        .c2 {
          background: #74c476;
        }
        .c3 {
          background: #a4e56d;
        }
        .c4 {
          background: #cffc83;
        }
      </style>
  
</head>
<body>
    <form action="retrieveData.jsp" method="GET">
        <h1>Search Form</h1>
        <h3>Please enter the first name, last name or part of any.</h3>
        <label for="user-name">Name : </label>
        <input type="text" name="userName" id="user-name" />
        <button type="submit">Search</button>
      </form>
      
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/webcourse"
         user = "root"  password = "ahmed" scope = "session"/>

         <c:if test="${!empty param.userName}">
         <sql:query dataSource = "${snapshot}" var = "result" sql="SELECT * FROM user WHERE first_name LIKE '%${param.userName}%' OR last_name LIKE '%${param.userName}%'"/>

            <!-- <c:if test="${result.rows != null}"> -->
                <table>
                  <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>User name</th>
                    <th>Password</th>
                  </tr>
                  <c:forEach var = "row" items = "${result.rows}">
                    <tr>
                        <td><c:out value="${row.first_name}"/></td>
                        <td><c:out value="${row.last_name}"/></td>
                        <td><c:out value="${row.user_name}"/></td>
                        <td><c:out value="${row.password}"/></td>
                    </tr>    
                  </c:forEach>
              <!-- </c:if> -->
            </c:if>
 </body>
</html>
