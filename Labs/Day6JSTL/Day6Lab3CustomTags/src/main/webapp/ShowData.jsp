<%@ page import="java.util.List" %> <%@ page import="com.utils.User" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Search form</title>
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
    <center>
      <form action="SearchServlet" method="GET">
        <h1>Search Form</h1>
        <h3>Please enter the first name, last name or part of any.</h3>
        <label for="user-name">Name : </label>
        <input type="text" name="userName" id="user-name" />
        <button type="submit">Search</button>
      </form>
      <c:if test="${requestScope.users != null}">
        <table>
          <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>User name</th>
            <th>Password</th>
          </tr>
          <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.getLastName()}"/></td>
                <td><c:out value="${user.getUserName()}"/></td>
                <td><c:out value="${user.getPassword()}"/></td>
            </tr>    
          </c:forEach>
      </c:if>
    </center>
  </body>
</html>
