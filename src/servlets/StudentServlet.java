package servlets;

import models.Course;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private List<Course> loadCourses() throws FileNotFoundException {
        // loading all user's courses from file
        File file = new File("courses.txt");
        List<Course> courses = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String [] parts = data.split(" ");
            courses.add(new Course(Integer.parseInt(parts[0]),parts[1] + " " + parts[2],""));

        }
        return courses;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // getting user
        Student student = (Student) session.getAttribute("student");
        List<Course> courses = loadCourses();


        request.setAttribute("student",student);
        request.setAttribute("courses",courses);
        // sending user's courses to mycourses.jsp page
        request.getRequestDispatcher("/jsp/mycourses.jsp").forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return "To interact with user/student";
    }
}
