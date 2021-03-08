<%@ page import="Models.UserModel" %>
<html>
<head>
    <title>Show data</title>
</head>
<body>
<%
    UserModel userModel = (UserModel) request.getAttribute("user");
%>
<h2>Data stored</h2>
<br>
<%=userModel.getUserName()%>
<br>
<%=userModel.getEmail()%>
<br>
<%=userModel.getPassword()%>
</body>
</html>
