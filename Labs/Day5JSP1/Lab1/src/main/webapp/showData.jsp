<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <%--    <meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
    <title>Login data</title>
</head>
<body>
<jsp:useBean id="userBean" class="com.myBeans.UserBean" scope="request"/>
<h1>Welcome
    <jsp:getProperty name="userBean" property="userName"/>
</h1>
<br>
<h2>Your password is
    <jsp:getProperty name="userBean" property="password"/>
</h2>
</br>
</body>
</html>