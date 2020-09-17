package servlets;

import models.Course;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Main")
public class Home extends HttpServlet {

    @Override
    public void init() throws ServletException {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(4,"Python Basics","Good course for beginners"));
        courses.add(new Course(5,"Java Basics","Good course for beginners"));
        courses.add(new Course(6,"PostgreSQL basics","Good course for beginners"));
        getServletContext().setAttribute("courses",courses);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // getting all courses and sending them to home.jsp page
        List<Course> courses = (List<Course>) getServletContext().getAttribute("courses");
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        request.setAttribute("student",student);
        request.setAttribute("courses",courses);
            request.getRequestDispatcher("/jsp/home.jsp").forward(request,response);



    }

    @Override
    public void destroy() {
        //  --- save into file
    }

    @Override
    public String getServletInfo() {
        return "To load courses";
    }
}
