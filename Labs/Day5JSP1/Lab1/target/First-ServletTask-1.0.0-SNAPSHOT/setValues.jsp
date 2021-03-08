<jsp:useBean id="userBean" class="com.myBeans.UserBean" scope="request"/>

<%--<%--%>
<%--    String userName = request.getParameter("userName");--%>
<%--    String password = request.getParameter("password");--%>
<%--%>--%>

<jsp:setProperty name="userBean" property="*"/>
<jsp:forward page="showData.jsp"/>
<%--<jsp:setProperty name="userBean" property="userName" value="<%=userName%>"/>--%>
<%--<jsp:setProperty name="userBean" property="password" value="<%=password%>"/>--%>