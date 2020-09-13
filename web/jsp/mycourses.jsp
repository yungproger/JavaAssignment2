<%@ page import="models.Student" %>
<%@ page import="models.Course" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 12.09.2020
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
    List<Course> courses = (List<Course>) request.getAttribute("courses");

%>
<html>
<head>
    <title>My courses</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/mycourses.css">
    <link rel="stylesheet" href="mycourses.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>


<%@include file="header.jsp"%>
    <div class="d-flex flex-row c1">
        <div class="sidenav border-right bg-light c2 ">
            <div class="login-main-text profile text-center">
                <h5 class="p-3"><%out.print(student.getFirstName() + " " + student.getLastName());%></h5>
            </div>
        </div>
        <div class="main c23 border-left border-dark" >
            <div class="c24">
                <div class="text-center py-5 text-light bg-dark mb-4">
                <h3>Available courses</h3>
                </div>
                <div class="d-flex flex-column c3 border-light w-100 ">
                    <%for(Course course : courses){%>
                    <div class="c4 border border-light card">
                        <div class="card-inner">
                        <div class="card-header"><h5><%=course.getCourseName()%></h5></div>
                       <p><%=course.getDescription()%></p>
                        </div>
                    </div>

                    <%}%>
                </div>
            </div>
        </div>
    </div>
<%@include file="footer.jsp"%>
