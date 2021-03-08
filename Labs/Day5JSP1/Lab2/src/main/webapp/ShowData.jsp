<%@ page import="java.util.List" %>
<%@ page import="com.utils.User" %>

<html>
<head>
    <title>Search form</title>
    <style>
        tr th{
            font-weight:bold;
        }
        tr th, tr td{
            padding:5px;
        }
        th{
            border: 5px solid #C1DAD7;
        }
        td{
            border: 5px solid #C1DAD7;
        }
        .c1{
            background:#4b8c74;
        }
        .c2{
            background:#74c476;
        }
        .c3{
            background:#a4e56d;
        }
        .c4{
            background:#cffc83;
        }
    </style>
</head>
<body>
<center>
    <form action="SearchServlet" method="POST">
        <h1>Search Form</h1>
        <h3>Please enter the first name, last name or part of any.</h3>
        <label for="user-name">Name : </label>
        <input type="text" name="userName" id="user-name"/>
        <button type="submit">Search</button>
    </form>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        if (users != null) {%>
    <table>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>User name</th>
            <th>Password</th>
        </tr>
        <%for (User user : users) {%>
        <tr>
            <td><%=user.getFirstName()%></td>
            <td><%=user.getLastName()%></td>
            <td><%=user.getUserName()%></td>
            <td><%=user.getPassword()%></td>
        </tr>
        <%}%>
    </table>

    <%}%>
</center>

</body>
</html>
