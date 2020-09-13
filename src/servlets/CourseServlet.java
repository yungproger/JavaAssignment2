package servlets;

import models.Course;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CourseServlet")
public class CourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // getting course id from get request
        int id =Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        List<Course> courses = new ArrayList<>(student.getCourses()) ;

        try {
            // check for course id and adding it to user's courses
            if(id==4) {

                        courses.add(new Course
                                (id,"Python Basics","Good course for beginners"));

            }
            else if(id==5){
                courses.add(new Course(id,"Java Basics","Good course for beginners"));
            }
            else if(id==6){
                courses.add(new Course(id,"PostgreSQL basics","Good course for beginners"));
            }
            File file = new File("courses.txt");
            FileWriter myWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);



            int c = 0;
            // writing user's courses to txt file
            for(Course course : courses){
                if(c==3) {

                  bufferedWriter.write(course.getId() + " " + course.getCourseName() + " " + course.getDescription() + "\n");
                }

                c++;

            }

            bufferedWriter.close();
            request.setAttribute("courses",courses);

            request.getRequestDispatcher("/jsp/home.jsp").forward(request,response);
        }catch(Exception e){
            PrintWriter writer = response.getWriter();

            writer.append("Failed to add course");
            System.out.println("Failed to add course");
        }

    }
    @Override
    public String getServletInfo() {
        return "To interact with courses";
    }
}
