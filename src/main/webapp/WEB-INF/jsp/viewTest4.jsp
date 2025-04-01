<%@ page import="springbootmvc.dto.CarDto" %><%--
  Created by IntelliJ IDEA.
  User: mike7
  Date: 2025-04-01
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String seq = (String) request.getAttribute("seq");
    CarDto carDto = (CarDto) request.getAttribute("carDto");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>viewTest3</h1>
<h4> seq : <%= seq %></h4>
<h1> CarDto</h1>
<h4> <%=carDto.getName()%></h4>
<h4> <%=carDto.getPrice()%></h4>
<h4> <%=carDto.getOwner()%></h4>
</body>
</html>
