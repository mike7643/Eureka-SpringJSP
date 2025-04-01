<%@ page import="springbootmvc.dto.CarDto" %><%--
  Created by IntelliJ IDEA.
  User: mike7
  Date: 2025-04-01
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("username");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>sessionTest2.jsp</h1>
<%
    if (username == null) {

%>
<h4>로그인 되어 있지 않습니다.</h4>

<%
    }else {
%>
<h4><%=username%> 이 로그인 되어 있습니다.</h4>
<%
        }
%>
</body>
</html>
