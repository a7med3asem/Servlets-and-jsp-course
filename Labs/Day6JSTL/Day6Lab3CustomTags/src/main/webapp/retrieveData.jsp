<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" language="java" %> 
<%@ page import="com.utils.User" %> 
<%@ page import="jakarta.servlet.RequestDispatcher" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="mytag" uri="/WEB-INF/DoublerTLD.tld"%>

<html>
  <head>
    <title>Custom tags</title>
  </head>
  <body>
    <mytag:double number="12" />
  </body>
</html>
