package servlets;

import models.Course;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //user initializing
      Student student = new Student(1,"Carl","Johnson","cjohnson","carl",
                Arrays.asList(new Course(0,"Advanced Java","Good course for Java Developers"),
                        new Course(1,"Software Design Patterns","Good course"),
                        new Course(2,"DBMS","DataBase Management System Course")));
        getServletContext().setAttribute("student",student);

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Student student = (Student) getServletContext().getAttribute("student");
        PrintWriter writer = response.getWriter();
        String studentUsername = getServletContext().getInitParameter("Username");
        String studentPassword = getServletContext().getInitParameter("Password");
        if(username.equals(studentUsername)){
            if(password.equals(studentPassword)) {
                // Session
                HttpSession session = request.getSession();

                session.setAttribute("student",student);
                response.sendRedirect(request.getContextPath() + "/home");
            }else{
                writer.append("Wrong password");
            }
        }else{
            writer.append("Wrong username");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "This servlet is for Login System";
    }
}
