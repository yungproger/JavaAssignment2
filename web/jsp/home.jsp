<%@ page import="models.Student" %>
<%@ page import="models.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 12.09.2020
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="homecss.css" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

    <%
    // getting all courses and user
    Student student = (Student) request.getAttribute("student");
    List<Course> courses = new ArrayList<>();
    courses.add(new Course(4,"Python Basics","Good course for beginners"));
        courses.add(new Course(5,"Java Basics","Good course for beginners"));
        courses.add(new Course(6,"PostgreSQL basics","Good course for beginners"));;
%>
<%@include file="header.jsp"%>
    <div class="main">
        <div class="c1"></div>
        <div class="text-center">
        <h3 class="p-2" style="font-family: Georgia">All Courses</h3>
        </div>
    <div class="container-fluid c2">
        <%-- List of all courses --%>
        <%for(Course course : courses){%>
            <div class="col-sm-4 c3">
                <div class="card">
                    <div class="card-inner">
                        <div class="header">
                            <h2><%=course.getCourseName()%></h2>
                        </div>
                        <div class="content">
                            <p><%=course.getDescription()%></p>
                            <%-- adding course to user's courses by sending get request to courseServlet --%>
                            <a href="<%=request.getContextPath()%>/courseServlet?id=<%=course.getId()%>">Add course</a>

                        </div>


                    </div>
                </div>
            </div>
        <%}%>
    </div>
    </div>
<%@include file="footer.jsp"%>




