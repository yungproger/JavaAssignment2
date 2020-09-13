<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 12.09.2020
  Time: 14:33
  To change this template use File | Settings | File Templates.
  <%=student.getUsername()%>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-info">
    <a class="navbar-brand text-light" href="<%=request.getContextPath()%>/home">True Courses</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse justify-content-end">
        <ul class="navbar-nav">
            <li class="nav-item">
                <%-- Link to studentServlet which loads student's data and redirects to its profile --%>
                <a href="<%=request.getContextPath() %>/studentServlet" class="nav-link text-light">My Profile</a>
            </li>
        </ul>
    </div>
</nav>

